package LibraryManagementSystem;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket ss;
    Socket socket;
    int port = 4333;

    DataInputStream dis;
    DataOutputStream dos;

    public void Login() {
        try {
            System.out.println("Server - is running");
            ss = new ServerSocket(port);

            while (true) {
// here the server will open connection with client to get username and password
                socket = ss.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                String x = dis.readUTF(); //username
                String y = dis.readUTF(); //password
                System.out.println(x + y);

                //closing input stream and socket
                dis.close();
                ss.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
