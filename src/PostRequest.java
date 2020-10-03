import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PostRequest extends Request {
    public PostRequest() {
        super();
    }

    public String getRequestString() {
        return super.getRequestString();
    }

    public void setRequestString(String path, String query, String host, String[] headers, String inlineData) {
        super.setHeaderString(headers);
        String headerString = super.getHeaderString();

        // Add Content-length header for body
        if (inlineData != null) {
            headerString = headerString + "Content-length:" + inlineData.length() + "\r\n";
        }

        String extra = headerString + "\r\n" + inlineData;
        super.setRequestString("POST", path, query, host, extra);
    }

    public String fileDataToString(File f) throws IOException {
        String fileString = "";
        BufferedReader buffReader = new BufferedReader(new FileReader(f));
        String line;
        while ((line = buffReader.readLine()) != null) fileString = fileString + line + ", ";
        fileString = fileString.substring(0, fileString.length() - 2);
        buffReader.close();

        return fileString;
    }
}