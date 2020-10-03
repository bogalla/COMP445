import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpClient {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private String ipAddress;
    private int port;

    public HttpClient() {
        ipAddress = "";
        port = -1;
    }

    public String getIPAddress() {
        return this.ipAddress;
    }

    public void setIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void start(String ipAddress, int port) throws IOException {
        setIPAddress(ipAddress);
        setPort(port);
        socket = new Socket(ipAddress, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Connected :)");
    }

    public void stop() throws IOException {
        input.close();
        output.close();
        socket.close();
        System.out.println("Connection closed :)");
    }

    public void sendRequest(String request, boolean isVerbose) throws IOException {
        String response;
        int count = 0;
        while ((response = input.readLine()) != null) {
            // Output when not verbose and when verbose respectively
            System.out.println(response);
            count++;
        }
        output.flush();
    }
}
