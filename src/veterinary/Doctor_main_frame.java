package veterinary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.decorator.FontHighlighter;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.portable.ValueOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableHeader;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.Highlighter;
import javax.swing.text.ViewFactory;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Doctor_main_frame {

	private JFrame frame;
	private JButton submitNewFarmerbtn;
	public static JTabbedPane tabbedPane;
	private JTextField textField;
	private JComboBox farmerNameComboBox ;
	private JFormattedTextField farmerDetailsDateTextField;
	private JFormattedTextField todaysChargesFormattedTextField;
	public static JTextField restQuantifierTextField;
	private JTextField dedutionTextField;
	private JTextField dairyPanelRestQuantifierTextField;
	private JComboBox dairyPanelFamerNameComboBox;
	private JComboBox dairyNamecomboBox; 
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private static int ii=0;
	private static LinkedList<String> ls2=null;
	private static LinkedList<String> ls=null;
	private int fId;
	private String fname=null;
	private JComboBox viewfarmerNameComboBox ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_main_frame window = new Doctor_main_frame();
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
	public Doctor_main_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Nehe Veterinary");
		frame.setBounds(-10, 0, 1386, 741);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.controlLtHighlight);
		tabbedPane.setForeground(SystemColor.inactiveCaptionText);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tabbedPane.setBounds(6, 89, 1358,605);
		frame.getContentPane().add(tabbedPane);
		//	farmerDetailsPanel.initialize();

		//	JOptionPane.showMessageDialog(null, database_connections.getTodaysDate());

		//------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------

		JLabel lblOmSaiRam = new JLabel("\u092A\u0936\u0941\u0938\u0902\u0935\u0930\u094D\u0927\u0928");
		//lblOmSaiRam.setText(arg0);
		lblOmSaiRam.setForeground(new Color(51, 204, 0));
		lblOmSaiRam.setHorizontalAlignment(SwingConstants.CENTER);
		lblOmSaiRam.setFont(new Font("DialogInput", Font.BOLD, 50));
		lblOmSaiRam.setBounds(351, 0, 631, 86);
		frame.getContentPane().add(lblOmSaiRam);


		//	Date date=new Date();
		//SimpleDateFormat dateformat=new SimpleDateFormat("yyy/MM/dd");
		//String Farmer_registration_date=dateformat.format(date);
		String Farmer_registration_date=database_connections.getTodaysDate();



		farmerNameComboBox = new JComboBox();
		farmerNameComboBox.setForeground(Color.BLACK);












		//==============================================================================================
		//==============================================================================================



		//JPanel  FarmerDetails = new JPanel();
		//tabbedPane.addTab("New tab", null, panel, null);


		JPanel FarmerDetails = new JPanel();
		tabbedPane.addTab("Farmer Details", null, FarmerDetails, null);
		FarmerDetails.setLayout(null);
		FarmerDetails.setBorder(new LineBorder(Color.ORANGE, 2));
		FarmerDetails.setBackground(UIManager.getColor("List.dropCellBackground"));


		JLabel lblSelectFarmer = new JLabel("Select Farmer:");
		lblSelectFarmer.setForeground(Color.DARK_GRAY);
		lblSelectFarmer.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectFarmer.setBounds(119, 129, 202, 36);
		FarmerDetails.add(lblSelectFarmer);

		JFormattedTextField contact_formattedTextField = new JFormattedTextField();
		contact_formattedTextField.setForeground(Color.BLACK);
		contact_formattedTextField.setEditable(false);
		contact_formattedTextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		contact_formattedTextField.setBounds(930, 137, 287, 31);
		FarmerDetails.add(contact_formattedTextField);

		JLabel label_2 = new JLabel("Contact No:");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(717, 137, 202, 36);
		FarmerDetails.add(label_2);

		JLabel lblTotalRemainingFees = new JLabel("Total Remaining Fees:");
		lblTotalRemainingFees.setForeground(Color.DARK_GRAY);
		lblTotalRemainingFees.setFont(new Font("Dialog", Font.BOLD, 17));
		lblTotalRemainingFees.setBounds(115, 367, 202, 36);
		FarmerDetails.add(lblTotalRemainingFees);

		restQuantifierTextField = new JFormattedTextField();
		restQuantifierTextField.setForeground(Color.BLACK);
		restQuantifierTextField.setEditable(false);
		restQuantifierTextField.setToolTipText("enter unpaid fees here");
		restQuantifierTextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		restQuantifierTextField.setBounds(328, 367, 287, 31);
		FarmerDetails.add(restQuantifierTextField);

		JLabel label_4 = new JLabel("Address:");
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Dialog", Font.BOLD, 20));
		label_4.setBounds(717, 371, 125, 36);
		FarmerDetails.add(label_4);

		JTextArea textArea = new JTextArea();
		textArea.setText("heel");
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(1239, 112, -334, 69);
		FarmerDetails.add(textArea);

		JTextArea addressTextArea = new JTextArea();
		addressTextArea.setForeground(Color.BLACK);
		addressTextArea.setEditable(false);
		addressTextArea.setFont(new Font("Courier New", Font.BOLD, 16));
		addressTextArea.setBackground(new Color(250, 240, 230));
		addressTextArea.setBounds(928, 358, 289, 82);
		FarmerDetails.add(addressTextArea);

		JLabel lblFarmerDetails = new JLabel("Farmer Details");
		lblFarmerDetails.setBackground(new Color(0, 51, 204));
		lblFarmerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarmerDetails.setForeground(new Color(0, 0, 255));
		lblFarmerDetails.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblFarmerDetails.setBounds(463, 14, 553, 60);
		FarmerDetails.add(lblFarmerDetails);

		JLabel label_6 = new JLabel("Dairy Name:");
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Dialog", Font.BOLD, 20));
		label_6.setBounds(121, 291, 202, 36);
		FarmerDetails.add(label_6);

		JFormattedTextField registrationDatetxtField = new JFormattedTextField();
		registrationDatetxtField.setForeground(Color.BLACK);
		registrationDatetxtField.setEditable(false);
		registrationDatetxtField.setFont(new Font("DialogInput", Font.BOLD, 20));
		registrationDatetxtField.setBounds(930, 294, 287, 31);
		FarmerDetails.add(registrationDatetxtField);

		JLabel lblRegistrationDate_1 = new JLabel("Registration Date:");
		lblRegistrationDate_1.setForeground(Color.DARK_GRAY);
		lblRegistrationDate_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRegistrationDate_1.setBounds(717, 291, 202, 36);
		FarmerDetails.add(lblRegistrationDate_1);


		JFormattedTextField dairyNameformattedTextField = new JFormattedTextField();
		dairyNameformattedTextField.setForeground(Color.BLACK);
		dairyNameformattedTextField.setEditable(false);
		dairyNameformattedTextField.setText("  ");
		dairyNameformattedTextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		dairyNameformattedTextField.setBounds(332, 296, 287, 31);
		FarmerDetails.add(dairyNameformattedTextField);


		JLabel lblTodaysCharges = new JLabel("Todays Charges");
		lblTodaysCharges.setForeground(Color.DARK_GRAY);
		lblTodaysCharges.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTodaysCharges.setBounds(121, 217, 202, 36);
		FarmerDetails.add(lblTodaysCharges);

		todaysChargesFormattedTextField = new JFormattedTextField();
		todaysChargesFormattedTextField.setForeground(Color.BLACK);
		todaysChargesFormattedTextField.setFont(new Font("DialogInput", Font.BOLD, 22));
		todaysChargesFormattedTextField.setBounds(332, 217, 115, 36);
		FarmerDetails.add(todaysChargesFormattedTextField);

		JLabel lblTodaysPaid = new JLabel("Todays Paid");
		lblTodaysPaid.setForeground(Color.DARK_GRAY);
		lblTodaysPaid.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTodaysPaid.setBounds(717, 217, 202, 36);
		FarmerDetails.add(lblTodaysPaid);

		JFormattedTextField todaysPaidTextField = new JFormattedTextField();
		todaysPaidTextField.setForeground(Color.BLACK);
		todaysPaidTextField.setFont(new Font("DialogInput", Font.BOLD, 22));
		todaysPaidTextField.setBounds(928, 217, 142, 36);
		FarmerDetails.add(todaysPaidTextField);

		JButton todaysChargesBtnAdd = new JButton("ADD");
		todaysChargesBtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String farmer_name = farmerNameComboBox.getSelectedItem().toString();
				int charges=0,flag=0;
				try
				{
					charges=Integer.parseInt(todaysChargesFormattedTextField.getText());
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Enter valid amount");
					flag=1;
				}
				if(flag == 0)
				{
					int id=database_connections.getFarmerId(farmer_name);
					String date=farmerDetailsDateTextField.getText();
					//int money=database_connections.refreshRestQuanifier( id);

					//	String money2=String.valueOf(money);
					//	restQuantifierTextField.setText(money2);
					//	JOptionPane.showMessageDialog(null, "Added Successful");
					//int id=database_connections.getFarmerId(farmer_name);
					int fees = Integer.parseInt(todaysChargesFormattedTextField.getText());

					String actualDate = farmerDetailsDateTextField.getText();

					todaysFeesDetails ds = new todaysFeesDetails(id,fees,actualDate);



					ds.main(null);
					//	frame.dispose();



				}

			}
		});
		todaysChargesBtnAdd.setBounds(521, 223, 98, 31);
		FarmerDetails.add(todaysChargesBtnAdd);

		JButton todaysPaidAddBtn = new JButton("ADD");
		todaysPaidAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String todaysPaidString=null;
				int todaysPaidInt=0;
				try
				{
					String farmer_name=(String) farmerNameComboBox.getSelectedItem();
					todaysPaidString=todaysPaidTextField.getText();
					todaysPaidInt=Integer.parseInt(todaysPaidString);
					int id=database_connections.getFarmerId(farmer_name);

					int result = database_connections.updateTodaysPaid(todaysPaidInt, id);
					if(result==1)
					{
						JOptionPane.showMessageDialog(null, "Submitted Successfully..");
						String farmerName=(String) farmerNameComboBox.getSelectedItem();
						int newEntry=database_connections.refreshRestQuanifier(database_connections.getFarmerId(farmerName));
						String newEntry2=String.valueOf(newEntry);
						restQuantifierTextField.setText(newEntry2);
					}



				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "enter valid amount");
				}
			}
		});
		todaysPaidAddBtn.setBounds(1119, 217, 98, 34);
		FarmerDetails.add(todaysPaidAddBtn);



		farmerNameComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {




				String str=farmerNameComboBox.getSelectedItem().toString();
				lblFarmerDetails.setText(str);
				LinkedList farmerDetails = new LinkedList();
				//JOptionPane.showMessageDialog(null, "test1");
				//System.out.println(farmerDetails);
				farmerDetails = database_connections.getFarmerDetails(str);
				String contact=(String) farmerDetails.get(0);
				String address=(String) farmerDetails.get(1);
				String registrationDate=(String) farmerDetails.get(2);
				String dairyName=(String) farmerDetails.get(3);
				String remainingFee= (String) farmerDetails.get(4);
				//String REMAININGfEE=remainingFee;
				//System.out.println(registrationDate);
				contact_formattedTextField.setText(contact);
				addressTextArea.setText(address);
				registrationDatetxtField.setText(registrationDate);
				dairyNameformattedTextField.setText(dairyName);
				restQuantifierTextField.setText(remainingFee);


				//JOptionPane.showMessageDialog(null, "test1");

			}
		});
		farmerNameComboBox.setBounds(332, 138, 287, 25);
		FarmerDetails.add(farmerNameComboBox);

		farmerDetailsDateTextField = new JFormattedTextField();
		farmerDetailsDateTextField.setBackground(new Color(255, 0, 0));
		farmerDetailsDateTextField.setForeground(new Color(255, 255, 240));
		farmerDetailsDateTextField.setHorizontalAlignment(SwingConstants.CENTER);
		farmerDetailsDateTextField.setText("  ");
		farmerDetailsDateTextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		farmerDetailsDateTextField.setBounds(1166, 33, 163, 31);
		FarmerDetails.add(farmerDetailsDateTextField);
		farmerDetailsDateTextField.setText(database_connections.getTodaysDate());

		JPanel Register_Farmer_Panel = new JPanel();
		Register_Farmer_Panel.setBackground(SystemColor.controlLtHighlight);
		Register_Farmer_Panel.setBorder(new LineBorder(Color.ORANGE, 2));
		tabbedPane.addTab("Register Farmer", null, Register_Farmer_Panel, null);
		//tabbedPane.setBackgroundAt(1, new Color(0, 191, 255));
		Register_Farmer_Panel.setLayout(null);

		JLabel lblFarmerName = new JLabel("Farmer Name:");
		lblFarmerName.setForeground(Color.CYAN);
		lblFarmerName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFarmerName.setBounds(119, 129, 202, 36);
		Register_Farmer_Panel.add(lblFarmerName);

		JFormattedTextField farmer_name_TextField = new JFormattedTextField();
		farmer_name_TextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		farmer_name_TextField.setBounds(332, 129, 287, 31);
		Register_Farmer_Panel.add(farmer_name_TextField);

		JFormattedTextField contact_no_txtfield = new JFormattedTextField();
		contact_no_txtfield.setFont(new Font("DialogInput", Font.BOLD, 20));
		contact_no_txtfield.setBounds(332, 221, 287, 31);

		Register_Farmer_Panel.add(contact_no_txtfield);

		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setForeground(Color.CYAN);
		lblContactNo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblContactNo.setBounds(119, 221, 202, 36);
		Register_Farmer_Panel.add(lblContactNo);

		JLabel lblRestQuantifier = new JLabel("Rest Quantifier:");
		lblRestQuantifier.setForeground(Color.CYAN);
		lblRestQuantifier.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRestQuantifier.setBounds(119, 323, 202, 36);
		Register_Farmer_Panel.add(lblRestQuantifier);

		JFormattedTextField rest_quantifier_TextField = new JFormattedTextField();
		rest_quantifier_TextField.setToolTipText("enter unpaid fees here");
		rest_quantifier_TextField.setText("0");
		rest_quantifier_TextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		rest_quantifier_TextField.setBounds(332, 323, 287, 31);
		Register_Farmer_Panel.add(rest_quantifier_TextField);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.CYAN);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAddress.setBounds(721, 301, 125, 36);
		Register_Farmer_Panel.add(lblAddress);

		JTextArea txtrHeel = new JTextArea();
		txtrHeel.setForeground(new Color(0, 0, 0));
		txtrHeel.setBackground(new Color(0, 0, 0));
		txtrHeel.setText("heel");
		txtrHeel.setBounds(1239, 112, -334, 69);
		Register_Farmer_Panel.add(txtrHeel);

		JTextArea address_text_area = new JTextArea();
		address_text_area.setText("Nanduri dumala,Sangamner.");
		address_text_area.setFont(new Font("Courier New", Font.BOLD, 16));
		address_text_area.setBackground(new Color(250, 240, 230));
		address_text_area.setBounds(932, 288, 289, 82);
		Register_Farmer_Panel.add(address_text_area);

		JLabel lblNewLabel = new JLabel("Registration Of New Farmer");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(463, 14, 415, 62);
		Register_Farmer_Panel.add(lblNewLabel);

		JLabel lblDairyName = new JLabel("Dairy Name:");
		lblDairyName.setForeground(Color.CYAN);
		lblDairyName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDairyName.setBounds(721, 129, 202, 36);
		Register_Farmer_Panel.add(lblDairyName);

		JComboBox dairy_name_comboBox = new JComboBox();
		dairy_name_comboBox.setToolTipText("Select dairy name");
		dairy_name_comboBox.setBounds(934, 138, 287, 27);
		Register_Farmer_Panel.add(dairy_name_comboBox);


		submitNewFarmerbtn = new JButton("Submit");
		submitNewFarmerbtn.setForeground(new Color(255, 255, 255));
		submitNewFarmerbtn.setFont(new Font("Dialog", Font.BOLD, 18));
		submitNewFarmerbtn.setBackground(new Color(255, 69, 0));
		JFormattedTextField date_txtField = new JFormattedTextField();
		date_txtField.setEditable(false);
		date_txtField.setFont(new Font("DialogInput", Font.BOLD, 20));
		date_txtField.setBounds(931, 216, 287, 31);
		Register_Farmer_Panel.add(date_txtField);
		date_txtField.setText(Farmer_registration_date);



		submitNewFarmerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				int dairy_id=0;
				int rest_quantifier=0;
				String farmer_name=null;
				String contact=null;
				String Address=null;
				String dairy_name=null;



				try
				{
					farmer_name=farmer_name_TextField.getText();


				}
				catch(Exception E)
				{
					flag=1;
					JOptionPane.showMessageDialog(null, E);
				}



				contact=contact_no_txtfield.getText();



				try
				{
					if(rest_quantifier_TextField.getText().length()==0)
					{

					}
					else
					{
						rest_quantifier=Integer.parseInt(rest_quantifier_TextField.getText());
					}
				}
				catch(Exception e)
				{
					flag=1;
					JOptionPane.showMessageDialog(null, e);
				}


				try
				{
					Address=address_text_area.getText();
				}
				catch(Exception E)
				{
					flag=1;
					JOptionPane.showMessageDialog(null, "Enter valid Address");
				}






				try
				{

					dairy_name=(String)dairy_name_comboBox.getSelectedItem();
					//JOptionPane.showMessageDialog(null, dairy_name);
					dairy_id=database_connections.getDairyId(dairy_name);
					if(dairy_id==0)
					{
						JOptionPane.showMessageDialog(null, "dairy id error ");
						flag = 1;
					}

				}
				catch(Exception e)
				{
					flag=1;
					JOptionPane.showMessageDialog(null, "Dairy name error");
				}




				if(flag==0)
				{
					if(database_connections.checkDuplicateEntry(farmer_name))
					{
						JOptionPane.showMessageDialog(null, "Farmer Name Already Exists");
					}
					else if(database_connections.InputFarmerDetails(farmer_name,contact,rest_quantifier,Address,dairy_name,Farmer_registration_date,dairy_id)==1)
					{
						String farmerName = null;
						for(int i=0;i<database_connections.farmerNameList().size();i++)
						{
							farmerName=database_connections.farmerNameList().get(i);

						}
						//famerNameComboBox.addItem(farmerName);
						farmerNameComboBox.addItem(farmerName);
						JOptionPane.showMessageDialog(null, "Registration Complete..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Failed to add..");
					}
				}



			}
		});
		submitNewFarmerbtn.setBounds(621, 445, 98, 26);
		Register_Farmer_Panel.add(submitNewFarmerbtn);


		//------------------------------------------------------------------------------------
		//this code will add dairies from database to JComboBox
		//------------------------------------------------------------------------------------

		for(int i=0;i<database_connections.dairyNamesList().size();i++)
		{
			String dairyname=database_connections.dairyNamesList().get(i);
			dairy_name_comboBox.addItem(dairyname);
		}
		JLabel lblRegistrationDate = new JLabel("Registration Date:");
		lblRegistrationDate.setForeground(Color.CYAN);
		lblRegistrationDate.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRegistrationDate.setBounds(721, 202, 202, 36);
		Register_Farmer_Panel.add(lblRegistrationDate);

		JLabel label_1 = new JLabel(" ");
		label_1.setIcon(new ImageIcon("D:\\java_project1\\veterinary\\bin\\imeages\\smoke_wave_light_line_38970_1920x1080.jpg"));
		label_1.setBounds(0, 0, 1353, 571);
		Register_Farmer_Panel.add(label_1);
		//farmerNameComboBox.addItem("");
		for(int i=0;i<database_connections.farmerNameList().size();i++)
		{
			String farmerName=database_connections.farmerNameList().get(i);
			farmerNameComboBox.addItem(farmerName);
		}

		JPanel viewPanel = new JPanel();
		viewPanel.setForeground(new Color(0, 100, 0));
		tabbedPane.addTab("View", null, viewPanel, null);
		viewPanel.setLayout(null);



		JPanel detailsPanel = new JPanel();
		detailsPanel.setBackground(new Color(255, 0, 0));
		detailsPanel.setBounds(12, 229, 1329, 337);

		detailsPanel.setLayout(null);







		JLabel registrationDateLabel = new JLabel("");
		registrationDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registrationDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		registrationDateLabel.setForeground(Color.CYAN);
		registrationDateLabel.setBounds(165, 112, 190, 33);
		viewPanel.add(registrationDateLabel);

		JLabel contactLabel = new JLabel("");
		contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contactLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contactLabel.setForeground(Color.BLUE);
		contactLabel.setBounds(1113, 39, 190, 33);
		viewPanel.add(contactLabel);
		viewPanel.add(detailsPanel);

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dialog", Font.PLAIN, 20));
		scrollPane.setBorder(new MatteBorder(5, 1, 1, 1, (Color) Color.CYAN));
		scrollPane.setBackground(Color.RED);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		scrollPane.setBounds(12, 12, 1305, 313);
		detailsPanel.add(scrollPane);

		JButton pdfgenerator=new JButton();


		pdfgenerator.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pdfgenerator.setToolTipText("click here to generator pdf");
		pdfgenerator.setBackground(Color.RED);
		pdfgenerator.setBounds(764, 163, 168, 54);
		viewPanel.add(pdfgenerator);
		pdfgenerator.setText("PDF");


		 viewfarmerNameComboBox = new JComboBox();
		viewfarmerNameComboBox.setBounds(412, 39, 435, 33);
		viewPanel.add(viewfarmerNameComboBox);



		JLabel viewRestlabel = new JLabel("");
		viewRestlabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		viewRestlabel.setForeground(Color.CYAN);
		viewRestlabel.setBounds(595, 112, 174, 54);
		viewPanel.add(viewRestlabel);


		JLabel addressLable = new JLabel("");
		addressLable.setHorizontalAlignment(SwingConstants.CENTER);
		addressLable.setForeground(Color.BLUE);
		addressLable.setFont(new Font("Times New Roman", Font.BOLD, 22));
		addressLable.setBounds(972, 126, 341, 33);
		viewPanel.add(addressLable);



		JLabel dairyNameLabel = new JLabel("");
		dairyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dairyNameLabel.setForeground(Color.BLUE);
		dairyNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		dairyNameLabel.setBounds(957, 81, 341, 33);
		viewPanel.add(dairyNameLabel);





		JButton btnDairyDeductions = new JButton("Dairy Deductions");

		btnDairyDeductions.setToolTipText("check Dairy Deductions and dates");
		btnDairyDeductions.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDairyDeductions.setForeground(Color.WHITE);
		btnDairyDeductions.setBackground(Color.MAGENTA);
		btnDairyDeductions.setBounds(39, 179, 204, 38);
		viewPanel.add(btnDairyDeductions);

		JButton btnRecoveries = new JButton("Recoveries");
		btnRecoveries.setToolTipText("check Dairy Deductions and dates");
		btnRecoveries.setForeground(Color.WHITE);
		btnRecoveries.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRecoveries.setBackground(Color.MAGENTA);
		btnRecoveries.setBounds(306, 179, 204, 38);
		viewPanel.add(btnRecoveries);





		//detailsPanel.setVisible(true);

		viewfarmerNameComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				String fName=null;
				fName=(String) viewfarmerNameComboBox.getSelectedItem();
				LinkedList<String> fDetails=new LinkedList<String>();
				fDetails=database_connections.getFarmerDetails(fName);
				registrationDateLabel.setText(fDetails.get(2));
				contactLabel.setText(fDetails.get(0));
				addressLable.setText(fDetails.get(1));
				viewRestlabel.setText(fDetails.get(4));
				dairyNameLabel.setText(fDetails.get(3));
				String[] columnName= {"Animal Type","Animal Name","Treatment","Fees","Date"};
				int fId=database_connections.getFarmerId(fName);
				LinkedList<String> farmer=new LinkedList<String>();
				farmer=database_connections.getTreatmentFeetableDetails(fId);
				String[] row=new String[farmer.size()];







				try
				{
					ls=null;
					ls=new LinkedList<String>();
					ls=database_connections.getTreatmentFeetableDetails(fId);
					String[][] data = new String[ls.size()/2][5];
					int k=0;
					for(int i=0;i<(ls.size()/5);i++)
					{
						for(int j=0;j<5;j++)
						{
							data[i][j]=ls.get(k);
							k++;
						}

					}
					ls=null;
					String[] column= {"Type","Animal Name","Treatment","Fees","Date"};

					table_1 = new JTable(data,column);
					table_1.setRowHeight(45);
					table_1.setForeground(new Color(255, 0, 0));
					table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
					table_1.setBackground(Color.cyan);
					table_1.setGridColor(Color.white);
					//	table_1.getFontMetrics(new Font("Times New Roman", Font.BOLD, 16));
					table_1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
					table_1.setAlignmentX(Component.CENTER_ALIGNMENT);
					scrollPane.setViewportView(table_1);








					







				}
				catch(Exception e)
				{
					System.out.println(e);
					//JOptionPane.showMessageDialog(null, e);
				}


				//	treatmentFeeTable=new JTable(columnName,row);



			}
		});








		btnDairyDeductions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					 fname=(String) viewfarmerNameComboBox.getSelectedItem();
					int fId=database_connections.getFarmerId(fname);
					LinkedList<String> ls2=new LinkedList<String>();
					ls2=database_connections.getDairyDeductionDetails(fId);
					//System.out.println(ls2);
					String[][] data2 = new String[ls2.size()][3];
					int k=0;
					for(int i=0;i<(ls2.size()/3);i++)
					{
						for(int j=0;j<3;j++)
						{
							data2[i][j]= ls2.get(k);
							k++;
						}

					}

					String []column2= {"Amount","Date","Dairy Name"};
					table_1 = new JTable(data2,column2);
					table_1.setRowHeight(45);
					table_1.setForeground(new Color(255, 0, 0));
					table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
					table_1.setBackground(Color.cyan);
					table_1.setGridColor(Color.white);
					//	table_1.getFontMetrics(new Font("Times New Roman", Font.BOLD, 16));
					table_1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
					table_1.setAlignmentX(Component.CENTER_ALIGNMENT);

					scrollPane.setViewportView(table_1);

				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}








			}
		});



















		pdfgenerator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			
					String fName=(String) farmerNameComboBox.getSelectedItem();
					ls=database_connections.getTreatmentFeetableDetails(fId);
					pdf();
				//	System.out.println(ls);


				}							
		});



	



		btnRecoveries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					System.out.println("hello"+ls);
					LinkedList<String> ls2=new LinkedList<String>();
					String fname=(String) viewfarmerNameComboBox.getSelectedItem();
					//fid=database_connections.getFarmerId(fname);

					ls2=database_connections.getPaidFeesDetails(fId);
					//System.out.println(ls2);
					String[][] data2 = new String[ls2.size()][2];
					int k=0;
					for(int i=0;i<(ls2.size()/2);i++)
					{
						for(int j=0;j<2;j++)
						{
							data2[i][j]= ls2.get(k);
							k++;
						}

					}

					String []column2= {"Amount","Date"};
					table_1 = new JTable(data2,column2);
					table_1.setRowHeight(45);
					table_1.setForeground(new Color(255, 0, 0));
					table_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
					table_1.setBackground(Color.cyan);
					table_1.setGridColor(Color.white);
					//	table_1.getFontMetrics(new Font("Times New Roman", Font.BOLD, 16));
					table_1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
					table_1.setAlignmentX(Component.CENTER_ALIGNMENT);
					scrollPane.setViewportView(table_1);

				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});




































		JComboBox dairySelectComboBox = new JComboBox();

		LinkedList<String> viewDairyNames=new LinkedList<String>();
		viewDairyNames=database_connections.dairyNamesList();
		dairySelectComboBox.addItem("All");

		for(int i=0;i<viewDairyNames.size();i++)
		{
			dairySelectComboBox.addItem(viewDairyNames.get(i));
		}

		if(dairySelectComboBox.getSelectedItem().equals("All"))
		{
			viewfarmerNameComboBox.removeAllItems();
			LinkedList<String> viewAllFarmersName=new LinkedList<String>();
			viewAllFarmersName=database_connections.getAllFarmersName();
			for(int i=0;i<viewAllFarmersName.size();i++)
			{
				String viewFarmerName=viewAllFarmersName.get(i);
				viewfarmerNameComboBox.addItem(viewFarmerName);
			}
		}

		dairySelectComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				try
				{

					viewfarmerNameComboBox.removeAllItems();
					if(dairySelectComboBox.getSelectedItem().equals("All"))
					{


						LinkedList<String> viewAllFarmersName=new LinkedList<String>();
						viewAllFarmersName=database_connections.getAllFarmersName();
						for(int i=0;i<viewAllFarmersName.size();i++)
						{
							String viewFarmerName=viewAllFarmersName.get(i);
							viewfarmerNameComboBox.addItem(viewFarmerName);
						}
					}
					else
					{

						String viewSelectedDairy=(String) dairySelectComboBox.getSelectedItem();
						LinkedList<String> viewSelectedFarmersName=new LinkedList<String>();
						viewSelectedFarmersName=database_connections.getFarmerByDairyName(viewSelectedDairy);
						for(int i=0;i<viewSelectedFarmersName.size();i++)
						{
							String viewFarmerName=viewSelectedFarmersName.get(i);
							viewfarmerNameComboBox.addItem(viewFarmerName);
						}

					}
				}
				catch (Exception e) 
				{
					//JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		dairySelectComboBox.setBounds(39, 39, 276, 33);
		viewPanel.add(dairySelectComboBox);



		JLabel lblRegdate = new JLabel("Reg.Date:");
		lblRegdate.setForeground(new Color(0, 255, 0));
		lblRegdate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblRegdate.setBounds(39, 112, 114, 33);
		viewPanel.add(lblRegdate);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContact.setForeground(Color.BLUE);
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblContact.setBounds(947, 39, 150, 33);
		viewPanel.add(lblContact);

		JLabel lblRestQuantifier_2 = new JLabel("Rest Quantifier:");
		lblRestQuantifier_2.setForeground(new Color(0, 255, 0));
		lblRestQuantifier_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblRestQuantifier_2.setBounds(412, 120, 157, 33);
		viewPanel.add(lblRestQuantifier_2);





		//frame







		JPanel dairyDeduction = new JPanel();
		tabbedPane.addTab("Dairy Deductions", null, dairyDeduction, null);
		dairyDeduction.setLayout(null);

		dairyPanelFamerNameComboBox = new JComboBox();

		dairyPanelFamerNameComboBox.setToolTipText("Select dairy name");
		dairyPanelFamerNameComboBox.setBounds(680, 198, 287, 27);
		dairyDeduction.add(dairyPanelFamerNameComboBox);

		JFormattedTextField dateDairyDeductionPanelformattedTextField = new JFormattedTextField();
		dateDairyDeductionPanelformattedTextField.setText("  ");
		dateDairyDeductionPanelformattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		dateDairyDeductionPanelformattedTextField.setForeground(new Color(255, 255, 240));
		dateDairyDeductionPanelformattedTextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		dateDairyDeductionPanelformattedTextField.setBackground(Color.RED);
		dateDairyDeductionPanelformattedTextField.setBounds(1150, 40, 163, 31);
		dairyDeduction.add(dateDairyDeductionPanelformattedTextField);
		dateDairyDeductionPanelformattedTextField.setText(database_connections.getTodaysDate());




		dairyNamecomboBox = new JComboBox();
		dairyNamecomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {


				String str=(String) dairyNamecomboBox.getSelectedItem();

				dairyPanelFamerNameComboBox.removeAllItems();
				LinkedList<String> ls2=new LinkedList<String>();
				ls2=database_connections.getFarmerByDairyName(str);


				for(int i=0;i<ls2.size();i++)
				{
					//	JOptionPane.showMessageDialog(null, ls2.get(i));
					dairyPanelFamerNameComboBox.addItem(ls2.get(i));
				}


			}
		});


		dairyNamecomboBox.setToolTipText("Select dairy name");
		dairyNamecomboBox.setBounds(680, 111, 287, 27);
		dairyDeduction.add(dairyNamecomboBox);

		JLabel lblSelectDairy = new JLabel("Select Dairy:");
		lblSelectDairy.setForeground(new Color(0, 0, 51));
		lblSelectDairy.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSelectDairy.setBounds(432, 105, 153, 36);
		dairyDeduction.add(lblSelectDairy);



		JLabel lblSelectDairy_1 = new JLabel("Select Farmer:");
		lblSelectDairy_1.setForeground(new Color(0, 0, 51));
		lblSelectDairy_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSelectDairy_1.setBounds(432, 192, 152, 36);
		dairyDeduction.add(lblSelectDairy_1);

		JLabel lblRestQuantifier_1 = new JLabel("Rest Quantifier:");
		lblRestQuantifier_1.setForeground(new Color(0, 0, 51));
		lblRestQuantifier_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRestQuantifier_1.setBounds(432, 366, 152, 36);
		dairyDeduction.add(lblRestQuantifier_1);

		JLabel lblDeduction = new JLabel("Deduction:");
		lblDeduction.setForeground(new Color(0, 0, 51));
		lblDeduction.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDeduction.setBounds(433, 277, 152, 36);
		dairyDeduction.add(lblDeduction);

		dedutionTextField = new JTextField();
		dedutionTextField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dedutionTextField.setBounds(680, 276, 287, 27);
		dairyDeduction.add(dedutionTextField);
		dedutionTextField.setColumns(10);

		dairyPanelRestQuantifierTextField = new JTextField();
		dairyPanelRestQuantifierTextField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dairyPanelRestQuantifierTextField.setForeground(Color.RED);
		dairyPanelRestQuantifierTextField.setColumns(10);
		dairyPanelRestQuantifierTextField.setBounds(680, 375, 287, 27);
		dairyDeduction.add(dairyPanelRestQuantifierTextField);


		dairyPanelFamerNameComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				String farmerName=(String) dairyPanelFamerNameComboBox.getSelectedItem();
				int id=database_connections.getFarmerId(farmerName);
				int restQuantifier=database_connections.refreshRestQuanifier(id);
				String tp=String.valueOf(restQuantifier);
				dairyPanelRestQuantifierTextField.setText(tp);

			}
		});


		JButton btnSubmit = new JButton(" Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int deduceMoney=Integer.parseInt(dedutionTextField.getText());
				String farmerName=(String) dairyPanelFamerNameComboBox.getSelectedItem();
				String dairyName=(String) dairyNamecomboBox.getSelectedItem();
				int farmerId=database_connections.getFarmerId(farmerName);
				int dairyId=database_connections.getDairyId(dairyName);
				String date=dateDairyDeductionPanelformattedTextField.getText();
				if(database_connections.insertDairyDeduction(dairyId, farmerId,deduceMoney,date))
				{
					JOptionPane.showMessageDialog(null, "deduce successfully");
					String newRestQuantifier = String.valueOf(database_connections.refreshRestQuanifier(farmerId));
					dairyPanelRestQuantifierTextField.setText(newRestQuantifier);

				}
				else
				{
					JOptionPane.showMessageDialog(null, "failed");
				}



			}
		});
		btnSubmit.setBounds(571, 461, 98, 26);
		dairyDeduction.add(btnSubmit);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("D:\\java_project1\\veterinary\\bin\\imeages\\Smoke-patterns-lines-colorful-1920x1080.jpg"));
		label_5.setBounds(0, 0, 1353, 571);
		dairyDeduction.add(label_5);
		//farmerNameComboBox.setSelectedItem("");
		//dairyNameFormattedTextField.setText();











		//==============================================================================================
		//==============================================================================================







		//-------------------------------------------------------------------------------------
		// Second panel
		//-------------------------------------------------------------------------------------




		JPanel Add_panel = new JPanel();
		Add_panel.setBackground(SystemColor.controlLtHighlight);
		tabbedPane.addTab("Add New Elements", null, Add_panel, null);
		Add_panel.setLayout(null);

		JFormattedTextField Dairy_name_txtField = new JFormattedTextField();
		Dairy_name_txtField.setFont(new Font("DialogInput", Font.BOLD, 20));
		Dairy_name_txtField.setBounds(190, 161, 287, 31);
		Add_panel.add(Dairy_name_txtField);

		JLabel lblDairyName_1 = new JLabel("Dairy Name:");
		lblDairyName_1.setForeground(new Color(255, 255, 204));
		lblDairyName_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDairyName_1.setBounds(41, 158, 141, 36);
		Add_panel.add(lblDairyName_1);

		JLabel lblAddNewElements = new JLabel("Add New Elements In Software");
		lblAddNewElements.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewElements.setForeground(new Color(0, 255, 204));
		lblAddNewElements.setFont(new Font("Dialog", Font.BOLD, 30));
		lblAddNewElements.setBounds(400, 33, 540, 62);
		Add_panel.add(lblAddNewElements);

		JButton Dairy_Add_btn = new JButton("Add ");
		Dairy_Add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String name=Dairy_name_txtField.getText();
				database_connections.add_dairy(name);
				String var = null;
				LinkedList<String> dairyName = new LinkedList<String>();
				dairyName = database_connections.dairyNamesList();
				for(int i=0;i!=dairyName.size();i++)
				{
					var=dairyName.get(i);
				}

				dairy_name_comboBox.addItem(var);
				dairyNamecomboBox.addItem(var);
				dairySelectComboBox.addItem(var);


			}
		});

		Dairy_Add_btn.setBounds(511, 164, 98, 31);
		Add_panel.add(Dairy_Add_btn);

		JLabel lblTreatment = new JLabel("Treatment Name:");
		lblTreatment.setForeground(new Color(255, 255, 204));
		lblTreatment.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTreatment.setBounds(666, 158, 184, 36);
		Add_panel.add(lblTreatment);

		JFormattedTextField Treatment_txtField = new JFormattedTextField();
		Treatment_txtField.setFont(new Font("DialogInput", Font.BOLD, 20));
		Treatment_txtField.setBounds(858, 164, 287, 31);
		Add_panel.add(Treatment_txtField);

		JButton button = new JButton("Add ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String treatment=Treatment_txtField.getText();
					database_connections.add_treatment(treatment);

					/*LinkedList<String> ls = new LinkedList<String>();
				ls = database_connections.getTreatment();
				String str=null;
				//tempString=new String[ls.size()];
				for(int i=0;i<ls.size();i++)
				{
					str=(ls.get(i));
				}
				//todaysFeesDetails.tretmentNameComboBox.addItem(str);*/
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		button.setBounds(1181, 164, 98, 31);
		Add_panel.add(button);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("D:\\java_project1\\veterinary\\bin\\imeages\\13d681b20058a2d6261432a1b69cd781.jpg"));
		label.setBounds(0, 0, 1353, 571);
		Add_panel.add(label);

		JLabel BGImeagelabel = new JLabel("");
		BGImeagelabel.setIcon(new ImageIcon("D:\\java_project1\\veterinary\\bin\\imeages\\214465-light-mountains-landscapes-nature-shades-sky.jpg"));
		BGImeagelabel.setBounds(0, 0, 1370, 705);
		frame.getContentPane().add(BGImeagelabel);

		JButton btnRestart = new JButton("Restart");
		btnRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Doctor_main_frame.main(null);

				frame.dispose();

			}
		});
		btnRestart.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRestart.setBackground(Color.RED);
		btnRestart.setForeground(Color.GREEN);
		btnRestart.setBounds(1111, 60, 98, 26);
		frame.getContentPane().add(btnRestart);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {


				Login_Doctor.main(null);
				frame.dispose();
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogOut.setBackground(Color.RED);
		btnLogOut.setBounds(1221, 60, 98, 26);
		frame.getContentPane().add(btnLogOut);

		JLabel lblallRightsAre = new JLabel("@ALL Rights Are Reserved");
		lblallRightsAre.setFont(new Font("Dialog", Font.BOLD, 16));
		lblallRightsAre.setForeground(Color.WHITE);
		lblallRightsAre.setBounds(1111, 12, 208, 16);
		frame.getContentPane().add(lblallRightsAre);
		//frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, FarmerDetails, lblSelectFarmer, contact_formattedTextField, label_2, lblTotalRemainingFees, restQuantifierTextField, label_4, textArea, addressTextArea, lblFarmerDetails, label_6, registrationDatetxtField, lblRegistrationDate_1, dairyNameformattedTextField, lblTodaysCharges, todaysChargesFormattedTextField, lblTodaysPaid, todaysPaidTextField, todaysChargesBtnAdd, todaysPaidAddBtn, farmerNameComboBox, farmerDetailsDateTextField, Register_Farmer_Panel, lblFarmerName, farmer_name_TextField, contact_no_txtfield, lblContactNo, lblRestQuantifier, rest_quantifier_TextField, lblAddress, txtrHeel, address_text_area, lblNewLabel, lblDairyName, dairy_name_comboBox, date_txtField, submitNewFarmerbtn, lblRegistrationDate, viewPanel, registrationDateLabel, contactLabel, detailsPanel, scrollPane, viewfarmerNameComboBox, viewRestlabel, addressLable, dairyNameLabel, btnDairyDeductions, btnRecoveries, dairySelectComboBox, lblRegdate, lblContact, lblRestQuantifier_2, dairyDeduction, dairyPanelFamerNameComboBox, dateDairyDeductionPanelformattedTextField, dairyNamecomboBox, lblSelectDairy, lblSelectDairy_1, lblRestQuantifier_1, lblDeduction, dedutionTextField, dairyPanelRestQuantifierTextField, btnSubmit, Add_panel, Dairy_name_txtField, lblDairyName_1, lblAddNewElements, Dairy_Add_btn, lblTreatment, Treatment_txtField, button, lblOmSaiRam, BGImeagelabel}));



		LinkedList<String> dairyNames=new LinkedList<String>();
		dairyNames=database_connections.dairyNamesList();
		for(int i=0;i<dairyNames.size();i++)
		{
			dairyNamecomboBox.addItem(dairyNames.get(i));
		}


		//------------------------------------------------------------------------------------
		//this code will add all farmer names from database to the JComobox
		//------------------------------------------------------------------------------------










		//-------------------------------------------------------------------------------------
		// Second panel complete
		//-------------------------------------------------------------------------------------
	}

		void pdf()
		{
			try 
			{
				String name=(String) viewfarmerNameComboBox.getSelectedItem();
				Document document = new Document(PageSize.A4,50,50,50,50);
			
				File f=new File(name);
				//     f.toPath()
				try {
					PdfWriter.getInstance(document,new FileOutputStream(f+".pdf"));
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				document.open();
				PdfPTableHeader header= new PdfPTableHeader();
				header=new PdfPTableHeader();
				PdfPTable table = new PdfPTable(5);
				PdfPCell animalType = new PdfPCell(new Paragraph("Animal type"));
				PdfPCell animalName = new PdfPCell(new Paragraph("Animal Name"));
				PdfPCell Treatment = new PdfPCell(new Paragraph("Treatment"));
				PdfPCell Fees = new PdfPCell(new Paragraph("Fees"));
				PdfPCell dateOfTreatment= new PdfPCell(new Paragraph("Date"));
				table.addCell(animalType);
				table.addCell(animalName);
				table.addCell(Treatment);
				table.addCell(Fees);
				table.addCell(dateOfTreatment);
				LinkedList<String> ls=new LinkedList<String>();
				ls=database_connections.getTreatmentFeetableDetails(fId);
				System.out.println(ls);
				for(int i=0;i<10;i++)
				{
				
				String Type="Cow";
				PdfPCell seller_cell_value = new PdfPCell(new Paragraph(Type));
				String name2="kali gai";
				PdfPCell name_cell_value = new PdfPCell(new Paragraph(name2));
				String Treatment2="AIFirst";
				PdfPCell price_cell_value = new PdfPCell(new Paragraph(Treatment2));
				String Fees2="1000";
				PdfPCell UM_cell_value = new PdfPCell(new Paragraph(Fees2));
				String date="20/10/2020";
				PdfPCell date2 = new PdfPCell(new Paragraph(date));
				table.addCell(seller_cell_value);
				table.addCell(name_cell_value);
				table.addCell(price_cell_value);
				table.addCell(UM_cell_value);
				table.addCell(date);
				document.add(table);
				}
				document.close();
				return;


			} catch (DocumentException ex) {
				JOptionPane.showMessageDialog(null, ex);
				//Logger.getLogger(PdfCreator.class.getName()).log(Level.SEVERE, null, ex);
			}
		


	


	}
}
