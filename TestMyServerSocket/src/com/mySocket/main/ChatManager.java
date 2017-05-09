package com.mySocket.main;

import java.util.Vector;

//µ¥ÀýÄ£Ê½
public class ChatManager {
	private ChatManager(){}
	private final static ChatManager cm = new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	Vector <chatSocket> vector = new Vector<chatSocket>();
	public void add(chatSocket c){
		vector.add(c);
	}
	public void publicsh(chatSocket cd , String out){
		for (int i = 0; i < vector.size(); i++) {
			chatSocket csChatSocket = vector.get(i);
			if(!cd.equals(csChatSocket)){
				csChatSocket.out(out);
			}
		}
	}
}
