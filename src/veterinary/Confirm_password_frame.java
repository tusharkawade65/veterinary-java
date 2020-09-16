package veterinary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Confirm_password_frame {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm_password_frame window = new Confirm_password_frame();
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
	public Confirm_password_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("confirm password");
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 204, 0));
		frame.setBounds(100, 100, 494, 285);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConfirmPassword = new JLabel(" Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmPassword.setForeground(new Color(0, 0, 51));
		lblConfirmPassword.setBounds(87, 27, 232, 40);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.CYAN);
		passwordField.setBounds(87, 96, 232, 30);
		frame.getContentPane().add(passwordField);
		
		JButton registerbtn = new JButton("Register");
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		registerbtn.setForeground(Color.RED);
		registerbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		registerbtn.setBackground(Color.GREEN);
		registerbtn.setBounds(156, 160, 107, 26);
		frame.getContentPane().add(registerbtn);
	}
}
