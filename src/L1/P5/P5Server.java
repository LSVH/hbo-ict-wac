package L1.P5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class P5Server {
    private static class MyServlet extends Thread {
        private Socket s;

        public MyServlet(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                Thread.sleep(1000);

                Scanner sc = new Scanner(s.getInputStream());

                while (sc.hasNextLine()) {
                    String r = sc.nextLine();

                    if ("".equals(r)) {
                        System.out.println("SUCCESS");
                    } else {
                        System.out.println("Message from the client: " + r);
                    }
                }

                sc.close();

            } catch (Exception e) {

                System.err.println(e);

            }
        }
    }

    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4711);
        while (true) {
            MyServlet ms = new MyServlet(ss.accept());
            ms.start();
        }
    }
}