package veterinary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.xml.soap.Detail;

//import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableHeader;
import com.itextpdf.text.pdf.PdfWriter; 
class pdf{
	
	public LinkedList<String> details=null;
	public static void main(String args[]) 
	{
		try {
			LinkedList<String> details=new LinkedList<String>();
			String name=null;
			pdf p=new pdf(details);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	pdf(LinkedList<String> details) throws FileNotFoundException
	{
		details=new LinkedList<String>();
		System.out.println(details);

	}
	void fun()
	{
		try 
		{
			String name="TTT";
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
			PdfPCell seller_cell = new PdfPCell(new Paragraph("Seller"));
			PdfPCell name_cell = new PdfPCell(new Paragraph("Name"));
			PdfPCell price_cell = new PdfPCell(new Paragraph("Price"));
			PdfPCell UM_cell = new PdfPCell(new Paragraph("UM"));
			PdfPCell quantity_cell = new PdfPCell(new Paragraph("Quantity"));
			table.addCell(seller_cell);
			table.addCell(name_cell);
			table.addCell(price_cell);
			table.addCell(UM_cell);
			table.addCell(quantity_cell);

			String seller="Tushar Kawade";
			PdfPCell seller_cell_value = new PdfPCell(new Paragraph(seller));
			String name2="Dipika Kawade";
			PdfPCell name_cell_value = new PdfPCell(new Paragraph(name2));
			String total_price="500";
			PdfPCell price_cell_value = new PdfPCell(new Paragraph(total_price));
			String UM="Hello world";
			PdfPCell UM_cell_value = new PdfPCell(new Paragraph(UM));
			String quantity="20";
			PdfPCell quantity_cell_value = new PdfPCell(new Paragraph(quantity));
			table.addCell(seller_cell_value);
			table.addCell(name_cell_value);
			table.addCell(price_cell_value);
			table.addCell(UM_cell_value);
			table.addCell(quantity_cell_value);
			document.add(table);

			document.close();
			return;


		} catch (DocumentException ex) {
			JOptionPane.showMessageDialog(null, ex);
			//Logger.getLogger(PdfCreator.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


}
