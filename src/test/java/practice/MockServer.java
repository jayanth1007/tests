package practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class MockServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new MockServer.MyServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
    
    public static class MyServerSocket extends ServerSocket {

		public MyServerSocket(int port) throws IOException {
			super(port);
//			port = getLocalPort();
//			  //fill backlog queue by this request so consequent requests will be blocked
//			  new Socket().connect(getLocalSocketAddress());
		}

		@Override
		public Socket accept() throws IOException {
			// TODO Auto-generated method stub

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Socket socket = super.accept();
			return socket;
		}
		
		
    	
    }
    
    class FooSocket extends Socket {
    	
    }
}