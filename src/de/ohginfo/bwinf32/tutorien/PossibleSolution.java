package de.ohginfo.bwinf32.tutorien;

public class PossibleSolution {
  int[] termine;
  boolean[][] dates;
  
  public PossibleSolution(boolean[][] dates, int[] termine) {
    this.dates = dates;
    this.termine = termine;
  }
  
  public boolean testPossibility(){
    for(int i=0;i<dates.length;i++){
      int count = 0;
      for(int j=0;j<dates.length;j++){
        for(int k=0;k<dates.length;k++){
          if(k!=i){
            if(dates[k][j]){
              count++;
              break;
            }
          }
        }
      }
      System.out.println(count);
      if(count < 4){
        return false;
      }
    }
    return true;
  }
}