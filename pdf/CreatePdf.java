import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;

public class CreatePdf
{
	public static void main(String a[])
	{
		try
		{
			String path="D:\\10299\\JBatch\\pdf\\Test.pdf";
			OutputStream file = new FileOutputStream(new File(path));
			Document doc = new Document();
			PdfWriter.getInstance(doc,file);
			doc.open();
			doc.add(new Paragraph("Good Morning"));
			doc.close();
			
			/* Open only on Windows
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler"+path");
			*/
			
			// to open on linux as well as windows 
				Desktop desktop = Desktop.getDesktop();
				desktop.open(new java.io.File(path));
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
