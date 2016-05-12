package model;

public enum eImages {
	
	BLUECRAB (0),
	INVASIVECRAB (1),
	PHRAGMITES (2),
	CORDGRASS (3),
	TURTLE (4),
	POLLUTION1 (5),
	POLLUTION2 (6),
	STAR (7);
	
	private int index;
	
	eImages(int i){
		this.index=i;
	}
	
	public int getIndex(){
		return index;
	}

}
