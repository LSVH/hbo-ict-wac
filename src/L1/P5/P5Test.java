package L1.P5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class P5Test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new TestThread("Thread " + i).start();
        }
    }

    static class TestThread extends Thread {

        public TestThread(String name) {
            super(name);
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                Socket s = new Socket("localhost", 4711);
                OutputStream os = s.getOutputStream();
                String message = threadName + " is pending...\r\n\r\n";
                os.write(message.getBytes());
                os.flush();
                InputStream is = s.getInputStream();
                while (is.read() != -1) ;
                s.close();
            } catch (Exception e) {
                System.out.println("Failed: " + threadName);
            }
        }
    }
}