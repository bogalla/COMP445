public class Request {
    private boolean isVerbose;
    private String headerString;
    private String requestString;

    public Request() {
        this.isVerbose = false;
        this.headerString = "";
        this.requestString = "";
    }

    public boolean getIsVerbose() {
        return this.isVerbose;
    }

    public void setIsVerbose(boolean isVerbose) {
        this.isVerbose = isVerbose;
    }

    public String getHeaderString() {
        return this.headerString;
    }

    // Converts array of headers to a single string
    public void setHeaderString(String[] headers) {
        for (int i=0; i < headers.length; i++) {
            if (headers[i] != null){
                this.headerString =  this.headerString + headers[i] + "\r\n";
            }
        }
    }

    public String getRequestString() {
        return this.requestString;
    }

    public void setRequestString(String type, String path, String query, String host, String headerString) {
        this.requestString = type + " " + path + "?" + query + " HTTP/1.1\r\nHost: " + host + "\r\nConnection: close" + "\r\n" + headerString + "\r\n\r";
    }
}