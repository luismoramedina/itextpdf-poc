import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * @author luismoramedina
 */
public class AttachedFile {
	private static final String IMAGE = "src/main/resources/users.png";
	private static String SRC = "src/main/resources/blank.pdf";
	private static String DEST = "target/generated_attach.pdf";

	public static void main(String[] args) throws Exception {
		PdfReader reader = new PdfReader(SRC);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(DEST));
		FileInputStream fileOutputStream = new FileInputStream(IMAGE);
		byte[] bytes = new byte[fileOutputStream.available()];
		fileOutputStream.read(bytes);
		PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(
				stamper.getWriter(), null, "users.png",
				bytes);
		stamper.addFileAttachment("users.png", fs);
		fileOutputStream.close();
		stamper.close();
	}

}