package com.mySocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket =new ServerSocket(12345);
			while(true){
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "客户端连接到本机12345端口");
				chatSocket cd =new chatSocket(socket);
						cd.start();
						ChatManager.getChatManager().add(cd);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
