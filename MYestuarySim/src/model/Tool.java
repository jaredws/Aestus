package model;

/**
 * The Class Tool. Contains the location, size, type.
 * Used by the ToolControl where there many instantiations of this object with multiple types
 * @author Team 0
 */
public class Tool extends java.awt.Button {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1666903446243743257L;
	
	/** The x location. */
	int x;
	
	/** The y location. */
	int y;
	
	/** The type of the tool. */
	int type;
	
	/** The size x of the tool. */
	int sizeX;
	
	/** The size y of the tool. */
	int sizeY;

	/**
	 * Constructor
	 * Instantiates a new tool with values
	 *
	 * @param x the x location for spawning
	 * @param y the y location for spawning
	 * @param type the type of the tool
	 */
	public Tool(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.sizeX = 100;
		this.sizeY = 100;
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#getX()
	 */
	public int getX() {
		return x;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#getY()
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets the type of the tool.
	 *
	 * @return the type of the tool.
	 */
	public int getType() {
		return type;
	}

	/**
	 * Gets the size x of the tool.
	 *
	 * @return the size x of the tool.
	 */
	public int getSizeX() {
		return sizeX;
	}

	/**
	 * Gets the size y of the tool.
	 *
	 * @return the size y of the tool.
	 */
	public int getSizeY() {
		return sizeY;
	}
	
}
