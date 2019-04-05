package ashwin.joshi.xmlxslt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.w3c.dom.Document;

import java.io.File;

public class XmlDocument{

    @Id
    private String id;
    private Document document;
    private String sourceFilePath;

    @Transient
    private File sourceFile;
    private String content;
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

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "XmlDocument{" +
                "id='" + id + '\'' +
                ", document=" + document +
                ", sourceFilePath='" + sourceFilePath + '\'' +
                ", sourceFile=" + sourceFile +
                ", content='" + content + '\'' +
                '}';
    }
}
