package L1.P2;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class P2Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4711);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        Scanner sc = new Scanner(is);

        while (sc.hasNextLine()) {
            System.out.print(sc.nextLine());
        }

        sc.close();
        ss.close();
    }
}