import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Q2 extends JFrame{
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel txtFieldPanel = new JPanel(new GridLayout(2,2));

    private JTextField jtxtIndex = new JTextField(20);
    private JTextField jtxtElement = new JTextField(20);
    
    private JButton jbtnShow = new JButton("Show Element");
    
    private int[] intArray = new int[100];
    
    private showListener btnShowListener = new showListener();
    public Q2(){
        setLayout(new FlowLayout());
        setTitle("Display: Show Bounds Error");
        setSize(500,125);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jtxtElement.setEditable(false);
        
        mainPanel.setBorder(new LineBorder(Color.gray));
        
        txtFieldPanel.add(new JLabel("Array Index"));
        txtFieldPanel.add(jtxtIndex);
        txtFieldPanel.add(new JLabel("Array Element"));
        txtFieldPanel.add(jtxtElement);
        
        mainPanel.add(txtFieldPanel,BorderLayout.CENTER);
        mainPanel.add(jbtnShow,BorderLayout.SOUTH);
        
        add(mainPanel);
        
        for (int i = 0; i < intArray.length;i++){
            intArray[i] = (int)(Math.random()*100);
        }    
        
        jbtnShow.addActionListener(btnShowListener);
    }
    
    private class showListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                int index = Integer.parseInt(jtxtIndex.getText());
                String element = Integer.toString(intArray[index]);
                jtxtElement.setText(element);
            }catch(ArrayIndexOutOfBoundsException ex){
                jtxtElement.setText("Out of Bound");
            }catch(NumberFormatException ex){
                jtxtElement.setText("Non-numeric Array Index");
            }
        }
    }
    public static void main(String[] args){
        new Q2();
    }



}