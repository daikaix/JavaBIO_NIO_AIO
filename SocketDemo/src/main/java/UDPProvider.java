import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPProvider {
    public static void main(String[] args) throws IOException {
        System.out.println("start");

        //指定端口，接受数据
        DatagramSocket ds = new DatagramSocket(20000);

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

        //回送数据
        String responseData = "Receive:"+dataLen;
        byte[] responseDataBytes = responseData.getBytes();

        DatagramPacket responsePacket = new DatagramPacket(responseDataBytes,
                responseDataBytes.length,receivePack.getAddress(),receivePack.getPort());

        ds.send(responsePacket);

        System.out.println("Finished!");
        ds.close();
    }
}
