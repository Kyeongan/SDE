package edu.uh.cs.sde;

public class toString {
	
	private int month;
	private int day;
	private int year;
	
	public toString(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
		
		System.out.printf("This is construction fuction - %s", this);
	}
	
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toString Obj = new toString(7,7,2015);

	}

}
