package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import model.Tool;
import view.ToolView;

public class ToolControl extends JButton {
	
	private static final long serialVersionUID = -3104074185667012291L;
	private List<Tool> tools;
	ToolView tv;
	private Tool recycle,shears,pauseB,mag,crabTrap;

	public ToolControl(int h,int w){
		tv = new ToolView();
		recycle = new Tool(10, 0, 0);
		shears = new Tool(recycle.getX()+tv.getRecycle().getWidth(null)+10, 0, 1);
		pauseB = new Tool(w-140,0,2);
		mag = new Tool(shears.getX()+tv.getShears().getWidth(null)+20,0,4);
		crabTrap = new Tool(mag.getX()+tv.getMag().getWidth(null)+20,0,4);
		
		//Will need to add more buttons later
		Tool[] bns ={recycle,shears,mag,crabTrap,pauseB};	
		tools = new ArrayList<Tool>();
		for(Tool b: bns){
			tools.add(b);
		}
	}
	
	public List<Tool> getTools(){
		return tools;
	}
	
	public Tool getPauseB() {
		return this.pauseB;
	}
	
	public Tool getRecycle() {
		return this.recycle;
	}
	
	public Tool getMag() {
		return this.mag;
	}
	
	public Tool getShears() {
		return this.shears;
	}
	
	public Tool getCrabTrap() {
		return this.crabTrap;
	}
}
