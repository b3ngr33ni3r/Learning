package com.bengreenier.assignment2.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
public class StackBasedCalculator {

	private class ProcessClick implements MouseListener{

		Operation op;
		public ProcessClick(Operation op) {
			this.op = op;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			processCommand(op);
			
		}
		
	}
	
	private enum Operation{RPAR,LPAR,ADD,ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,QUIT,CLEAR,EQUALS,MULTIPLY,DIVIDE,SUBTRACT,BACKSPACE};
	private JFrame frmCalculator;
	private JTextField textField;
	private JLabel lblNewLabel;
	private LinkedList<Operation> operations;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackBasedCalculator window = new StackBasedCalculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StackBasedCalculator() {
		operations = new LinkedList<Operation>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 420, 426);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 67, 86, 20);
		frmCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnC = new JButton("C");
		btnC.addMouseListener(new ProcessClick(Operation.CLEAR));
		btnC.setBounds(10, 109, 89, 23);
		frmCalculator.getContentPane().add(btnC);
		
		JButton button = new JButton("<");
		button.addMouseListener(new ProcessClick(Operation.BACKSPACE));
		button.setBounds(109, 109, 89, 23);
		frmCalculator.getContentPane().add(button);
		
		JButton btnQ = new JButton("Q");
		btnQ.addMouseListener(new ProcessClick(Operation.QUIT));
		btnQ.setBounds(208, 109, 89, 23);
		frmCalculator.getContentPane().add(btnQ);
		
		JButton button_1 = new JButton("/");
		button_1.addMouseListener(new ProcessClick(Operation.DIVIDE));
		button_1.setBounds(307, 109, 89, 23);
		frmCalculator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("7");
		button_2.addMouseListener(new ProcessClick(Operation.SEVEN));
		button_2.setBounds(10, 148, 89, 23);
		frmCalculator.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("8");
		button_3.addMouseListener(new ProcessClick(Operation.EIGHT));
		button_3.setBounds(109, 148, 89, 23);
		frmCalculator.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("9");
		button_4.addMouseListener(new ProcessClick(Operation.NINE));
		button_4.setBounds(208, 148, 89, 23);
		frmCalculator.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("*");
		button_5.addMouseListener(new ProcessClick(Operation.MULTIPLY));
		button_5.setBounds(307, 148, 89, 23);
		frmCalculator.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("4");
		button_6.addMouseListener(new ProcessClick(Operation.FOUR));
		button_6.setBounds(10, 182, 89, 23);
		frmCalculator.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("5");
		button_7.addMouseListener(new ProcessClick(Operation.FIVE));
		button_7.setBounds(109, 182, 89, 23);
		frmCalculator.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("6");
		button_8.addMouseListener(new ProcessClick(Operation.SIX));
		button_8.setBounds(208, 182, 89, 23);
		frmCalculator.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("-");
		button_9.addMouseListener(new ProcessClick(Operation.SUBTRACT));
		button_9.setBounds(307, 182, 89, 23);
		frmCalculator.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("1");
		button_10.addMouseListener(new ProcessClick(Operation.ONE));
		button_10.setBounds(10, 216, 89, 23);
		frmCalculator.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("2");
		button_11.addMouseListener(new ProcessClick(Operation.TWO));
		button_11.setBounds(109, 216, 89, 23);
		frmCalculator.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("3");
		button_12.addMouseListener(new ProcessClick(Operation.THREE));
		button_12.setBounds(208, 216, 89, 23);
		frmCalculator.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("+");
		button_13.addMouseListener(new ProcessClick(Operation.ADD));
		button_13.setBounds(307, 216, 89, 23);
		frmCalculator.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("0");
		button_14.addMouseListener(new ProcessClick(Operation.ZERO));
		button_14.setBounds(10, 250, 89, 23);
		frmCalculator.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("(");
		button_15.setBounds(109, 250, 89, 23);
		button_15.addMouseListener(new ProcessClick(Operation.LPAR));
		frmCalculator.getContentPane().add(button_15);
		
		JButton button_16 = new JButton(")");
		button_16.addMouseListener(new ProcessClick(Operation.RPAR));
		button_16.setBounds(208, 250, 89, 23);
		frmCalculator.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("=");
		button_17.addMouseListener(new ProcessClick(Operation.EQUALS));
		button_17.setBounds(307, 250, 89, 23);
		frmCalculator.getContentPane().add(button_17);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(260, 70, 111, 14);
		frmCalculator.getContentPane().add(lblNewLabel);
	}
	
	//do what needs to happen for the calculator to function.
	private void processCommand(Operation op) {
		switch (op) {
		case BACKSPACE:
			operations.pop();
			adjustText();
			break;
		case CLEAR:
			lblNewLabel.setText("");
			operations.clear();
			adjustText();
			break;
		case EQUALS:
			evaluateOperations();
			break;
		case QUIT:
			System.exit(0);
			break;
		default:
			operations.push(op);
			adjustText();
			break;
		
		}
	}

	//this is where we do math and things and display it
	//to the textField (equals is here)
	//parse through the opStack and evaluate everything
	//properly
	private void evaluateOperations() {
		String expression = "";
		for (Operation op : operations) {
			expression += decodeOp(op);
		}
		
		try {
			//note that this uses a third party lib
			Calculable calc = new ExpressionBuilder(expression).build();
			textField.setText(""+calc.calculate());
			operations.clear();
		} catch (Exception e) {
			lblNewLabel.setText("INVALID");
		}
	}
	
	//this is where we tweak the visible output
	//either after a backspace, or clear. (equals is elsewhere)
	private void adjustText() {
		String visual="";
		for (Operation op : operations) {
			visual+=decodeOp(op);
		}
		textField.setText(visual);
	}
	
	@SuppressWarnings("incomplete-switch")
	private String decodeOp(Operation op) {
		String visual="";
		switch(op) {
		case LPAR:
			visual+="(";
			break;
		case ADD:
			visual+="+";
			break;
		case DIVIDE:
			visual+="/";
			break;
		case EIGHT:
			visual+="8";
			break;
		case FIVE:
			visual+="5";
			break;
		case FOUR:
			visual+="4";
			break;
		case MULTIPLY:
			visual+="*";
			break;
		case NINE:
			visual+="9";
			break;
		case ONE:
			visual+="1";
			break;
		case RPAR:
			visual+=")";
			break;
		case SEVEN:
			visual+="7";
			break;
		case SIX:
			visual+="6";
			break;
		case SUBTRACT:
			visual+="-";
			break;
		case THREE:
			visual+="3";
			break;
		case TWO:
			visual+="2";
			break;
		case ZERO:
			visual+="0";
			break;
		
		}
		return visual;
	}
}
