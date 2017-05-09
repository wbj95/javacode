package ≤‚ ‘;

import java.io.IOException;

import javax.swing.JOptionPane;

public class PhonebookApp {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String again="y";
		
		Phonebook phonebook=new Phonebook();
		while(again.matches("[y|Y]")){
			String choice=phonebook.makeChoice();
			switch(Integer.parseInt(choice)){
			case 1:phonebook.addRecord();
					break;
			case 2:phonebook.search();
					break;
			case 3:phonebook.deleteRecord();
			break;
			case 4:phonebook.goodBye();
			}
			again=JOptionPane.showInputDialog(null,"continue?(y|Y):");
		}
		phonebook.goodBye();
	}
	
}
