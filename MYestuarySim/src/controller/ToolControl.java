package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import model.Tool;
import view.ToolView;

/**
 * The Class ToolControl.
 * Handles the basic construction and placement of the tools on screen
 * @author Team 0
 */
public class ToolControl extends JButton {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3104074185667012291L;
	
	/** The list of all tools 
	 * @see Model.Tool.java
	 */
	private List<Tool> tools;
	
	/** The ToolView for use in getting the sizes of the tools for their placement on the screen */
	ToolView tv;
	
	/** The individual tool objects */
	private Tool recycle,shears,pauseB,mag,crabTrap;

	/**
	 * Instantiates a new tool control with default positions of the tools
	 *
	 * @param h the Height of the screen for use in placement of the pause button
	 * @param w the Width of the screen for use in placement of the pause button
	 */
	public ToolControl(int h,int w){
		tv = new ToolView();
		recycle = new Tool(10, 0, 0);
		shears = new Tool(recycle.getX()+tv.getRecycle().getWidth(null)+10, 0, 1);
		pauseB = new Tool(w-140,0,2);
		mag = new Tool(shears.getX()+tv.getShears().getWidth(null)+20,0,4);
		crabTrap = new Tool(mag.getX()+tv.getMag().getWidth(null)+20,0,4);
		
		//Will need to add more buttons later
		Tool[] bns ={recycle,crabTrap,pauseB,shears,mag};	
		tools = new ArrayList<Tool>();
		for(Tool b: bns){
			tools.add(b);
		}
	}
	
	/**
	 * Gets the tools.
	 *
	 * @return the tools
	 */
	public List<Tool> getTools(){
		return tools;
	}
	
	/**
	 * Gets the pause b.
	 *
	 * @return the pause b
	 */
	public Tool getPauseB() {
		return this.pauseB;
	}
	
	/**
	 * Gets the recycle.
	 *
	 * @return the recycle
	 */
	public Tool getRecycle() {
		return this.recycle;
	}
	
	/**
	 * Gets the mag.
	 *
	 * @return the mag
	 */
	public Tool getMag() {
		return this.mag;
	}
	
	/**
	 * Gets the shears.
	 *
	 * @return the shears
	 */
	public Tool getShears() {
		return this.shears;
	}
	
	/**
	 * Gets the crab trap.
	 *
	 * @return the crab trap
	 */
	public Tool getCrabTrap() {
		return this.crabTrap;
	}
}
