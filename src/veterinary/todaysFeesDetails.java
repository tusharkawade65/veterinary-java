package veterinary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.DatabaseMetaData;

import java.awt.Font;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class todaysFeesDetails {

	private JFrame frame;
	private JTextField addAnimalNameTextField;
	private static int farmerID;
	private static int fees;
	private static String actualDate;
	public static JComboBox tretmentNameComboBox;
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//treatment2=new String[2000];
				todaysFeesDetails window = new todaysFeesDetails(farmerID,fees,actualDate);
					window.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public todaysFeesDetails(int id,int fee,String dt) {
		
		farmerID = id;
		
		fees = fee;
		
		actualDate = dt;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(-10, 0, 1400, 722);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 148, 680, 414);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox animalNameComboBox = new JComboBox();
		animalNameComboBox.setBounds(397, 56, 211, 28);
		panel.add(animalNameComboBox);
		animalNameComboBox.setToolTipText("Select Animal Name");
		
		JLabel lblNewLabel = new JLabel("Fees Details");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(582, 29, 206, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(766, 148, 594, 414);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnterAnimalName = new JLabel("Enter Animal Name : ");
		lblEnterAnimalName.setBounds(51, 166, 159, 20);
		panel_1.add(lblEnterAnimalName);
		lblEnterAnimalName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblSelectAnimalType = new JLabel(" Select Animal Type  :");
		lblSelectAnimalType.setBounds(38, 59, 172, 20);
		panel_1.add(lblSelectAnimalType);
		lblSelectAnimalType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		JComboBox addAnimalTypeComboBox = new JComboBox();
		addAnimalTypeComboBox.setBounds(287, 56, 272, 28);
		panel_1.add(addAnimalTypeComboBox);
		addAnimalTypeComboBox.setToolTipText("Select Animal Type");
		
		addAnimalNameTextField = new JTextField();
		addAnimalNameTextField.setBounds(287, 165, 272, 25);
		panel_1.add(addAnimalNameTextField);
		addAnimalNameTextField.setColumns(10);
		
		
		JButton btnAddAnimal = new JButton(" Add Animal");
		btnAddAnimal.setForeground(new Color(255, 0, 0));
		btnAddAnimal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String animalName=addAnimalNameTextField.getText();
				String animalType=(String) addAnimalTypeComboBox.getSelectedItem();
				int typeId=database_connections.getAnimalTypeId(animalType);
				
				LinkedList<String> animalNames=new LinkedList<String>();
			//	animalNames=database_connections.getAnimalNames( farmerID,typeId);
				//for(int i=0;i<animalNames.size();i++)
				//{
					//newCow=animalNames.get(i);
				//}
				animalNames = database_connections.getAllAnimals(farmerID, typeId);
				//animalNames.add("hello");
				//animalNames.add("hello2");
				//JOptionPane.showMessageDialog(null, animalNames);
				int flag=0;
				for(int i=0;i<animalNames.size();i++)
				{
					String lName=animalNames.get(i);
					if(lName.contentEquals(animalName))
					{
						flag++;
					}
				}
				
			//	JOptionPane.showMessageDialog(null, flag);
				
				if(addAnimalNameTextField.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Plese enter animal name");
				}
				else if(flag >= 1)
				{
					JOptionPane.showMessageDialog(null, "Animal name already Register");
				}
				else
				{
				database_connections.addAnimal(animalName, typeId, farmerID);
				JOptionPane.showMessageDialog(null,animalName+" Added Successfully");
				}
				
				//animalNameComboBox.addItem(newCow);
				todaysFeesDetails.main(null);
				frame.dispose();
			
			
			
			
			
			
			}
		});
		btnAddAnimal.setBounds(287, 271, 142, 37);
		panel_1.add(btnAddAnimal);
		
		JLabel label = new JLabel("___________________________________________________________________________________________________________________________________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 88, 1350, 14);
		frame.getContentPane().add(label);
		
		JLabel lblSelectAnimalName = new JLabel(" Select Animal Type And Name:");
		lblSelectAnimalName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectAnimalName.setBounds(25, 207, 224, 20);
		frame.getContentPane().add(lblSelectAnimalName);
		
	
		
		tretmentNameComboBox = new JComboBox();
		tretmentNameComboBox.setBounds(237, 157, 371, 28);
		panel.add(tretmentNameComboBox);
		tretmentNameComboBox.setToolTipText("");
		
		LinkedList<String> tName = new LinkedList<String>();
		tName = database_connections.getTreatment();
		int j=0;
		for(j=0;j<tName.size();j++)
		{
			tretmentNameComboBox.addItem(tName.get(j));
		//	treatment2[j] =treatment2[j];
		}
		//tretmentNameComboBox.addItem(treatment2[j]);
		
	
		
		JComboBox animalTypeComboBox = new JComboBox();
		animalTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String animalType = (String) animalTypeComboBox.getSelectedItem();
				//	JOptionPane.showMessageDialog(null, animalType);
					int animalId=database_connections.getAnimalTypeId(animalType);
					
					
					LinkedList<String> animalNames=new LinkedList<String>();
					animalNames=database_connections.getAnimalNames(farmerID,animalId);
					animalNameComboBox.removeAllItems();
					for(int i=0;i<animalNames.size();i++)
					{
					animalNameComboBox.addItem(animalNames.get(i));
					}
				
				
				
			}
		});
		
		
		LinkedList<String> animalTypes=new LinkedList<String>();
		animalTypes=database_connections.getAnimalType();
		for(int i=0;i<animalTypes.size();i++)
		{
		animalTypeComboBox.addItem(animalTypes.get(i));
		}
		
		
		
		animalTypeComboBox.setBounds(237, 56, 113, 28);
		panel.add(animalTypeComboBox);
		animalTypeComboBox.setToolTipText("Select Animal Type");
		
		
		
		
	
		
	
	
		
		JLabel lblSelectTreatement = new JLabel(" Select Treatment :");
		lblSelectTreatement.setBounds(90, 159, 136, 20);
		panel.add(lblSelectTreatement);
		lblSelectTreatement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		

		
		
		JButton btnAddPayment = new JButton("Submit");
		btnAddPayment.setForeground(new Color(255, 0, 0));
		btnAddPayment.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAddPayment.setBounds(296, 280, 97, 37);
		panel.add(btnAddPayment);
		btnAddPayment.setBackground(new Color(0, 255, 255));
		btnAddPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String animalName = (String) animalNameComboBox.getSelectedItem();
				int animalId = database_connections.getAnimalId(farmerID, animalName);
				
				String tName=(String) tretmentNameComboBox.getSelectedItem();
				int tId = database_connections.getTreatmentId(tName);
				
				if(database_connections.insertPaymentDetails(animalId, tId, farmerID, fees, actualDate))
				{
				if(database_connections.updateUnpaidFees(fees, farmerID,actualDate))
				{
					JOptionPane.showMessageDialog(null, "Submitted Successfully..");
					 int newEntry=database_connections.refreshRestQuanifier(farmerID);
					 String newEntry2=String.valueOf(newEntry);
					Doctor_main_frame.restQuantifierTextField.setText(newEntry2);
				}
				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "something went wrong");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			//	Doctor_main_frame.main(null);
				
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBackground(new Color(0, 255, 127));
		btnBack.setBounds(41, 29, 89, 44);
		frame.getContentPane().add(btnBack);
		
		
		
		for(int i=0;i<animalTypes.size();i++)
		{
			addAnimalTypeComboBox.addItem(animalTypes.get(i));
		}
	
	}
}
