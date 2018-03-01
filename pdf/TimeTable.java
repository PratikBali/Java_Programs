import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;

public class TimeTable
{
	public static void main(String a[])
	{
		try
		{
			String path="D:\\10299\\pdf\\PdfTableDemo.pdf";
			OutputStream file = new FileOutputStream(new File(path));
			Document doc = new Document();
			PdfWriter.getInstance(doc,file);
			doc.open();
			
			// PDF file Properties
			doc.addTitle("My First PDF File");
			doc.addSubject(" To Create Simple Table");
			doc.addKeywords(" Demo of PDF Table");
			doc.addAuthor(" Pratik Sanjay Bali");
			doc.addCreator(" Ranjit Kalgaonkar");
			
			// Write in PDf
			doc.add(new Paragraph("                    My Time Table"));
			
			doc.add(new Paragraph(" "));

			// Table Creation
			PdfPTable table = new PdfPTable(3);
			PdfPCell c1;

			table = new PdfPTable(5);
			c1 = new PdfPCell(new Phrase("Time Table"));//column
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setColspan(5);
			table.addCell(c1);
			
			table.addCell("");

			c1 = new PdfPCell(new Phrase("Days"));//row
			c1.setColspan(4);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Time"));//row
			c1.setRowspan(6);
			table.addCell(c1);
			
			table.addCell("Mon");	table.addCell("Tue");	table.addCell("Wed");	table.addCell("Thu");
				table.addCell("11");
				c1 = new PdfPCell(new Phrase("D"));//row
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setRowspan(2);
				table.addCell(c1);
				table.addCell("E");	table.addCell("F");
			
			table.addCell("12");	table.addCell("G");	table.addCell("H");
			
			table.addCell("1");table.addCell("1");
				c1 = new PdfPCell(new Phrase("J"));//row
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setRowspan(3);
				table.addCell(c1);
				table.addCell("K");

			table.addCell("2");		table.addCell("2");		table.addCell("M");

			table.addCell("3");		table.addCell("N");		table.addCell("O");
			
			doc.add(table);
			doc.close();
			file.close();

			Desktop desktop = Desktop.getDesktop();
			desktop.open(new java.io.File(path));

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}