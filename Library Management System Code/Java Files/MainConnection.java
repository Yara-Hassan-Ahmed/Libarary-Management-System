package LibraryManagementSystem;

public class MainConnection {

    // this class is to run client and server on different thread
    // to work in the same time to open connection
    Server s = new Server();
    Client c = new Client();

    // this method will take username and password and open connection between server and client
    // and send data to client
    public void Login(String x, String y) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                s.Login();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                c.Login(x, y);
            }
        }).start();
    }
}
