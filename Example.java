import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

//Please remove the second textfield from the example.
//Also when entering an equation without pressing clear in the beginning, your programm throws an error.

public class Example extends JFrame {
	public Example(){
		initUI();
	}

	private JButton quitButton;
	private JButton testButton;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;   
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton buttonMulti;
	private JButton buttonAdd;
	private JButton buttonDivide;
	private JButton buttonSubtract;
	private JButton buttonEquals;
	private JButton buttonClear;
	private JButton buttonDecimal;
	private JPanel numberBlock;
	private JPanel pane;
	private GroupLayout gl;
	private JTextField tf1;
	private JTextField tf2;

	String addString;
	String subString;
	String multiString;
	String divString;
	String finalString;
	String clearString;
	double addDou;
	double multiDou;
	double divDou;
	double subDou;
	double finalDou;
	double answer;
	String answerAsString;


	private Font font = new Font("SansSerif", Font.PLAIN, 20);

	private void initUI(){

		//new Button
		quitButton = new JButton("Quit");
		//set tooltip text
		quitButton.setToolTipText("Want to quit?");

		//ActionListener (Quit on Button Press)
		quitButton.addActionListener((event) -> System.exit(0));

		//        quitButton.addActionListener( new ActionListener() {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				// TODO Auto-generated method stub
		//				System.exit(0);
		//			}
		//		} );

		// init button
		button0 = new JButton();
		button0.setText("0");
		button1 = new JButton();
		button1.setText("1");
		button2 = new JButton();
		button2.setText("2");
		button3 = new JButton();
		button3.setText("3");
		button4 = new JButton();
		button4.setText("4");
		button5 = new JButton();
		button5.setText("5");
		button6 = new JButton();
		button6.setText("6");
		button7 = new JButton();
		button7.setText("7");
		button8 = new JButton();
		button8.setText("8");
		button9 = new JButton();
		button9.setText("9");
		buttonMulti = new JButton();
		buttonMulti.setText("*");
		buttonSubtract = new JButton();
		buttonSubtract.setText("-");
		buttonAdd = new JButton();
		buttonAdd.setText("+");
		buttonDivide = new JButton();
		buttonDivide.setText("/");
		buttonEquals =new JButton();
		buttonEquals.setText("=");
		buttonClear =new JButton();
		buttonClear.setText("Clear");
		buttonDecimal =new JButton();
		buttonDecimal.setText(".");


		// add handler to buttons
		button0.addActionListener( (event) -> this.numberBtnPresed(0) );
		button1.addActionListener( (event) -> this.numberBtnPresed(1) );
		button2.addActionListener( (event) -> this.numberBtnPresed(2) );
		button3.addActionListener( (event) -> this.numberBtnPresed(3) );
		button4.addActionListener( (event) -> this.numberBtnPresed(4) );
		button5.addActionListener( (event) -> this.numberBtnPresed(5) );
		button6.addActionListener( (event) -> this.numberBtnPresed(6) );
		button7.addActionListener( (event) -> this.numberBtnPresed(7) );
		button8.addActionListener( (event) -> this.numberBtnPresed(8) );
		button9.addActionListener( (event) -> this.numberBtnPresed(9) );

		buttonAdd.addActionListener( new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				addString = tf1.getText();
				addDou=Double.parseDouble(addString);
				tf1.setText("");
				buttonDecimal.setEnabled(true);
			}
		});
		buttonSubtract.addActionListener( new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				subString = tf1.getText();
				subDou=Double.parseDouble(subString);
				tf1.setText("");
				buttonDecimal.setEnabled(true);
			}
		});
		buttonMulti.addActionListener( new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				multiString = tf1.getText();
				multiDou=Double.parseDouble(multiString);
				tf1.setText("");
				buttonDecimal.setEnabled(true);
			}
		});
		buttonDivide.addActionListener( new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				divString=tf1.getText();
				divDou=Double.parseDouble(divString);
				tf1.setText("");
				buttonDecimal.setEnabled(true);


			}
		});
		buttonDecimal.addActionListener( new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				tf1.setText(tf1.getText()+".");
				String tf1Content=tf1.getText();

				if(tf1Content.contains(".")) {
					buttonDecimal.setEnabled(false);
				}


			}
		});
		buttonClear.addActionListener( new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				//	clearString = tf1.getText();
				tf1.setText("");
				addString=null;
				subString=null;
				multiString=null;
				divString=null;
				finalString=null;

			}
		});

		// buttonAdd.addActionListener( (event) -> this.operationBtnPresed("+") );
		//        buttonMulti.addActionListener( (event) -> this.operationBtnPresed("*") );
		//        buttonSubtract.addActionListener( (event) -> this.operationBtnPresed("-") );
		//      
		//        buttonDivide.addActionListener( (event) -> this.operationBtnPresed("/") );
		//   buttonEquals.addActionListener( (event) -> this.operationBtnPresed("=") );

		buttonEquals.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				finalString=tf1.getText();
				finalDou=Double.parseDouble(finalString);

				if(addString!=null) {
					answer=add(addDou,finalDou);
					answerAsString=Double.toString(answer);
					tf1.setText(answerAsString);
				}
				else if(subString!=null) {
					answer=subtract(subDou,finalDou);
					answerAsString=Double.toString(answer);
					tf1.setText(answerAsString);
				}
				else if(multiString!=null) {
					answer=multi(multiDou,finalDou);
					answerAsString=Double.toString(answer);
					tf1.setText(answerAsString);
				}
				else if(divString!=null) {
					answer=divide(divDou,finalDou);
					answerAsString=Double.toString(answer);
					tf1.setText(answerAsString);
				}
				else  {
					addString=null;
					subString=null;
					multiString=null;
					divString=null;
				}

			}
		});
		testButton = new JButton("Press");
		testButton.setToolTipText("Press me");
		testButton.addActionListener((event) -> onSubmit());

		tf1= new JTextField();
		tf1.setFont(font);
		tf1.setText("Enter the input");

		tf2 = new JTextField();
		tf2.setFont(font);
		tf2.setText("Output goes here");

		setTitle("Simple Calculator");

		createNumBlock();
		createFlowLayout();

		//Position in screen center
		setLocationRelativeTo(null);
		//Close Application when window is closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createNumBlock() {
		this.numberBlock = new JPanel();
		this.numberBlock.add(this.button0);
		this.numberBlock.add(this.button1);
		this.numberBlock.add(this.button2);
		this.numberBlock.add(this.button3);
		this.numberBlock.add(this.button4);
		this.numberBlock.add(this.button5);
		this.numberBlock.add(this.button6);
		this.numberBlock.add(this.button7);
		this.numberBlock.add(this.button8);
		this.numberBlock.add(this.button9);
		this.numberBlock.add(this.buttonMulti);
		this.numberBlock.add(this.buttonSubtract);
		this.numberBlock.add(this.buttonAdd);
		this.numberBlock.add(this.buttonDivide);
		this.numberBlock.add(this.buttonEquals);
		this.numberBlock.add(this.buttonClear);
		this.numberBlock.add(this.buttonDecimal);


		this.numberBlock.setLayout( new GridLayout( 3, 3 ) );
	}

	private void createFlowLayout(){
		//mind the order of the components!
		pane = (JPanel) getContentPane();
		pane.add(tf1);
		pane.add(testButton);
		pane.add(tf2);
		pane.add(quitButton);
		pane.add(numberBlock);
		pane.setLayout(new FlowLayout());
		pane.setSize(300,300);
		pack();
	}

	private void numberBtnPresed( int number ) {
		// do sth ...
		if(number==0) {
			tf1.setText(tf1.getText()+"0");
		}
		if(number==1) {
			tf1.setText(tf1.getText()+"1");
		}
		if(number==2) {
			tf1.setText(tf1.getText()+"2");
		}
		if(number==3) {
			tf1.setText(tf1.getText()+"3");
		}
		if(number==4) {
			tf1.setText(tf1.getText()+"4");
		}
		if(number==5) {
			tf1.setText(tf1.getText()+"5");
		}
		if(number==6) {
			tf1.setText(tf1.getText()+"6");
		}
		if(number==7) {
			tf1.setText(tf1.getText()+"7");
		}
		if(number==8) {
			tf1.setText(tf1.getText()+"8");
		}
		if(number==9) {
			tf1.setText(tf1.getText()+"9");
		} 	

	}
	private void operationBtnPresed( String a ) {
		if(a=="*") {
			tf1.setText("*");
		} 
		if(a=="/") {
			tf1.setText("/");
		}
		if(a=="+") {
			tf1.setText("+");
		}
		if(a=="-") {
			tf1.setText("-");
		}
		if(a=="=") {
			tf1.setText("=");
		}
		if(a=="Clear") {
			tf1.setText("");
		}
		if(a==".") {
			tf1.setText(".");
		}

	}
	public static double add(double n1,double n2) {
		return n1+n2;
	}
	public static double subtract(double n1,double n2) {
		return n1-n2;
	}
	public static double multi(double n1,double n2) {
		return n1*n2;
	}
	public static double divide(double n1,double n2) {
		return n1/n2;
	}

	private void onSubmit(){
		tf2.setText("You entered: " + tf1.getText());
	}

	public static void main(String[] args){
		//places the application on the Swing Event Queue such that all UI updates are concurrency-safe
		EventQueue.invokeLater(() ->{
			Example ex = new Example();
			ex.setVisible(true);
		});
	}

}
