package ashwin.joshi.xmlxslt;

import ashwin.joshi.xmlxslt.model.BaseDocument;
import ashwin.joshi.xmlxslt.model.PdfDocument;
import ashwin.joshi.xmlxslt.model.XmlDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		PdfDocument pdf = new PdfDocument();
	}

}
