package de.ohginfo.bwinf32.tutorien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tutorien {
    private Graphic graphic = new Graphic();
    
    private boolean[][] dates = new boolean[6][6];
    
    public Tutorien() {
        final ActionListener generateListener = new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                dates = graphic.getDates();
                generate();
            }
        };
        
        this.graphic.reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                graphic = new Graphic();
                graphic.reset.addActionListener(this);
                graphic.generate.addActionListener(generateListener);
            }
        });
        
        this.graphic.generate.addActionListener(generateListener);
    }           

    public void generate(){
        int[][] count = new int[6][2];
        for(int i=0;i<6;i++){
            int c = 0;
            for(int j=0;j<6;j++){
                if(dates[j][i]){
                    c++;
                }
            }
            count[i][0] = c;
            count[i][1] = i+1;         
        }
        
        count = sort(count);
        
        ArrayList<Integer> independentHustin = new ArrayList<Integer>();
        for(int i=0;i<6;i++){
            if(count[i][0] != 0){
            	independentHustin.add(count[i][1]);
            }
        }
       if(independentHustin.size() > 4){
    	   ArrayList<Integer> solution = new ArrayList<Integer>();
    	   int start;
    	   if(independentHustin.size() == 5){
    		   start = 5;
    	   }else{
    		   start = 0;
    	   }
    	   for(int i=start;i<6;i++){
    		   if(independentHustin.size()>5){
    			   for(int j=0;j<6;j++){
    				   if(j!=i){
    					   solution.add(j);
    				   }
    			   }
    		   }else{
    			   for(int j=0;j<5;j++){
    				   solution.add(j);
    			   }
    		   }
    		   PossibleSolution pssble = new PossibleSolution(dates, solution);
    		   if(pssble.testPossibility()){
    			   System.out.println();
    			   for(int j=0;j<solution.size();j++){
    				   System.out.println("Termin " + (solution.get(j)+1));
    			   }
    			   break;
    		   }else{
    			   System.out.println("non");
    		   }
    	   }
       }else{
    	   System.out.println("Keine Terminvorschläge möglich!(Zu Wenige Termine ausgewählt)");
       }
    }
    
    public int[][] sort(int[][] array){
        int[] temp;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j][0]<array[j+1][0]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    
    public static void main(String[] args){
        new Tutorien();
    }
}
