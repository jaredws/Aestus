package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import model.Button;

public class ButtonControl {
	
	private List<Button> buttons;
	
	public ButtonControl(int h,int w){
		Button trash = new Button(20, 0, 0);
		Button bucket = new Button(0, h-150, 1);
		Button menu = new Button(w-160,0,2);
		Button help = new Button(w-250,0,3);
		Button mag = new Button(200,0,4);
		
		menu.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
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
