package TCPAndUDP.UDP_Part.client;

import TCPAndUDP.UDP_Part.client.bean.ServerInfo;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        ServerInfo info = ClientSearcher.searchServer(10000);
        System.out.println("Server:" + info);

        if (info != null) {
            try {
                TCPClient.linkWith(info);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
