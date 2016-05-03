package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.Button;

public class ButtonControl extends JButton {
	
	private List<Button> buttons;

	public ButtonControl(int h,int w){
		Button trash = new Button(20, 0, 0);
		Button bucket = new Button(0, h-150, 1);
		Button menu = new Button(w-160,0,2);
		Button help = new Button(w-250,0,3);
		Button mag = new Button(200,0,4);
		
		//Will need to add more buttons later
		Button[] bns ={trash,bucket,menu,help,mag};	
		buttons = new ArrayList<Button>();
		for(Button b: bns){
			buttons.add(b);
		}
	}
	
	public List<Button> getButtons(){
		return buttons;
	}
}
