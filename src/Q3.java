import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Q3 extends JFrame{
    
    private JTextField jtfAnnualInterestRate = new JTextField();
    private JTextField jtfNumberOfYears = new JTextField();
    private JTextField jtfLoanAmount = new JTextField();
    private JTextField jtfMonthlyPayment = new JTextField();
    private JTextField jtfTotalPayment= new JTextField();
    private JButton jbtComputeLoan = new JButton("Compute Payment");
    
    public Q3(){
        jtfMonthlyPayment.setEditable(false);
        jtfTotalPayment.setEditable(false);
        
        JPanel p1 = new JPanel(new GridLayout(5,2));
        p1.add(new JLabel("Annual Interest Rate"));
        p1.add(jtfAnnualInterestRate);
        p1.add(new JLabel("Number of Years"));
        p1.add(jtfNumberOfYears);
        p1.add(new JLabel("Loan Amount"));
        p1.add(jtfLoanAmount);
        p1.add(new JLabel("Monthly Payment"));
        p1.add(jtfMonthlyPayment);
        p1.add(new JLabel("Total Payment"));
        p1.add(jtfTotalPayment);
        p1.setBorder(new TitledBorder("Enter loan amount, interest rate, and year"));
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(jbtComputeLoan);
        
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
        jbtComputeLoan.addActionListener(new ButtonListener());
        
        setSize(300,300);
        setTitle("Loan Calculator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double interest = 0;
            int year = 0;
            double loanAmount = 0;
            try{
                interest = Double.parseDouble(jtfAnnualInterestRate.getText());
                year = Integer.parseInt(jtfNumberOfYears.getText());
                loanAmount = Double.parseDouble(jtfLoanAmount.getText());

                Loan loan = new Loan(interest, year, loanAmount);

                jtfMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment()));
                jtfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
            }catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                jtfAnnualInterestRate.setText("");
                jtfNumberOfYears.setText("");
                jtfLoanAmount.setText("");
                jtfMonthlyPayment.setText("");
                jtfTotalPayment.setText("");
                jtfAnnualInterestRate.grabFocus();
            }
        }  
    }
    
    public static void main(String[] args){
        new Q3();
    }
}