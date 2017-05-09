package SocketTest01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test01 {

	public void go(){
		try {
			Socket s=new Socket("127.0.0.1",4242);
			InputStreamReader inre=new InputStreamReader(s.getInputStream());
			BufferedReader reader=new BufferedReader(inre);
			
			String advice = reader.readLine();
			System.out.println("Today you should:"+advice);
			reader.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test01 test01=new Test01();
		test01.go();
	}

}
