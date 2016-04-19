package controller;

import java.util.ArrayList;
import java.util.List;

import model.Button;

public class ButtonControl {
	
	private List<Button> buttons;
	
	public ButtonControl(){
	//Will need to add more buttons later
		Button[] bns ={new Button(0, 500, 0), new Button(0, 625, 1)};	
		buttons = new ArrayList<Button>();
		for(Button b: bns){
			buttons.add(b);
		}
	}
	
	public List<Button> getButtons(){
		return buttons;
	}
}
