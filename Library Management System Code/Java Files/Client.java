package LibraryManagementSystem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    int port = 4333;

    // this method will get username and password form gui and open connection with server
    // and send this data to server to login
    public void Login(String x, String y) {

        try {
            System.out.println("Client - connected to server");
            while (true) {
                socket = new Socket("Localhost", port);
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(x);
                dos.writeUTF(y);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
