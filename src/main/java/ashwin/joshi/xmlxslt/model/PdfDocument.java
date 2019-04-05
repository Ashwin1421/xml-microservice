package ashwin.joshi.xmlxslt.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.File;

public class PdfDocument {

    @Id
    private String id;
    private PDDocument document;
    private String sourceFilePath;

    @Transient
    private File sourceFile;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    @Override
    public String toString() {
        return "PdfDocument{" +
                "id='" + id + '\'' +
                ", document=" + document +
                ", sourceFilePath='" + sourceFilePath + '\'' +
                ", sourceFile=" + sourceFile +
                ", content='" + content + '\'' +
                '}';
    }
}
