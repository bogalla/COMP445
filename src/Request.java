public class Request {
    private boolean isVerbose;
    private String requestString;

    public Request() {
        this.isVerbose = false;
        this.requestString = "";
    }

    public boolean getIsVerbose() {
        return this.isVerbose;
    }

    public void setIsVerbose(boolean isVerbose) {
        this.isVerbose = isVerbose;
    }

    public String getRequestString() {
        return this.requestString;
    }

    public void setRequestString(String type, String path, String query, String host) {
        this.requestString = type + " " + path + "?" + query + " HTTP/1.1\r\nHost: " + host + "\r\nConnection: close" + "\r\n\r";
    }
}