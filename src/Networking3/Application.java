package Networking3;


import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Application {

	public JFrame frame;
	private JTextField txtMessage;
	private JTextField txtServerAddress;


	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		InputField txtFld = new InputField(){
			@Override
			public void sendMessage()
			{
				System.out.println(System.getProperty("user.name")+" sent "+getText());
				
				//Main.client.sendTCP(getText());
			}
		};
		frame.getContentPane().add(txtFld, BorderLayout.SOUTH);
		
		txtServerAddress = new JTextField();
		txtServerAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtServerAddress.setText("Server Address");
		frame.getContentPane().add(txtServerAddress, BorderLayout.NORTH);
		txtServerAddress.setColumns(10);
				
		
	}

}
