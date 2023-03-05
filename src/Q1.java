import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q1 extends JFrame{
    private JPanel panel = new JPanel();
    private JPanel txtFieldPanel = new JPanel(new GridLayout(3,2));
    private JPanel txtFieldPanel = new JPanel(new GridLayout(3,2));
    private JPanel btnPanel = new JPanel(new FlowLayout());
    
    private JTextField jtxtFirstNo = new JTextField(10);
    private JTextField jtxtSecondNo = new JTextField(10);
    private JTextField jtxtResult = new JTextField(10);
    
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtSubtract = new JButton("Subtract");
    private JButton jbtMultiply = new JButton("Multiply");
    private JButton jbtDivide = new JButton("Divide");
    
    ButtonListener btnListener = new ButtonListener();
    
    public Q1(){
        setLayout(new BorderLayout());
        setTitle("Simple Calculator");
        setSize(350,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jtxtResult.setEditable(false);
        txtFieldPanel.add(new JLabel("First Number"));
        txtFieldPanel.add(jtxtFirstNo);
        txtFieldPanel.add(new JLabel("Second Number"));
        txtFieldPanel.add(jtxtSecondNo);
        txtFieldPanel.add(new JLabel("Result"));
        txtFieldPanel.add(jtxtResult);
        add(txtFieldPanel,BorderLayout.CENTER);
        btnPanel.add(jbtAdd);
        btnPanel.add(jbtSubtract);
        btnPanel.add(jbtMultiply);
        btnPanel.add(jbtDivide);
        add(btnPanel,BorderLayout.SOUTH);
        
        jbtAdd.addActionListener(btnListener);
        jbtSubtract.addActionListener(btnListener);
        jbtMultiply.addActionListener(btnListener);
        jbtDivide.addActionListener(btnListener);
    }
    
    private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
            try{
                double firstNo = Double.parseDouble(jtxtFirstNo.getText());
                double secondNo = Double.parseDouble(jtxtSecondNo.getText());
                double result = 0;
                if(e.getSource() == jbtAdd){
                    result = firstNo + secondNo;
                }
                else if(e.getSource() == jbtSubtract){
                    result = firstNo - secondNo;
                }
                else if(e.getSource() == jbtMultiply){
                    result = firstNo * secondNo;
                }
                else if(e.getSource() == jbtDivide){
                    result = firstNo / secondNo;
                }
                jtxtResult.setText(String.format("%.2f", result));
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Non-numeric operand(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
                jtxtFirstNo.setText("");
                jtxtSecondNo.setText("");
                jtxtResult.setText("");
                jtxtFirstNo.requestFocus();
            }
    }
}
    public static void main(String[] args){
        new Q1();
    }
}
        
