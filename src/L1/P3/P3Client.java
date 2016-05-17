package L1.P3;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class P3Client {
    public static void main(String[] arg) throws Exception {
        Socket s = new Socket("localhost", 4711);
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(s.getOutputStream());

        while (true) {
            System.out.print("Message the server: ");
            String r = sc.nextLine();

            r += "\n";

            pw.write(r);
            pw.flush();

            if ("stop\n".equals(r)) {
                break;
            }
        }

        sc.close();
        s.close();
    }
}