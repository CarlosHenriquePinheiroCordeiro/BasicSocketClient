package basic_socket_client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.PrintStream;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Client piece main class
 * @author CarlosHenriquePinheiroCordeiro
 * @since 29/03/2022
 *
 */
public class Main {

	private JFrame frame;
	private JTextField messageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		messageField = new JTextField();
		messageField.setBounds(101, 110, 227, 36);
		frame.getContentPane().add(messageField);
		messageField.setColumns(10);
		
		JLabel helloLabel = new JLabel("Hello, there is the Client side of this Basic Socket project.");
		helloLabel.setBounds(75, 61, 279, 36);
		frame.getContentPane().add(helloLabel);
		
		JLabel connectLabel = new JLabel("Connecting...");
		connectLabel.setBounds(22, 36, 385, 14);
		frame.getContentPane().add(connectLabel);
		if (Client.getInstance() != null) {
			connectLabel.setText("Sucessfully connected at "+Client.getIp()+":"+Client.getPort());
		}
		else {
			connectLabel.setText("Connection error at"+Client.getIp()+":"+Client.getPort());
		}
		
		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(22, 211, 385, 39);
		frame.getContentPane().add(resultLabel);
		
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (messageField.getText() != "") {
					if (sendMessage(messageField.getText())) 
						resultLabel.setText("Message sucessfully sent!");
					else
						resultLabel.setText("Sending message error!");
				}
			}
		});
		sendButton.setBounds(170, 158, 89, 23);
		frame.getContentPane().add(sendButton);
		
	}
	
	/**
	 * Sends the Message to the Server
	 * @param message
	 * @return boolean
	 */
	private boolean sendMessage(String message) {
		try {
			PrintStream out = new PrintStream(Client.getInstance().getOutputStream());
			out.println(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
