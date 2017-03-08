package L1.P2;

import java.io.PrintWriter;
import java.net.Socket;

class P2Client {
    public static void main(String[] arg) throws Exception {
        Socket s = new Socket("localhost", 4711);
        PrintWriter pw = new PrintWriter(s.getOutputStream());

        pw.write("Message to the server.");

        pw.flush();
        s.close();
    }
}