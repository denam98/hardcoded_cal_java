import java.awt.Frame;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCal extends JFrame implements ActionListener{

	// Declaring variables related to the interface
	JTextField  display;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton b0;
	JButton bPlus;
	JButton bMinus;
	JButton bMultiplication;
	JButton bDivision;
	JButton bEqual;
	JButton bSqrt;
	JMenuBar mb;
	JMenu menu1;
	JMenuItem m1_item1;
	JMenuItem m1_item2;

	// Other variable declarations
	double num1;
	double num2;
	double answer;
	String op;

	public MyCal(){
		initComponent();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 400) / 2, (d.height - 600) / 2, 400, 600);
		setTitle("My Calculator 2.0");

		// This can be use to close the window
		/*addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);*/

	}

	void initComponent(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BorderLayout border = new BorderLayout();
		setResizable(false);
		
		// Adding panels to the border layout
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		add(p1, border.NORTH);
		add(p2, border.CENTER);
		
		// Adding a textField
		display = new JTextField("0",30);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setBackground(Color.WHITE);
		display.setForeground(Color.BLACK);
		p1.add(display);
		
		// creating buttons
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		bMultiplication = new JButton("*");
		bDivision = new JButton("/");
		bEqual = new JButton("=");
		bSqrt = new JButton("\u221A");
		
		// Adding grib layout for buttons
		GridLayout grid = new GridLayout(4, 4, 5, 5);
		p2.setLayout(grid);

		// Adding buttons to the panel
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(b0);
		p2.add(bPlus);
		p2.add(bMinus);
		p2.add(bMultiplication);
		p2.add(bDivision);
		p2.add(bEqual);
		p2.add(bSqrt);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bPlus.addActionListener(this);
		bMinus.addActionListener(this);
		bMultiplication.addActionListener(this);
		bDivision.addActionListener(this);
		bEqual.addActionListener(this);
		bSqrt.addActionListener(e -> {
			num1 = Double.parseDouble(display.getText().trim());
			display.setText(Double.toString(Math.sqrt(num1)));
		});
		
		// Adding the menubar
		mb = new JMenuBar();
		menu1 = new JMenu("File");
		m1_item1 = new JMenuItem("New window");
		menu1.add(m1_item1);
		m1_item2 = new JMenuItem("Exit");
		menu1.add(m1_item2);
		mb.add(menu1);
		setJMenuBar(mb);

		m1_item1.addActionListener(e -> {
			new MyCal().setVisible(true);
		});
		m1_item2.addActionListener(e -> {
			this.dispose();
		});

	}

	public void actionPerformed(ActionEvent evt){
		if(evt.getActionCommand().equals("0")){
			if(display.getText().equals("0")){
				display.setText(evt.getActionCommand());
			} else {
				display.setText(display.getText().concat(evt.getActionCommand()));
			}
		}
		if(evt.getActionCommand().equals("1") | evt.getActionCommand().equals("2") | evt.getActionCommand().equals("3") | evt.getActionCommand().equals("4") | evt.getActionCommand().equals("5") | evt.getActionCommand().equals("6") | evt.getActionCommand().equals("7") | evt.getActionCommand().equals("8") | evt.getActionCommand().equals("9")){
			if(display.getText().equals("0")){
				display.setText("");
				display.setText(evt.getActionCommand());
			} else {
				display.setText(display.getText().concat(evt.getActionCommand()));
			}
		}
		if(evt.getActionCommand().equals("+") | evt.getActionCommand().equals("-") |evt.getActionCommand().equals("/") |evt.getActionCommand().equals("*")){
			op = evt.getActionCommand();
			num1 = Double.parseDouble(display.getText().trim());
			display.setText("0");
		}
		if(evt.getActionCommand().equals("=")){
			num2 = Double.parseDouble(display.getText().trim());
			display.setText(arithmaticOperation());
		}
		
	}

	String arithmaticOperation(){
		switch(op){
			case "+" :
				answer = num1 + num2;
				break;
			case "-" :
				answer = num1 - num2;
				break;
			case "/" :
				answer = num1 / num2;
				break;
			case "*" :
				answer = num1 * num2;
				break;
		}
		return Double.toString(answer);
	}

}

class AppRunner {

	public static void main(String []args){
		MyCal frame = new MyCal();
		frame.setVisible(true);
		
	}
	
}