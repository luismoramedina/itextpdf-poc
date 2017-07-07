/**
 * @author luismoramedina
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class CreatePdf {
	private static final String IMAGE = "src/main/resources/users.png";
	private static String DEST = "target/generated.pdf";


	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(DEST));
		document.open();
		Image img = Image.getInstance(IMAGE);
		document.add(img);
		document.close();
	}
}