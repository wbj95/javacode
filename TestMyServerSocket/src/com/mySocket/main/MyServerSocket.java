package com.mySocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MyServerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~65535
		new ServerListener().start();
	}

}
