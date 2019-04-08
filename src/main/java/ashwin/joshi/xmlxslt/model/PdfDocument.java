package ashwin.joshi.xmlxslt.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.File;

public class PdfDocument {

    @Id
    private String id;
    private String content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "PdfDocument{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
