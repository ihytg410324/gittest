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
    
}