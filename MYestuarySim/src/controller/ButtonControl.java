package controller;

import java.util.ArrayList;
import java.util.List;

import model.Button;

public class ButtonControl {
	
	private List<Button> buttons;
	
	public ButtonControl(int h,int w){
		Button trash = new Button(0, 500, 0);
		Button bucket = new Button(0, 625, 1);
		Button menu = new Button(w-100,0,2);
		//Will need to add more buttons later
		Button[] bns ={trash,bucket,menu};	
		buttons = new ArrayList<Button>();
		for(Button b: bns){
			buttons.add(b);
		}
	}
	
	public List<Button> getButtons(){
		return buttons;
	}
}
