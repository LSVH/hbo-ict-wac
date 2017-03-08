package L1.P4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class P4Server {
    private static class MyServlet extends Thread {
        private Socket s;

        public MyServlet(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                Scanner sc = new Scanner(s.getInputStream());
                while (true) {
                    String r = sc.nextLine();

                    if ("".equals(r)) {
                        System.out.println("SUCCES");
                        PrintWriter pw = new PrintWriter(s.getOutputStream());
                        pw.print("SUCCESS");
                        pw.flush();
                        break;
                    } else {
                        System.out.println("Message from the client: " + r);
                    }

                    if ("stop".equals(r)) {
                        break;
                    }
                }
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
    }

    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4711);
        MyServlet ms = new MyServlet(ss.accept());

        ms.start();
        ss.close();
    }
}