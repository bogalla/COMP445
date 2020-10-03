public class GetRequest extends Request {
    public GetRequest() {
        super();
    }

    public String getRequestString() {
        return super.getRequestString();
    }

    public void setRequestString(String path, String query, String host, String[] headers) {
        super.setRequestString("GET", path, query, host);
    }
}