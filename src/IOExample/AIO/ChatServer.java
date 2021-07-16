package IOExample.AIO;

import IOExample.AIO.EchoAIO.Client;
import IOExample.AIO.EchoAIO.Server;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static final String QUIT = "quit";
    final String LOCALHOST = "localhost";
    private static int DEFAULT_PORT = 8888;
    private static int BUFFER = 1024;
    private static int THREADPOOL_SIZE = 8;

    private AsynchronousChannelGroup channelGroup;
    private AsynchronousServerSocketChannel serverChannel;
    private List<ClientHandler> connectedClients;
    private Charset charset = Charset.forName("UTF-8");
    private int port;

    private ChatServer(){
        this(DEFAULT_PORT);
    }

    private ChatServer(int port){
        this.port = port;
        connectedClients = new LinkedList<>();
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

    private void start(){
        try {
            ExecutorService service = Executors.newFixedThreadPool(THREADPOOL_SIZE);
            channelGroup = AsynchronousChannelGroup.withThreadPool(service);
            serverChannel = AsynchronousServerSocketChannel.open(channelGroup);
            serverChannel.bind(new InetSocketAddress(LOCALHOST,port));
            System.out.println("监听端口："+port);

            while (true){
                serverChannel.accept(null, new AcceptHandler());
                System.in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(serverChannel);
        }
    }

    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel,Object>{

        @Override
        public void completed(AsynchronousSocketChannel result, Object attachment) {
            if (serverChannel.isOpen()){
                serverChannel.accept(null, this);
            }
            AsynchronousSocketChannel clientChannel = result;
            if (result.isOpen() && clientChannel != null){
                ClientHandler handler = new ClientHandler(clientChannel);

                ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
                //将新用户添加到用户列表, List => ClientHandler
                addClient(handler);
                clientChannel.read(buffer,buffer,handler);
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("连接失败："+exc);
        }
    }

    private class ClientHandler implements CompletionHandler<Integer,Object>{
        private AsynchronousSocketChannel clientChannel;

        ClientHandler(AsynchronousSocketChannel clientChannel){
            this.clientChannel = clientChannel;
        }
        @Override
        public void completed(Integer result, Object attachment) {
            ByteBuffer buffer = (ByteBuffer)attachment;
            if (buffer != null){
                //read调用
                if (result <= 0){
                    //客户端异常，移除客户列表
                    connectedClients.remove(this);
                } else {
                    buffer.flip();
                    String fwdMsg = receive(buffer);
                    System.out.println(fwdMsg);
                    forwardMessage(clientChannel,fwdMsg);
                }
            }else {
                //发送出去了
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {

        }
    }

    private String receive(ByteBuffer buffer){
        return String.valueOf(charset.decode(buffer));
    }

    private void forwardMessage(AsynchronousSocketChannel clientChannel,String fwdMsg){
        for (ClientHandler handler:connectedClients){
            if (handler.clientChannel.equals(clientChannel)){
                continue;
            }
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(charset.encode(fwdMsg));
            buffer.flip();
            clientChannel.write(buffer,null,handler);
        }
    }

    private void addClient(ClientHandler handler){
        connectedClients.add(handler);

    }
}

