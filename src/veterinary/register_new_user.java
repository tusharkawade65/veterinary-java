package veterinary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class register_new_user {

	private JFrame frame;
	private JTextField textField_firstname;
	private JTextField lastname_textField;
	private JTextField ph_no_textfield;
	private JPasswordField user_password_textfield;
	private JPasswordField admin_passwordField;
	private String firstname=null;
	private String lastname=null;
	private String ph_no=null;
	private char[] password=null;
	private String admin_pass="tushar";
	private char[] adminpass=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register_new_user window = new register_new_user();
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
	public register_new_user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame("Register Form");
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 28));
		frame.setBounds(-10, 0, 1400, 722);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Register = new JLabel("Register");
		Register.setForeground(Color.GREEN);
		Register.setFont(new Font("Times New Roman", Font.BOLD, 42));
		Register.setHorizontalAlignment(SwingConstants.CENTER);
		Register.setBounds(498, 82, 263, 65);
		frame.getContentPane().add(Register);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setForeground(new Color(204, 0, 51));
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblLastName.setBounds(394, 219, 213, 34);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(new Color(204, 0, 51));
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblFirstName.setBounds(366, 159, 258, 48);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblPhno = new JLabel("Ph.No:");
		lblPhno.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhno.setForeground(new Color(204, 0, 51));
		lblPhno.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblPhno.setBounds(427, 268, 194, 34);
		frame.getContentPane().add(lblPhno);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(204, 0, 51));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblPassword.setBounds(394, 336, 227, 34);
		frame.getContentPane().add(lblPassword);
		
		textField_firstname = new JTextField();
		textField_firstname.setFont(new Font("Dialog", Font.BOLD, 18));
		textField_firstname.setForeground(new Color(0, 0, 204));
		textField_firstname.setBounds(617, 169, 227, 34);
		frame.getContentPane().add(textField_firstname);
		textField_firstname.setColumns(10);
		
		lastname_textField = new JTextField();
		lastname_textField.setForeground(new Color(0, 0, 204));
		lastname_textField.setFont(new Font("Dialog", Font.BOLD, 18));
		lastname_textField.setColumns(10);
		lastname_textField.setBounds(617, 222, 227, 34);
		frame.getContentPane().add(lastname_textField);
		
		ph_no_textfield = new JTextField();
		ph_no_textfield.setForeground(new Color(0, 0, 204));
		ph_no_textfield.setFont(new Font("Dialog", Font.BOLD, 18));
		ph_no_textfield.setColumns(10);
		ph_no_textfield.setBounds(617, 271, 227, 34);
		frame.getContentPane().add(ph_no_textfield);
		
		user_password_textfield = new JPasswordField();
		user_password_textfield.setForeground(new Color(204, 0, 0));
		user_password_textfield.setBounds(617, 342, 227, 32);
		frame.getContentPane().add(user_password_textfield);
		
		JLabel lblAdminPassword = new JLabel("Admin Password:");
		lblAdminPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPassword.setForeground(new Color(204, 0, 51));
		lblAdminPassword.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblAdminPassword.setBounds(350, 392, 227, 34);
		frame.getContentPane().add(lblAdminPassword);
		
		admin_passwordField = new JPasswordField();
		admin_passwordField.setForeground(new Color(204, 0, 0));
		admin_passwordField.setBounds(617, 394, 227, 32);
		frame.getContentPane().add(admin_passwordField);
		
		JButton btnNewButton = new JButton("Countinue");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				firstname=textField_firstname.getText();
				lastname=lastname_textField.getText();
				ph_no=ph_no_textfield.getText();
				password=user_password_textfield.getPassword();
				adminpass=admin_passwordField.getPassword();
				if(admin_pass.equals(new String(adminpass)))
				{
				
				Confirm_password_frame.main(null);
				frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "please enter valid administrator password");
				}
			}
		});
		btnNewButton.setBounds(575, 457, 107, 26);
		frame.getContentPane().add(btnNewButton);
	}
}
