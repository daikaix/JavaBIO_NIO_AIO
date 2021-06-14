package IOExample.BIO.Server;

import IOExample.Socket.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class ChatServer {
    private int DEFAULT_PORT = 8888;
    private final String QUIT = "quit";

    private ServerSocket serverSocket = null;
    private HashMap<Integer, Writer> connectedClients;
//    private HashMap<Integer, List<Integer>> friendsList;
//    private HashMap<Integer, List<String>> msgList;

    public ChatServer(){
        connectedClients = new HashMap<>();

    }

    public void addClient(Socket socket) throws Exception{
        if (socket!= null) {
            int port = socket.getPort();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            connectedClients.put(port,writer);
            System.out.println(port+"已连接!");
        }
    }

    public void removeClient(Socket socket) throws Exception{
        if (socket != null) {
            int port = socket.getPort();
            if (connectedClients.containsKey(port)){
                connectedClients.get(port).close();
            }
            connectedClients.remove(port);
            System.out.println(port+"已断开!");
        }
    }
}
