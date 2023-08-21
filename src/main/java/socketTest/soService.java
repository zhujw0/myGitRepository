package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端
 */
public class soService {

    public static void main(String[] args) {


    try (
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            System.out.println("客户端连接");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("消息:" + inputLine);
                out.println(inputLine);
            }

        } catch (
        IOException e) {
            System.out.println(
                    "Exception caught when trying to listen on port " + 8888 + " or listening for a connection");
            System.out.println(e.getMessage());
        }
            System.out.println("服务退出");

    }











}
