

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JFrame frame;
    
    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    // create jFrame with radioButton and JButton
    OnlineTest(String s) {
        super(s);
        JFrame Frame =new JFrame();
        Frame.getContentPane().setBackground(Color.white);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnNext.setBackground(Color.white);
        btnBookmark = new JButton("later");
        btnBookmark.setBackground(Color.white);
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        label.setBackground(Color.black);
        //radioButton[0].setBounds(50, 80, 200, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(700,400);
        
    }

    // handle all actions based on event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
                btnNext.setBackground(Color.white);
            }
        }
        if (e.getActionCommand().equals("later")) {
            JButton bk = new JButton("later" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                btnBookmark.setText("Result");
                btnBookmark.setBackground(Color.white);
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("later" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct answers= " + count);
            System.exit(0);
        }
    }

    // SET Questions with options
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
           
            label.setText("Que1: What is the capital city of china?");
            label.setBackground(Color.white);
            radioButton[0].setText("Tokyo");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("Beijing");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("Singapore");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("Berlin");
            radioButton[3].setBackground(Color.blue);
        }
        if (current == 1) {
            label.setText("Que2:  When did world war II begin?");
            radioButton[0].setText("1940");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("1939");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("1938");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("1955");
            radioButton[3].setBackground(Color.blue);
        }
        if (current == 2) {
            label.setText("Que3: What is the capital of pakistan?");
            radioButton[0].setText("Islamabad");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("Karachi");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("Lahore");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("Peshawer");
        radioButton[3].setBackground(Color.blue);
        }
        if (current == 3) {
            label.setText("Que4: Current Prime minister of pakistan?.");
            radioButton[0].setText("Nawaz Sharif");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("Asif Ali Zardari");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("Imran Khan");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("Parvez Musharaf");
        radioButton[3].setBackground(Color.blue);
        }
        if (current == 4) {
            label.setText("Que5:  First Prime Minister of pakistan?");
            radioButton[0].setText("Liaquat Ali Khan");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("Quaid-e-Azam");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("Allama Iqbal");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("Sikander Mirza");
        radioButton[3].setBackground(Color.blue);
        }
        if (current == 5) {
            label.setText("Que6: How many Surahs are in Quran?");
            radioButton[0].setText("114");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("230");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("116");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("115");
        radioButton[3].setBackground(Color.blue);
        }
        if (current == 6) {
            label.setText("Que7: First Hajj was done in _____A.H?");
            
            radioButton[0].setText("10A.H");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("9A.H");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("11A.H");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("13A.H");
        radioButton[3].setBackground(Color.blue);
        }
        if (current == 7) {
            label.setText("Que8: Lahore Resolution was passed in?");
            radioButton[0].setText("1947");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("1950");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("1940");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("1938");
        radioButton[3].setBackground(Color.blue);
        }
        if (current == 8) {
            label.setText("Que9: What is the capital of India?");
            radioButton[0].setText("Delhi");
            radioButton[0].setBackground(Color.yellow);
            radioButton[1].setText("Hyderabad");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("Bangalore");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("Mumbai");
    radioButton[3].setBackground(Color.blue);    
        }
        if (current == 9) {
            label.setText("Que10: What is the capital city of sindh?");
            
            radioButton[0].setText("Karachi");
    radioButton[0].setBackground(Color.yellow);        
            radioButton[1].setText("Islamabad");
            radioButton[1].setBackground(Color.green);
            radioButton[2].setText("Peshawer");
            radioButton[2].setBackground(Color.red);
            radioButton[3].setText("Lahore");
        radioButton[3].setBackground(Color.blue);
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    // declare right answers.
    boolean check() {
        if (current == 0)
            return (radioButton[1].isSelected());
        if (current == 1)
            return (radioButton[1].isSelected());
        if (current == 2)
            return (radioButton[0].isSelected());
        if (current == 3)
            return (radioButton[2].isSelected());
        if (current == 4)
            return (radioButton[0].isSelected());
        if (current == 5)
            return (radioButton[0].isSelected());
        if (current == 6)
            return (radioButton[1].isSelected());
        if (current == 7)
            return (radioButton[2].isSelected());
        if (current == 8)
            return (radioButton[0].isSelected());
        if (current == 9)
            return (radioButton[0].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test App");
    }

}

