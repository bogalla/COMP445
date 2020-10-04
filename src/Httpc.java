import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Httpc {

    public static void main(String[] args) throws IOException {
        //Start with help scenario
        HelperStrings helperStrings = new HelperStrings();

        //HELP
        if (args.length == 1) {
            if( args[0].equals("help")) {
                helperStrings.help();
            }
            return;
        }
        if(args[0].toLowerCase().equals("help") && args[1].toLowerCase().equals("get")) {
            helperStrings.helpGet();
            return;
        } else if(args[0].toLowerCase().equals("help") && args[1].toLowerCase().equals("post")) {
            helperStrings.helpPost();
            return;
        }

        // help scenarios done

        // Initialization
        String userURL = args[args.length - 1];
        URL url = new URL(userURL);
        String query = url.getQuery() == null ? "" : url.getQuery();
        HttpClient client = new HttpClient();
        GetRequest get = new GetRequest();
        PostRequest post = new PostRequest();
        boolean isGetRequest = args[0].toLowerCase().equals("get");
        boolean isPostRequest = args[0].toLowerCase().equals("post");
        int numHeaders = 0;
        //counts the number of headers, with the -h
        for(int i = 0; i < args.length; i++ ){
            if (args[i].equals("-h")){
                numHeaders++;
            }
        }
        // array of headers
        String [] headerArray = new String [numHeaders];

        // GET & POST scenario
        if (args.length == 2){
            if(isGetRequest) {
                get.setRequestString(url.getPath(), query, url.getHost(), headerArray);
            }
            else if(isPostRequest){
                post.setRequestString(url.getPath(), query, url.getHost(), headerArray, "");
            }
        }

        // deal with verbose
        for(int i = 0; i < args.length; i++) {
            if(args[i].contains("-v")){
                if (isGetRequest){
                    get.setIsVerbose(true);
                    get.setRequestString(url.getPath(), query, url.getHost(), headerArray);
                    break;
                } else if (isPostRequest){
                    post.setIsVerbose(true);
                    post.setRequestString(url.getPath(), query, url.getHost(), headerArray, "");
                    break;
                }
                System.out.println("call verbose");
                return;
            }
        }

        // deal with headers
        for(int i = 0; i < args.length; i++) {
            if(args[i].contains("-h")){
                for (int x = 0; x < numHeaders; x++){
                    headerArray[x] = args[i+1];
                    if(isGetRequest){
                        get.setRequestString(url.getPath(), query, url.getHost(), headerArray);
                    } else if (isPostRequest){
                        post.setRequestString(url.getPath(), query, url.getHost(), headerArray, "");
                    }
                    break;
                }
            }
        }

        //deal with file and inline
        // will call only the first argument provided (never both)
        for(int j = 0; j < args.length; j++){
            for(int i = 0; i < args.length; i++){
                if (args[i].contains("-d") ^ args[j].contains("-f")) {
                    if (args[j].contains("-d") ^ args[i].contains("-f")) {
                        if( args[i].contains("-d")){
                            if (isPostRequest) {
                                post.setRequestString(url.getPath(), "", url.getHost(), headerArray, args[i+1]);
                            }
                            i++;
                            j++;
                            break;
                        }
                        if (args[j].equals("-f")) {
                            if (isPostRequest) {
                                File f = new File("file.txt");
                                post.setRequestString(url.getPath(), "", url.getHost(), headerArray, post.fileDataToString(f));
                            }
                            System.out.println("call file");
                            j++;
                            i++;
                            break;
                        }
                    }
                }
            }
        }

        //Creates a connection and sends the request
        client.start(url.getHost(), 80);
        if (isGetRequest) {
            client.sendRequest(get.getRequestString(), get.getIsVerbose());
        } else if (isPostRequest) {
            client.sendRequest(post.getRequestString(), post.getIsVerbose());
        }
        client.stop();
    }
}