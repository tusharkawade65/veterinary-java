package veterinary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class new_account {

	private JFrame frame;
	private JTextField admin_username_txtfield;
	private JPasswordField admin_passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_account window = new new_account();
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
	public new_account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.getContentPane().setForeground(SystemColor.menu);
		frame.setBounds(100, 100, 983, 482);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel administrator_details = new JLabel("For Administrator");
		administrator_details.setHorizontalAlignment(SwingConstants.CENTER);
		administrator_details.setForeground(SystemColor.textHighlight);
		administrator_details.setFont(new Font("Courier New", Font.BOLD, 22));
		administrator_details.setBounds(278, 59, 224, 28);
		frame.getContentPane().add(administrator_details);
		
		JLabel admin_username = new JLabel("Username");
		admin_username.setHorizontalAlignment(SwingConstants.CENTER);
		admin_username.setForeground(SystemColor.menu);
		admin_username.setFont(new Font("Courier New", Font.BOLD, 22));
		admin_username.setBounds(127, 117, 224, 28);
		frame.getContentPane().add(admin_username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(SystemColor.menu);
		lblPassword.setFont(new Font("Courier New", Font.BOLD, 22));
		lblPassword.setBounds(127, 185, 224, 28);
		frame.getContentPane().add(lblPassword);
		
		admin_username_txtfield = new JTextField();
		admin_username_txtfield.setForeground(new Color(255, 0, 0));
		admin_username_txtfield.setFont(new Font("Dialog", Font.BOLD, 16));
		admin_username_txtfield.setBounds(398, 122, 248, 28);
		frame.getContentPane().add(admin_username_txtfield);
		admin_username_txtfield.setColumns(10);
		
		admin_passwordField = new JPasswordField();
		admin_passwordField.setFont(new Font("Dialog", Font.PLAIN, 16));
		admin_passwordField.setForeground(new Color(255, 0, 0));
		admin_passwordField.setBounds(398, 190, 248, 28);
		frame.getContentPane().add(admin_passwordField);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new_account.register_new_user new_user=new register_new_user();
				register_new_user.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(0, 0, 139));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(321, 273, 98, 38);
		frame.getContentPane().add(btnNewButton);
	}

}
