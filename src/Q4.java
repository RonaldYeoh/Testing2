import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q4 extends JFrame{    
    private JPanel txtFieldPanel = new JPanel(new GridLayout(2,2));
    
    private JPasswordField jpwdPassword = new JPasswordField(15);
    private JButton btnSubmit = new JButton("Submit");
    
    private JTextArea jtaErrorMsg = new JTextArea(5,30);

    
    public Q4(){
        txtFieldPanel.add(new JLabel("Enter your password"));
        txtFieldPanel.add(jpwdPassword);
        txtFieldPanel.add(new JLabel());
        txtFieldPanel.add(btnSubmit);
        add(txtFieldPanel, BorderLayout.CENTER);
        add(jtaErrorMsg, BorderLayout.SOUTH);

        jtaErrorMsg.setEditable(false);
        jtaErrorMsg.setLineWrap(true);
        jtaErrorMsg.setWrapStyleWord(true);
        
        btnSubmit.addActionListener(new submitListener());

        setTitle("Set Password");
        setSize(600,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public class submitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String pwd = (new String(jpwdPassword.getPassword()));
            jtaErrorMsg.setText("");
            try{
                Password password = new Password(pwd);
                jtaErrorMsg.setForeground(Color.blue);
                jtaErrorMsg.setText("Congratulations! Your password is valid.");
            }catch(InvalidPasswordException ex){
                jtaErrorMsg.setForeground(Color.red);
                jtaErrorMsg.setText(ex.getMessage());
            }
            

        }
    }
    public static void main(String[] args){
        new Q4();
    }
}