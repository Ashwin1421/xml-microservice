package ashwin.joshi.xmlxslt.model;

import org.w3c.dom.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;

@Entity
public class XmlDocument extends BaseDocument{

    @Id
    private String id;
    private Document document;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "XmlDocument{" +
                "id='" + id + '\'' +
                ", document=" + document +
                '}';
    }
}
