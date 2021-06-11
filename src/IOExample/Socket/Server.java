package IOExample.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        final int DEFAULT_PORT = 8888;
        ServerSocket serverSocket = null;

        // 绑定监听端口
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server start! 8888");

            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Client: "+socket.getPort()+" connected!");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );

                while (true) {
                    // 读取客户端发送的消息
                    String msg = reader.readLine();
                    if (msg != null) {
                        System.out.println("Client[" + socket.getPort() + "]:" + msg);
                        writer.write("服务器：" + msg + "\n");
                        writer.flush();

                        if (msg.equals("close")) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
