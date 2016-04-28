package view;

public enum ePictures {
	
	BLUECRAB (0),
	INVASIVECRAB (1),
	PHRAGMITES (2),
	CORDGRASS (3),
	TURTLE (4),
	POLLUTION (5);
	
	private int index;
	
	ePictures(int i){
		this.index=i;
	}
	
	public int getIndex(){
		return index;
	}

}
