package ashwin.joshi.xmlxslt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.w3c.dom.Document;

import java.io.File;

public class XmlDocument{

    @Id
    private String id;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "XmlDocument{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
