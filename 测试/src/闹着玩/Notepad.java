package ÄÖ×ÅÍæ;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Notepad {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MyNotepad() ;
	}

}