package L1.P1;

import java.io.OutputStream;
import java.net.Socket;

class P1Client {
    public static void main(String[] arg) throws Exception {
        Socket s = new Socket("localhost", 4711);
        OutputStream os = s.getOutputStream();

        // De computer waarop de Server.java draait ontvangt het bericht hieronder:
        os.write("hello\n".getBytes());

        s.close();
    }
}