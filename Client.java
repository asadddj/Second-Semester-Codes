import java.io.*;
import java.net.*;
import java.util.Scanner;
public class TCPclient {
    public String host;
    public int port;
    public PrintWriter out;
    public Socket socket;
    public Scanner scanner;
    public BufferedReader in;
    public void client(String host,int port){
        this.host = host;
        this.port = port;
        this.scanner = new Scanner(System.in);
    }   public void connect() throws IOException{
        Socket socket = new Socket();
        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("connect" + host + port);
    } public void start() throws IOException{
        while (true) {
            System.out.println("ENTER COMMAND LINE  (diff,get,filename,quit)");
            String Command = scanner.nextLine(); 
            System.out.println(Command);
            if(Command.equalsIgnoreCase("quit")){
                readAllFromServer();
                disconnect();
                break;
            }readResponse();   
        }
    }
     private void readResponse() throws IOException{
        String response;
        while((response=in.readLine())!=null){
            if(response.equals("EOF"))break;
            System.out.println("server" +  response);
        }
    }
private void disconnect() throws IOException{
    if(socket!=null && ! socket.isClosed()){
        socket.close();
    }System.out.println("Disconnected from server");
}public static void SendQuitCommand(){

    try{
        Socket socket = new Socket("localhost" , 9090);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        System.out.println("quit");

    }catch(IOException e){
        System.out.println("Could not send quit to server");
    }
}public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        while(true){
            try {
                System.out.println("ENTER IP ADDRESS");
                String  host = inp.nextLine();
                if(host.equalsIgnoreCase("quit")){
                    SendQuitCommand();
                    break;

                }System.out.println("ENTER PORT NUMBER");
                int port = Integer.parseInt(inp.nextLine());
                Client client = new Client (host,port);
                client.connect();
                client.start();

            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }inp.close();
    }

    private void readAllFromServer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


