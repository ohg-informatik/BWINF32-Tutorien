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
		for(int i=0;i<termine.size();i++){
			int count = 0;
			for(int j=0;j<termine.size();j++){
				for(int k=0;k<dates.length;k++){
					if(k!=i){
						if(dates[termine.get(j)][k]){
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
