import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String args[]) {
		try(ServerSocket server=new ServerSocket(7777);){
			
			while(true) {
				
				Socket client=server.accept();
				Multiclient multiclient=new Multiclient(client);
				//m. makeclientfunction();
				multiclient.start();
				
			}
		}//close server
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
