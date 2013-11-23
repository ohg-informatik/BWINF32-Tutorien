package de.ohginfo.bwinf32.tutorien;

import java.util.ArrayList;

public class PossibleSolution {
	ArrayList<Integer> termine;
	boolean[][] dates;
	
	public PossibleSolution(boolean[][] dates, ArrayList<Integer> termine) {
		this.dates = dates;
		this.termine = termine;
	}
	
	public boolean testPossibility(){
		for(int i=0;i<6;i++){
			int count = 0;
			for(int j=0;j<dates.length;j++){
				for(int k=0;k<termine.size();k++){
					if(k!=i){
						if(dates[termine.get(k)][j]){
							count++;
							break;
						}
					}
				}
			}
			if(count<4){
				return false;
			}
		}
		return true;
	}
}
