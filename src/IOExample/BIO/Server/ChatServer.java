package IOExample.BIO.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    private int DEFAULT_PORT = 8888;
    private final String QUIT = "quit";

    private ServerSocket serverSocket;
    private Map<Integer,Writer> connectedClients;

    private ChatServer(){
        connectedClients = new HashMap<>();
    }

    public synchronized void addClient(Socket socket) throws IOException {
        if(socket != null){
            int port = socket.getPort();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            connectedClients.put(port,writer);
            System.out.println(port+"上线！");
        }
    }

    public synchronized void removeClient(Socket socket) throws IOException {
        if (socket!=null){
            int port = socket.getPort();
            if (connectedClients.containsKey(port)){
                connectedClients.get(port).close();
            }
            connectedClients.remove(port);
            System.out.println(port+"下线！");
        }
    }

    public synchronized void forwardMessage(Socket socket, String fwdMsg) throws IOException {
        for (Integer id: connectedClients.keySet()){
            if (!id.equals(socket.getPort())){
                Writer writer = connectedClients.get(id);
                writer.write(fwdMsg);
                writer.flush();
            }
        }
    }

    public boolean readyToQuit(String msg){
        if (msg.equals(QUIT)){
            return true;
        }
        return false;
    }

    public synchronized void close(){
        if (serverSocket!=null){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("监听端口");

            while (true){
                Socket socket = serverSocket.accept();
                //为其创建ChatHandler线程
                new Thread(new ChatHandler(this,socket)).start();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            close();
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start();
    }
}
