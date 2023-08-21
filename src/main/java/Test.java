
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//服务器端
public class Test  extends Thread {

    private ServerSocket serverSocket;








    public Test(int port) throws IOException{

        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

//    public void run(){
//               while(true){
//                    try {
//                        System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
//                        Socket server = serverSocket.accept();
//                        System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
//                        DataInputStream in = new DataInputStream(server.getInputStream());
//                        System.out.println(in.readUTF());
//                        DataOutputStream out = new DataOutputStream(server.getOutputStream());
//                        out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
//                        server.close();
//                     }catch(SocketTimeoutException s){
//                    System.out.println("Socket timed out!");
//                    break;
//                }catch(IOException e) {
//                    e.printStackTrace();
//                    break;
//         }
//        }
//    }


public static void main ( String[] args ) {
    int[] arr  = new int[5];
    int[] arr3 = {1,2,3,4,5};
    int[] arr4 = new int[]{1,2,3,4,5}; //[]可以在变量名后面如：int arr2[] = new int[5];


}








}
//        int port = Integer.parseInt(args[0]);
//        try
//        {
//
//            Thread t = new Test(port);
//            t.run();
//
//
//        }catch(IOException e)
//        {
//            e.printStackTrace();
//        }



