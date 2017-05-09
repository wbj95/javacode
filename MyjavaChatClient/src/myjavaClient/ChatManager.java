package myjavaClient;

import myjavachatclient.view.MainWindow;

public class ChatManager {
	private  ChatManager(){}
	private static final ChatManager instance = new ChatManager();
	public static ChatManager getCM(){
		return instance;
	}
	
	MainWindow window;
	
	public void setWindow(MainWindow window){
		this.window=window;
		window.appendText("�ı����Ѿ���chatManager��");
	}
	
	public void connect(String ip){
		new Thread().start();
	}
	public void send(String out){}
}
