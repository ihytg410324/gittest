

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import tw.com.iisi.EsecurityOS2.*;


public class thirdPanel extends JPanel{
    JPanel panelControl = new JPanel();
    JLabel jLabel = new JLabel();
    JLabel jLabel2 = new JLabel();
    JPasswordField Password = new JPasswordField();
    JButton btnIntoICC = new JButton();
    JComboBox UID = new JComboBox();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    ICCardOperation ico=new ICCardOperation();
    SessionKeyOperation sko=new SessionKeyOperation();
    String logmsg = "";
    String loguser = "";
    
    
    
    public thirdPanel() {
        try {
            jbInit();
          }
          catch(Exception e) {
            e.printStackTrace();
          }  
    }    
    
    private void jbInit() throws Exception{
        this.setLayout(null);
        panelControl.setLayout(null);
        panelControl.setBackground(new Color(0,184,210));
        panelControl.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black,2),"IC卡使用者"));
        panelControl.setBounds(new Rectangle(31, 77, 224, 147));
        
        jLabel.setText("使用者帳號");
        jLabel.setBounds(new Rectangle(9, 26, 71, 19));
        
        jLabel2.setText("使用者密碼");
        jLabel2.setBounds(new Rectangle(10, 65, 71, 19));
        
        Password.setBounds(new Rectangle(101,62,110,24));
        
        jButton1.setText("驗證IC卡使用者");
        jButton1.setBounds(new Rectangle(270,95,150,30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
              CardVerify_actionPerformed(e);
            }
          });
        
        
        jButton2.setText("離開");
        jButton2.setBounds(new Rectangle(270,135,150,30));
        
        UID.setBounds(new Rectangle(101,23,110,24));
        //UID.addItem("User1");
        //UID.addItem("User2");
        //int returncode[]=new int[2];
        //CommonCardProcess.GetUID(returncode,UID);
        
        
        btnIntoICC.setEnabled(false);
        btnIntoICC.setForeground(Color.blue);
        btnIntoICC.setText("登錄系統");
        btnIntoICC.setBackground(new Color(150, 255, 255));
        btnIntoICC.setBounds(new Rectangle(44, 100, 145, 34));
        
        panelControl.add(jLabel);
        panelControl.add(jLabel2);
        panelControl.add(Password);
        panelControl.add(UID);
        panelControl.add(btnIntoICC);
        this.add(jButton1);
        this.add(jButton2);
        this.add(panelControl);
    }
    
    void CardVerify_actionPerformed(ActionEvent e) {
        int returncode[]=new int[2];
        int i=0;
        Password.setEnabled(true);
        returncode[1]=ico.Open_Iccard();
        if(returncode[1]!=0){
                  CommonCardProcess.ShowMessage(2,returncode[1],"請檢查IC卡、讀卡機或\n聯絡通知相關人員",this);
                  returncode[1]=ico.Close_Iccard();
                  return;
        }
        
        sko.VerifySessionKey(returncode);
        if(returncode[1]!=0){
           CommonCardProcess.ShowMessage(returncode[0],returncode[1],"Session Key 驗證有誤",this);
           returncode[1]=ico.Close_Iccard();
           logmsg =  "Session Key 驗證有誤";
           try{
               SystemInfo.AddToLogFile(loguser,logmsg);
           }catch(Exception ex){
           }
           return;
        }
    }

}
