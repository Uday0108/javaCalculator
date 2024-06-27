import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField textfeild;
    JButton[] numButtons=new JButton[10];
    JButton[] functiButtons=new JButton[8];
    JButton addButton,sButton,mButton,diButton,decButton,eButton,delButton,clrButton;
    JPanel panel;
    JLabel label;

    Font myFont=new Font("Monospaced", Font.BOLD, 30);

    double num1=0,num2=0,result=0;
    char opreator;

    calculator()
    {
        frame=new JFrame("calulator");
        frame.setSize(400,540);
        frame.getContentPane().setBackground(new Color(230,230,250) );
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon icon=new ImageIcon("c:\\JAVA TESTS\\calcimage.png");

        textfeild =new JTextField();
        textfeild.setBounds(50, 25, 300, 50);
        textfeild.setFont(myFont);
        textfeild.setEditable(false);
        textfeild.setBackground(new Color(230,230,250));


        addButton=new JButton("+");
        sButton=new JButton("-");
        mButton=new JButton("*");
        diButton=new JButton("/");
        decButton=new JButton(".");
        eButton=new JButton("=");
        delButton=new JButton("del");
        clrButton=new JButton("clr");

        functiButtons[0]=addButton;
        functiButtons[1]=sButton;
        functiButtons[2]=mButton;
        functiButtons[3]=diButton;
        functiButtons[4]=decButton;
        functiButtons[5]=eButton;
        functiButtons[6]=delButton;
        functiButtons[7]=clrButton;

        for(int i=0;i<8;i++)
        {
            functiButtons[i].addActionListener(this);
            functiButtons[i].setBackground(new Color(230,230,250));
            functiButtons[i].setFont(new Font("Monospaced", Font.BOLD, 30));
            functiButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++)
        {
            numButtons[i]=new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setBackground(new Color(230,230,250));
            numButtons[i].setFocusable(false);        }

        delButton.setBounds(50, 430, 145, 50);
        delButton.setBackground(new Color(230,230,250));
        clrButton.setBounds(205, 430, 145, 50);
        clrButton.setBackground(new Color(230,230,250));

        panel =new JPanel();
        panel.setBounds(50,100 ,300 , 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(new Color(230,230,250));
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(sButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(eButton);
        panel.add(diButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfeild);
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);

    }

    public static void main(String[] args)
    {
        calculator cal=new calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e){

        for(int i=0;i<8;i++)
        {
            if(e.getSource()==numButtons[i])
            {
                textfeild.setText(textfeild.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton){
            textfeild.setText(textfeild.getText().concat("."));
        }
        if (e.getSource()==addButton) {
            num1=Double.parseDouble(textfeild.getText());
            opreator='+';
            textfeild.setText("");
        }
        if(e.getSource()==sButton){
            num1=Double.parseDouble(textfeild.getText());
            opreator='-';
            textfeild.setText("");
        }
        if(e.getSource()==diButton){
            num1=Double.parseDouble(textfeild.getText());
            opreator='/';
            textfeild.setText(null);
        }
        if(e.getSource()==mButton){
            num1=Double.parseDouble(textfeild.getText());
            opreator='*';
            textfeild.setText("");
        }
        if(e.getSource()==eButton){
            num2=Double.parseDouble(textfeild.getText());
            switch(opreator)
            {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1+num2;
                    break;
                case  '*' :
                    result=num1+num2;
                    break;
                case  '/' :
                    result=num1+num2;
                    break;
            }
            String z=String.valueOf(result);
            textfeild.setText(z);
            num1=result;
        }
        if(e.getSource()==clrButton)
        {
            textfeild.setText("");
        }
        if(e.getSource()==delButton)
        {
            String s=textfeild.getText();
            textfeild.setText("");
            for(int i=0;i<s.length()-1;i++)
            {
                textfeild.setText(textfeild.getText()+s.charAt(i));
            }
        }

    }
}