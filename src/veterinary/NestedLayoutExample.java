package veterinary;

import java.util.LinkedList;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class NestedLayoutExample
{
	private JTable table;
	
	NestedLayoutExample()
	{
		JFrame f;
		try
		{
			f=new JFrame();
		LinkedList<String> ls=new LinkedList<String>();
		ls=database_connections.getTreatmentFeetableDetails(32);
		String[][] data = new String[ls.size()][5];
		int k=0;
		for(int i=0;i<(ls.size()/5);i++)
		{
			for(int j=0;j<5;j++)
			{
			data[i][j]=ls.get(k);
			k++;
			}
			
		}
		String[] column= {"Type","Animal Name","Treatment","Fees","Date"};
		f.setSize(889,416);
		f.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 171, 524, 176);
		f.getContentPane().add(scrollPane);

		table = new JTable(data,column);
		scrollPane.setViewportView(table);
		
		JButton btnOk = new JButton(" ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}
		});
		btnOk.setBounds(325, 33, 89, 23);
		f.getContentPane().add(btnOk);
		f.setVisible(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
			//JOptionPane.showMessageDialog(null, e);
		}
	}
	public static void main(String args[])
	{
		NestedLayoutExample n=new NestedLayoutExample();
	}
}