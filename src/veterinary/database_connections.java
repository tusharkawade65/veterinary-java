package veterinary;

import java.awt.Component;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;


public class database_connections {

	public static Connection db()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinary" , "root" , "root");
			return con;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	public static String getTodaysDate()
	{
		Date date=new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy/MM/dd");
		return (dateformat.format(date));
	}
	static int validateLogin(String username,String Password)
	{
		try
		{
			Connection con=db();
			if(con!=null)
			{
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from doctor_login");
				while(rs.next())
				{
					String usercheck=rs.getString("username");
					String passcheck=rs.getString("password");
					if(usercheck.contentEquals(username)&& passcheck.contentEquals(Password))
					{
						con.close();
						return 1;
					}
					else
					{
						con.close();
						return 0;
					}
				}
			}
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, "Unable to validate login");
			return 0;
		}
		return 0;
	}
	public static void add_dairy(String name)
	{
		try
		{
			Connection con=db();

			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from dairy_names");
				while(rs.next())
				{
					String dname=rs.getString("dairy_name");
					if(name.equals(dname))
					{
						JOptionPane.showMessageDialog(null, "dairy "+name+" already present in database");
						return;
					}
				}
				int result=stmt.executeUpdate("insert into dairy_names(dairy_name)"+"values('"+name+"')");
				if(result==1)
				{
					JOptionPane.showMessageDialog(null, "dairy added Successfully..");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
				con.close();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Exception.. Something went wrong");
		}
	}


	public static void add_treatment(String treatment)
	{
		try
		{
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from treatment");
				while(rs.next())
				{
					String name=rs.getString("t_name");
					if(name.equals(treatment))
					{
						JOptionPane.showMessageDialog(null, "Treatment "+treatment+" already present in database");
						return;
					}
				}
				int result=stmt.executeUpdate("insert into treatment(t_name)"+"values('"+treatment+"')");
				if(result==1)
				{
					JOptionPane.showMessageDialog(null, "New Tratement added successfully..");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Exception.. Something went wrong");
		}
	}

	public static boolean checkDuplicateEntry(String farmerName)
	{
		try
		{
			int flag=0;
			Connection con=db();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select farmer_name from farmer_details");
			while(rs.next())
			{
				if(rs.getString("farmer_name").equals(farmerName))
				{
					flag++;
				}

			}
			if(flag==0)
			{
				con.close();
				return false;
				
			}
			else
			{
				con.close();
				return true;
			}
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, e);
			return false;

		}
	}









	public static int InputFarmerDetails(String farmer_name,String contact,int rest_quantifier,String Address,String dairy_name,String FarmerRegistrationDate,int dairyid)
	{
		try
		{
			Connection con=db();
			if(con!=null)
			{
				int id=0;
				Statement stmt=con.createStatement();

				int result=stmt.executeUpdate("insert into farmer_details(farmer_name, farmer_contact,address,registration_date,dairy_id)"+"values('"+farmer_name+"','"+contact+"','"+Address+"','"+FarmerRegistrationDate+"','"+dairyid+"')");
				ResultSet rs=stmt.executeQuery("select farmer_id from farmer_details order by farmer_id ");
				while(rs.next())
				{
					id=rs.getInt("farmer_id");
				}
				int result2=stmt.executeUpdate("insert into unpaid_fees( unpaid_fees,farmer_id)"+"values('"+rest_quantifier+"','"+id+"')");
				if (result==result2)
				{
					con.close();
					return result;
				}
				else
				{
					con.close();
					return 0;
				}
			}

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);

		}
		return 0;
	}
	public static int getDairyId(String dairyName)
	{
		try
		{
			int id=0;
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select dairy_id from dairy_names where dairy_name='"+dairyName+"'");
				while(rs.next())
				{
					id=	rs.getInt("dairy_id");
				}
				con.close();
				return id;	
			}

		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, e);
			return 0;
		}
		return 0;
	}
	
	public static LinkedList<String> getFarmerByDairyName(String dairyName)
	{
	
		try
		{
			
			LinkedList<String> farmerNames=new LinkedList<String>();
			int dairyId=getDairyId(dairyName);
			//System.out.println(dairyId);
			
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(" select farmer_name from farmer_details where dairy_id='"+dairyId+"'");
				while(rs.next())
				{
					String dairy=rs.getString("farmer_name");
						farmerNames.add(dairy);


				}
				con.close();
				return farmerNames;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Unable to fetch dairy names");
		}
		return null;
		
	}
	public static LinkedList<String> dairyNamesList()
	{
		try
		{
			LinkedList<String> dairy_names=new LinkedList<String>();
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from dairy_names");
				while(rs.next())
				{
					String dairy=rs.getString("dairy_name");
					dairy_names.add(dairy);


				}
				con.close();
				return dairy_names;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Unable to fetch dairy names");
		}
		return null;
	}
	public static LinkedList<String> farmerNameList()
	{
		try
		{
			LinkedList<String> farmerNames=new LinkedList<String>();
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select farmer_name from farmer_details" );
				while(rs.next())
				{
					String farmerName=rs.getString("farmer_name");
					farmerNames.add(farmerName);
				}
				con.close();
				return farmerNames;
			}

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}

	public static LinkedList<String> getFarmerDetails(String str)
	{
		try
		{
			LinkedList farmerDetails=new LinkedList();
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select farmer_contact,address,registration_date,dairy_name,unpaid_fees from dairy_names dm,farmer_details fd,unpaid_fees uf where dm.dairy_id=fd.dairy_id and uf.farmer_id=fd.farmer_id and farmer_name='"+str+"'");
				//JOptionPane.showMessageDialog(null, "IN DATABASE");
				while(rs.next())
				{
					//	JOptionPane.showMessageDialog(null, "IN DATABASE 2");
					String farmerContact=rs.getString("farmer_contact");
					farmerDetails.add(farmerContact);
					String address=rs.getString("address");
					farmerDetails.add(address);
					String registrationDate=rs.getDate("registration_date").toString();
					farmerDetails.add(2,registrationDate);
					String dairyName=rs.getString("dairy_name");
					farmerDetails.add(dairyName);
					int remaining_fee=rs.getInt("unpaid_fees");
					String rf=Integer.toString(remaining_fee);
					farmerDetails.add(rf);
				}
				con.close();
				//JOptionPane.showMessageDialog(null, "IN DATABASE 3");
				return farmerDetails;
			}

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		return null;
	}



	public static int getFarmerId(String farmer_name)
	{
		int id = 0;
		try
		{
			Connection con = database_connections.db();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select farmer_id from farmer_details where farmer_name = '"+farmer_name+"'");
			while(rs.next())
			{
				id = rs.getInt("farmer_id");
			}
			con.close();
			return id;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return 0;
		}
	}
	public static boolean updateUnpaidFees(int charges,int id,String date)
	{
		try
		{
			int remainings=0;
			Connection con1 = database_connections.db();
			Statement stmt1 = con1.createStatement();
			

			Connection con2 = database_connections.db();
			Statement stmt2 = con1.createStatement();
			
			ResultSet rs = stmt1.executeQuery("select unpaid_fees from unpaid_fees where farmer_id='"+id+"'");

			while(rs.next())
			{
				remainings=rs.getInt("unpaid_fees");
			}
			remainings=remainings+charges;
			
			int result = stmt2.executeUpdate("Update unpaid_fees set unpaid_fees = '"+remainings+"' where farmer_id = '"+id+"'");
			con1.close();
			if(result==1)
			{
				con2.close();
				return true;
			}
			else
			{
				con2.close();
				return false;
			}
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, e);
			return true;

		}

	}
	public static int refreshRestQuanifier(int id)
	{
		int restQuantifier=0;
		try
		{
			Connection con = database_connections.db();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select unpaid_fees from unpaid_fees where farmer_id='"+id+"'");
			while(rs.next())
			{
				restQuantifier=rs.getInt("unpaid_fees");
			}
			con.close();
			return restQuantifier;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}

		return restQuantifier;
	}
	public static int updateTodaysPaid(int paidAmt,int farmerId)
	{
		try
		{
			Connection con = database_connections.db();
			Statement stmt = con.createStatement();
			
			Connection con1 = database_connections.db();
			Statement stmt1 = con1.createStatement();
			
			
			
			//ResultSet rs=stmt.executeQuery("select unpaid_fees from unpaid_fees where farmer_id='"+id+"'");
			int fee = 0;
			Date date=new Date();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
			String formatedDate=dateFormat.format(date);
			ResultSet rs=stmt.executeQuery("select unpaid_fees from unpaid_fees where farmer_id='"+farmerId+"'");
			while(rs.next())
			{
				fee=rs.getInt("unpaid_fees");
			}
			fee=fee-paidAmt;
			int result=stmt1.executeUpdate("insert into paid_fees(paid_fees,paid_date,farmer_id)"+"values('"+paidAmt+"','"+formatedDate+"','"+farmerId+"')");
			if(result==1)
			{
				int result1=stmt.executeUpdate("update unpaid_fees set unpaid_fees='"+fee+"' where farmer_id='"+farmerId+"'");

				con.close();
				con1.close();
				return 1;
			}
			else
			{
				con.close();
				con1.close();
				
				return 0;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "hh"+e);
			return 0;
		}

	}
	
	public static boolean insertDairyDeduction(int dairyId,int farmerId,int amount,String date)
	{
		try
		{
			Connection con = database_connections.db();
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate("insert into dairy_deduction(amount,dairy_id,farmer_id,date)"+"values('"+amount+"','"+dairyId+"','"+farmerId+"','"+date+"')");

			if(result==1)
			{
				if(updateTodaysPaid(amount,farmerId)==1)
				{
					con.close();
				return true;
				}
				else
				{
					con.close();
					return false;
				}
				//return true;
				
			}
			else
			{
				con.close();
				return false;
			}
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, "kkkk"+e);
			return false;

		}

	}

	public static LinkedList<String> getAnimalType()
	{
		try
		{
			LinkedList<String> animalType=new LinkedList<String>();
			Connection con = db();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select animal_type from animal_types");
			while(rs.next())
			{
				String type=rs.getString("animal_type");
				animalType.add(type);
			}
			con.close();
			return animalType;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return null;

	}

	public static LinkedList<String> getAnimalNames(int farmerID,int typeId)
	{
		try
		{
			LinkedList<String> animalNames=new LinkedList<String>();
			Connection con = db();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select animal_name from animal_names where farmer_id='"+farmerID+"' and type_id='"+typeId+"'");
			while(rs.next())
			{
				String name=rs.getString("animal_name");
				animalNames.add(name);
			}
			con.close();
			return animalNames;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return null;

	}


	public static int getAnimalTypeId(String animalType)
	{
		try
		{
			int typeId=0;
			Connection con = db();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select type_id from animal_types where animal_type='"+animalType+"'");
			while(rs.next())
			{
				typeId=rs.getInt("type_id");

			}
			con.close();
			return typeId;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return 0;

	}


	public static boolean addAnimal(String animalName,int typeId,int farmerId)
	{
		try
		{
			Connection con = db();
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate("insert into animal_names (animal_name,type_id,farmer_id)"+"values('"+animalName+"','"+typeId+"','"+farmerId+"')");
			if(rs==1)
			{
				con.close();
				return true;
			}
			else
			{
				con.close();
				return false;
			}
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, e);
			return false;
		}
		//return false;

	}

	public static LinkedList<String> getTreatment()
	{

		try
		{
			LinkedList<String> tName = new LinkedList<String>();
			Connection con = db();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select t_name from treatment");
			while(rs.next())
			{
				tName.add(rs.getString("t_name"));
			}
			con.close();
			return tName;
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

	public static int getAnimalId(int farmerID,String animalName)
	{
		
		try
		{
			int animalId = 0;
			Connection con = db();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select animal_id from animal_names where farmer_id='"+farmerID+"' and animal_name='"+animalName+"'");
			while(rs.next())
			{
				animalId = rs.getInt("animal_id");
			}
			con.close();
			return animalId;
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, e);
			return 0;
		}

	}
	
	public static int getTreatmentId(String tName)
	{

		try
		{	int tId = 0; 
			Connection con = db();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select t_id from treatment where t_name='"+tName+"'");
			while(rs.next())
			{
				tId = rs.getInt("t_id");
			}
			con.close();
			return tId;
		}
		catch(Exception e)
		{

			JOptionPane.showMessageDialog(null, e);
			return 0;
		}
	}

	
	public static boolean insertPaymentDetails(int animalId,int tretmentId,int farmerId,int fees,String date)
	{
		try
		{	 
			Connection con = db();
			Statement stmt = con.createStatement();
		
			int rs = stmt.executeUpdate("insert into everydaypaymentdetails(animal_id,t_id,fee,farmer_id,date)"+"values('"+animalId+"','"+tretmentId+"','"+fees+"','"+farmerId+"','"+date+"')");
			if(rs==1)
			{
				con.close();
				return true;
			}
			else
			{
				con.close();
				return false;
			}
		}
		catch(Exception e)
		{
			//System.out.println(e);
			JOptionPane.showMessageDialog(null, "hfk"+e);
			return false;
		}

		
	}
	public static LinkedList<String> getAllAnimals(int farmerId,int typeId)
	{
		try
		{	 
			Connection con = db();
			Statement stmt = con.createStatement();
			String name=null;
			LinkedList<String> ls=new LinkedList<String>();
			ResultSet rs = stmt.executeQuery("select animal_name from animal_names where farmer_id='"+farmerId+"' and type_id='"+typeId+"'");

			while(rs.next())
			{
				name=rs.getString("animal_name");
				ls.add(name);
			}
			con.close();
			return ls;

		}
		catch(Exception e)
		{
			//System.out.println(e);
			JOptionPane.showMessageDialog(null, "hfk"+e);
			return null;
		}

	}
	
	public static LinkedList<String> getAllFarmersName()
	{
	
		try
		{
			
			LinkedList<String> farmerNames=new LinkedList<String>();			
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(" select farmer_name from farmer_details");
				while(rs.next())
				{
					String dairy=rs.getString("farmer_name");
						farmerNames.add(dairy);


				}
				con.close();
				return farmerNames;
			}
			return null;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Unable to fetch dairy names");
			return null;
		}
		
	}
	
	
	public static LinkedList<String> getTreatmentFeetableDetails(int fId)
	{
		try
		{
			LinkedList<String> details = new LinkedList<String>();
			Connection con = db();
			Statement stmt = con.createStatement();
			ResultSet rs  = stmt.executeQuery("select at.animal_type,an.animal_name,t.t_name,e.fee,e.date from animal_names an,animal_types at,treatment t,everydaypaymentdetails e,farmer_details fd where at.type_id=an.type_id and fd.farmer_id=an.farmer_id and an.animal_id=e.animal_id and t.t_id=e.t_id and fd.farmer_id='"+fId+"' order by date desc");
		
			for(int i=0;rs.next();i++)
			{
				for(int j=1;j<6;j++)
				details.add(rs.getString(j));
			
			}
			//JOptionPane.showMessageDialog(null, details);
			return details;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

	public static LinkedList<String> getDairyDeductionDetails(int id)
	{
	
		try
		{
			
			LinkedList <String>details=new LinkedList<String>();			
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(" select amount,date,dairy_name from dairy_deduction,dairy_names where dairy_names.dairy_id=dairy_deduction.dairy_id and farmer_id='"+id+"'");
				while(rs.next())
				{
					String amt=rs.getString(1);
						details.add(amt);
						String Date=rs.getString("date");
						details.add(Date);
						String dairyName=rs.getString("dairy_name");
						details.add(dairyName);
						

				}
				con.close();
				return details;
			}
			return null;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Unable to fetch dairy names");
			return null;
		}
		
	}


	
	public static LinkedList<String> getPaidFeesDetails(int id)
	{
	
		try
		{
			
			LinkedList <String>details=new LinkedList<String>();			
			Connection con=db();
			if(con!=null)
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(" select paid_fees,paid_date from paid_fees where farmer_id='"+id+"'");
				while(rs.next())
				{
					String amt=rs.getString(1);
						details.add(amt);
						String Date=rs.getString(2);
						details.add(Date);
					

				}
				con.close();
				return details;
			}
			return null;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Unable to fetch dairy names");
			return null;
		}
		
	}









}
