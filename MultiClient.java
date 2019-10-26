package id;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClient extends Thread{
	Socket client;
	MultiClient(Socket sock){
		client = sock;
	}
	public void run() {
		while(true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String s = "";
				if ((s = br.readLine()) != null) {
					System.out.println(new Calculator().Calc(s));
					OutputStream out = client.getOutputStream();
					String result = new Calculator().Calc(s);
					out.write(result.getBytes(),0,result.length());	
				}
				
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
