package de.ohginfo.bwinf32.tutorien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        for(int i=0;i<6;i++){
            System.out.println(count[i][0]+"; "+count[i][1]);
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
