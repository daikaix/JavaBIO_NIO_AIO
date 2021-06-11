package IOExample.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        final String DEFAULT_SERVER_HOST = "127.0.0.1";
        final int DEFAULT_SERVER_PORT = 8888;
        Socket socket = null;

        socket = new Socket(DEFAULT_SERVER_HOST,DEFAULT_SERVER_PORT);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //等待用户输入信息
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = consoleReader.readLine();
            //发送消息
            writer.write(input + "\n");
            writer.flush();
            //回复消息
            String msg = reader.readLine();
            if (msg != null) {
                System.out.println(msg);
            }
            if (input.equals("close")){
                break;
            }
        }
        socket.close();
        writer.close();
    }
}
