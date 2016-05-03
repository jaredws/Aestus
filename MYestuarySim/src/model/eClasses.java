package model;

public enum eClasses {
	
	BLUECRAB (0),
	INVASIVECRAB (1),
	PHRAGMITES (2),
	CORDGRASS (3),
	TURTLE (4),
	POLLUTION1 (5),
	POLLUTION2 (6);
	
	private int index;
	
	eClasses(int i){
		this.index=i;
	}
	
	public int getIndex(){
		return index;
	}

}
