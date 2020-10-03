public class HelperStrings {

    public void help() {
        System.out.println("\nhttpc is a curl-like application but supports HTTP protocol only.");
        System.out.println("usage: httpc command [arguments]");
        System.out.println("\nThe commands are:");
        System.out.println("\tget\texecutes a HTTP GET request and prints the response.");
        System.out.println("\tpost\texecutes a HTTP POST request and prints the response.");
        System.out.println("\thelp\tprints this screen.");
        System.out.println("\nUse \"httpc help [command]\" for more information about a command.");
    }

    public void helpGet() {
        System.out.println("\nGet executes a HTTP GET request for a given URL.");
        System.out.println("usage: httpc get [-v] [-h key:value] URL");
        System.out.println("\n-v\tPrints the detail of the response such as protocol, status, and headers.");
        System.out.println("-h\tkey:value Associates headers to HTTP Request with the format 'key:value'.");
    }

    public void helpPost() {
        System.out.println("\nPost executes a HTTP POST request for a given URL with inline data or from file.");
        System.out.println("usage: httpc post [-v] [-h key:value] [-d inline-data] [-f file] URL");
        System.out.println("\n-v\tPrints the detail of the response such as protocol, status, and headers.");
        System.out.println("-h\tkey:value Associates headers to HTTP Request with the format 'key:value'.");
        System.out.println("-d\tstring Associates an inline data to the body HTTP POST request.");
        System.out.println("-f\tfile Associates the content of a file to the body HTTP POST request.");
        System.out.println("\nEither [-d] or [-f] can be used but not both.");
    }
}
