import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;

public class PdfTable
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
			doc.add(new Paragraph(" Good Morning"));
			doc.add(new Paragraph("\n Good Afternoon"));
			doc.add(new Paragraph("\n Good Evening"));
			doc.add(new Paragraph("\n Good Night"));

			doc.add(new Paragraph(" "));
			
			// Table 1 Creatoion
			PdfPTable table = new PdfPTable(3);
			PdfPCell c1;
			table.addCell(new Phrase("Table Header 1"));
			
			c1 = new PdfPCell(new Phrase("Table Header 2"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			//c1.setFixedHeight(55);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Table Header 3"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			//c1.setFixedHeight(55);
			table.addCell(c1);
			
			table.setHeaderRows(1);
			table.addCell("1.0");	table.addCell("1.1");	table.addCell("1.2");
			table.addCell("2.0");	table.addCell("2.1");	table.addCell("2.2");
			doc.add(table);
			
			doc.add(new Paragraph(" "));

			// Table 2 Creation

			table = new PdfPTable(3);
			c1 = new PdfPCell(new Phrase("Cell With Colspan 3"));//column
			c1.setColspan(3);
			table.addCell(c1);
			c1 = new PdfPCell(new Phrase("Cell With Rowspan 2"));//row
			c1.setRowspan(2);
			table.addCell(c1);
			
			table.addCell("row 1; cell 1");	table.addCell("row 1; cell 2");
			table.addCell("row 2; cell 1");	table.addCell("row 2; cell 2");
			doc.add(table);
			
			doc.add(new Paragraph(" "));

			// add List
			// List list = new List(False);
			 List list = new List(true);
			 list.add(new ListItem("one"));
			 list.add(new ListItem("two"));
			 list.add(new ListItem("three"));
			doc.add(list);
			
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