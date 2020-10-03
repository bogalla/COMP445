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

        // Initialization
        String userURL = args[args.length - 1];
        URL url = new URL(userURL);
        String query = url.getQuery() == null ? "" : url.getQuery();
        System.out.println("query: " + query);
        boolean isGetRequest = args[0].toLowerCase().equals("get");
        boolean isPostRequest = args[0].toLowerCase().equals("post");
        int numHeaders = 0;
        //counts the number of headers, with the -h
        for(int i = 0; i < args.length; i++ ){
            if (args[i].equals("-h")){
                numHeaders++;
            }
        }
        //array of headers
        String [] headerArray = new String [numHeaders];
        System.out.println("headers: " + headerArray.toString());

    }
}