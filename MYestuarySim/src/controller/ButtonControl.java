package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import model.Button;

public class ButtonControl extends JButton {
	
	private static final long serialVersionUID = -3104074185667012291L;
	private List<Button> buttons;

	public ButtonControl(int h,int w){
		Button recycle = new Button(10, 0, 0);
		Button shears = new Button(120, 0, 1);
		Button menu = new Button(w-140,0,2);
		Button help = new Button(w-250,0,3);
		Button mag = new Button(250,0,4);
		
		//Will need to add more buttons later
		Button[] bns ={recycle,shears,menu,help,mag};	
		buttons = new ArrayList<Button>();
		for(Button b: bns){
			buttons.add(b);
		}
	}
	
	public List<Button> getButtons(){
		return buttons;
	}
}
