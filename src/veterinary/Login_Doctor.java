package veterinary;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_Doctor {

	private JFrame frame;
	private JTextField username_textField;
	private JPasswordField passwordField;
	private JLabel lblCreateNewAccount;

	private String password;
	
	private String Username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Doctor window = new Login_Doctor();
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
	public Login_Doctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 482);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.RED);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("DialogInput", Font.BOLD, 35));
		lblLogin.setBounds(247, 31, 473, 54);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 22));
		lblNewLabel.setBounds(297, 142, 128, 33);
		frame.getContentPane().add(lblNewLabel);
		
		username_textField = new JTextField();
		username_textField.setText("nehepatil");
		username_textField.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
		username_textField.setForeground(new Color(128, 128, 0));
		username_textField.setBounds(455, 148, 245, 27);
		frame.getContentPane().add(username_textField);
		username_textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Corbel", Font.BOLD, 22));
		lblPassword.setBounds(297, 194, 128, 33);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 16));
		passwordField.setForeground(new Color(255, 0, 0));
		passwordField.setBounds(455, 200, 245, 27);
		frame.getContentPane().add(passwordField);
		
		JButton Login_btn = new JButton("Login");
		Login_btn.setBackground(new Color(255, 0, 0));
		Login_btn.setForeground(new Color(0, 0, 0));
		Login_btn.setFont(new Font("Garamond", Font.BOLD, 20));
		Login_btn.setBounds(435, 297, 98, 26);
		frame.getContentPane().add(Login_btn);
		
		
		Login_btn.addMouseListener(new MouseAdapter()
				{ 

					public void mouseClicked(MouseEvent me)
					{
						password=new String(passwordField.getPassword());
						Username=username_textField.getText();
					
						if(database_connections.validateLogin(Username,password)==1)
						{
							JOptionPane.showMessageDialog(null, "login Successfull..");
							Doctor_main_frame.main(null);
							frame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Enter valid password");
						}
					}
			
				});
		
		
		
		lblCreateNewAccount = new JLabel("create new account");
		lblCreateNewAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				//JOptionPane.showMessageDialog(null, "hello world");
				new_account na=new new_account();
				na.main(null);
				
				
			}
		});
		lblCreateNewAccount.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateNewAccount.setForeground(new Color(0, 0, 205));
		lblCreateNewAccount.setBounds(247, 381, 178, 16);
		frame.getContentPane().add(lblCreateNewAccount);
	}
}
