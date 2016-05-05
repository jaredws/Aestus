package model;

public enum ePollute {
	
	CAN (0),
	ASSORTED(1),
	PAPER (2);
	
	private int index;
	
	ePollute(int i){
		this.index=i;
	}
	
	public int getIndex(){
		return index;
	}
	
	public ePollute set(int i){
		this.index = i;
		return getPollute(i);
	}
	
	public static ePollute getPollute(int i){
		switch (i){
		case 0: return CAN;
		case 1: return ASSORTED;
		case 2: return PAPER;
		default: return CAN;
		}
	}

}
