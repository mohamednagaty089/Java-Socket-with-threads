import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

public class Multiclient extends Thread{

	private Socket client;
	public Multiclient(Socket client) {
		this.client=client;
	}
	@Override
	public void run() {
		try {
			makeclientfunction();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void makeclientfunction() throws IOException {
		try(InputStream clientdata=client.getInputStream();
				OutputStream serverdata=client.getOutputStream();
				Reader clientinput=new InputStreamReader(clientdata);
				BufferedReader fromclient=new BufferedReader(clientinput);
				PrintWriter toclientprinter=new PrintWriter(serverdata);){
			
			    String clientname=fromclient.readLine();
			    System.out.println(clientname);
			    while(true) {
			    	String message=fromclient.readLine();
			    	if(message.toLowerCase().trim().equals("bye"))break;
			    	System.out.println(message);
			    }

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			client.close();
			System.out.println("connection close");
		}
		
	}

}
