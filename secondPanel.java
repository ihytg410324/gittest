
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class secondPanel extends JPanel{
    JLabel jLabel1= new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    
    
    public secondPanel() {
        try {
            jbInit();
          }
          catch(Exception e) {
            e.printStackTrace();
          }  
    }    
    
    
    
    private void jbInit() throws Exception{
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24));
        jLabel1.setForeground(Color.blue);
        jLabel1.setText("TestBank");
        jLabel1.setBounds(new Rectangle(159, 94, 155, 50));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16));
        jLabel2.setForeground(Color.blue);
        jLabel2.setText("Page1");
        jLabel2.setBounds(new Rectangle(50, 162, 373, 50));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16));
        jLabel3.setForeground(Color.blue);
        jLabel3.setText("Version 1.2");
        jLabel3.setBounds(new Rectangle(190, 230, 92, 32));
        jLabel4.setBounds(new Rectangle(193, 280, 92, 32));
        jLabel4.setText("2015.12.01");
        jLabel4.setForeground(Color.blue);
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); 
        
        this.setLayout(null);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
    }
    
}
