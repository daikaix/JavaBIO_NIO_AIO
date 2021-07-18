import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.SocketException;

public class UDPSearcher {
    public static void main(String[] args) throws IOException {
        System.out.println("start");

        //搜索自动分配端口
        DatagramSocket ds = new DatagramSocket();


        //发送数据
        String requestData = "Hello";
        byte[] requestDataBytes = requestData.getBytes();

        DatagramPacket requestPacket = new DatagramPacket(requestDataBytes,
                requestDataBytes.length);

        // 本机20000端口
        requestPacket.setAddress(Inet4Address.getLocalHost());
        requestPacket.setPort(20000);
        ds.send(requestPacket);

        //构建接受实体
        final byte[] buf = new byte[512];
        DatagramPacket receivePack = new DatagramPacket(buf,buf.length);

        //接受
        ds.receive(receivePack);

        //打印数据
        String ip = receivePack.getAddress().getHostAddress();
        int port = receivePack.getPort();
        int dataLen = receivePack.getLength();
        String data = new String(receivePack.getData(),0,dataLen);
        System.out.println("receive from ip:"+ip+"\tport:"+port+"\tdata:"+data);



        System.out.println("Finished!");
        ds.close();
    }
}
