package IOExample.NIO.Server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static int DEFAULT_PORT = 8888;
    private static final String QUIT = "quit";
    private static final int BUFFER = 1024;

    private ServerSocketChannel server;
    private Selector selector;
    private ByteBuffer rBuffer = ByteBuffer.allocate(BUFFER);
    private ByteBuffer wBuffer = ByteBuffer.allocate(BUFFER);
    private Charset charset = Charset.forName("UTF-8");
    private int port;

    private ChatServer(){
        this(DEFAULT_PORT);
    }

    private ChatServer(int port){
        this.port = port;
    }


    public boolean readyToQuit(String msg){
        if (msg.equals(QUIT)){
            return true;
        }
        return false;
    }

    private static void close(Closeable closeable){
        if (closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void handles(SelectionKey key) throws IOException {
        //ACCEPT事件
        if (key.isAcceptable()){
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            client.register(selector,SelectionKey.OP_READ);
            System.out.println(getClientName(client) + "已连接");
        }
        //READ事件
        else if (key.isReadable()){
            SocketChannel client = (SocketChannel) key.channel();
            String fwdMsg = receive(client);
            if (fwdMsg.isEmpty()){
                // 客户端异常
                key.cancel();
                selector.wakeup();
            } else {
                System.out.println(getClientName(client) + ":" + fwdMsg);
                forwardMessage(client, fwdMsg);
                if (readyToQuit(fwdMsg)){
                    key.cancel();
                    selector.wakeup();
                    System.out.println(getClientName(client) + "已断开");
                }
            }
        }
    }

    public String receive(SocketChannel client) throws IOException {
        rBuffer.clear();
        while((client.read(rBuffer))>0);
        rBuffer.flip();
        return String.valueOf(charset.decode(rBuffer));
    }

    private void forwardMessage(SocketChannel client,String fwdMsg) throws IOException {
        for (SelectionKey key: selector.keys()){
            Channel connectedClient = key.channel();
            if (connectedClient instanceof ServerSocketChannel){
                continue;
            }
            if (key.isValid() && !client.equals(connectedClient)){
                wBuffer.clear();
                wBuffer.put(charset.encode(getClientName(client)+":"+fwdMsg));
                wBuffer.flip();
                while (wBuffer.hasRemaining()){
                    ((SocketChannel)connectedClient).write(wBuffer);
                }
            }
        }
    }

    public void start(){
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.socket().bind(new InetSocketAddress(port));

            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听"+port+"...！");

            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for( SelectionKey key: selectionKeys){
                    //处理被触发的事件
                    handles(key);
                }
                selectionKeys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(selector);
        }
    }

    public String getClientName(SocketChannel client){
        return "客户端["+client.socket().getPort()+"]";
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer(7777);
        server.start();
    }
}
