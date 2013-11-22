package de.ohginfo.bwinf32.tutorien;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Graphic extends JFrame {
  private static final long serialVersionUID = 1L;
  public JButton generate = new JButton("Generieren");
  public JButton reset = new JButton("Zurücksetzen");
  private JPanel panel = new JPanel();
  private JPanel buttonPanel = new JPanel();
  
  private final Color unselected = new Color(127,0,0);
  private final Color selected = new Color(255,255,255);
  private final Font title = new Font("Verdana",0,26);
  private final Font body = new Font("Verdana",0,16);
  
  private boolean[][] dates = new boolean[6][6];
  
  public Graphic(){
    super("Tutorien");
    this.setVisible(true);
    this.setSize(1000,500);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    
    for(int i=0;i<dates.length;i++){
      Arrays.fill(dates[i], false);
    }
    
    this.panel.setLayout(new GridLayout(7,7,5,5));
    this.panel.add(new JPanel());
    for(int i=0;i<6;i++){
      JLabel label = new JLabel("Termin "+(i+1));
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setFont(title);
      this.panel.add(label);
    }
    for(int i=0;i<6;i++){
      JLabel label = new JLabel("Lehrer"+(i+1));
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setFont(title);
      this.panel.add(label);
      for(int j=0;j<6;j++){
        final int $i = i;
        final int $j = j;
        final JButton button = new JButton("kein Termin");
        button.setBackground(unselected);
        button.setForeground(selected);
        button.setFont(body);
        button.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent arg0) {
            button.setText("Termin");
            button.setForeground(unselected);
            button.setBackground(selected);
            dates[$i][$j] = true;
          }         
        });
        this.panel.add(button);
      }
    }
    
    this.buttonPanel.setLayout(new GridLayout(1,2,5,5));
    reset.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        dispose();
      }
    });
    this.buttonPanel.add(reset);
    this.buttonPanel.add(generate);
    
    GroupLayout layout = new GroupLayout(this.getContentPane());
    this.setLayout(layout);
    layout.setAutoCreateContainerGaps(true);
    layout.setAutoCreateGaps(true);
    layout.setHorizontalGroup(
              layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addComponent(panel,0,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addComponent(buttonPanel,0,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
              layout.createSequentialGroup()
                  .addComponent(panel,0,400, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                      .addComponent(buttonPanel,0,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
  }
  

  public boolean[][] getDates() {
    return dates;
  }
}
