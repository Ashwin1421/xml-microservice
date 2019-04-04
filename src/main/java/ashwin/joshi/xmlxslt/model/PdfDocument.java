package ashwin.joshi.xmlxslt.model;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;

@Entity
public class PdfDocument extends BaseDocument{

    @Id
    private String id;
    private PDDocument document;

    public PDDocument getDocument() {
        return document;
    }

    public void setDocument(PDDocument document) {
        this.document = document;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PdfDocument{" +
                "id='" + id + '\'' +
                ", document=" + document +
                '}';
    }
}
