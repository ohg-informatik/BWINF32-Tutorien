package de.ohginfo.bwinf32.tutorien;

import java.util.ArrayList;

public class PossibleSolution {
	ArrayList<Integer> termine;
	boolean[][] dates;
	
	public PossibleSolution(boolean[][] dates, ArrayList<Integer> termine) {
		this.dates = dates;
		this.termine = termine;
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(dates[i][j] + "  ");
			}
			System.out.println();
		}
		for(int i=0;i<termine.size();i++){
			System.out.print((termine.get(i)+1)  + "   ");
		}
		System.out.println();
		System.out.println();
	}
	
	public boolean testPossibility(){
		for(int i=0;i<termine.size();i++){
			int count = 0;
			for(int j=0;j<dates.length;j++){
				for(int k=0;k<termine.size();k++){
					if(j!=i){
						if(dates[termine.get(k)][j]){
							count++;
							System.out.println(count);
							break;
						}
					}
				}
			}
			System.out.println();
			if(count<4){
				return false;
			}
		}
		return true;
	}
}
