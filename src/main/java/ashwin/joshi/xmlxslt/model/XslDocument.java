package ashwin.joshi.xmlxslt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.File;

public class XslDocument{

    @Id
    private String id;
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
        return "XslDocument{" +
                "id='" + id + '\'' +
                ", sourceFilePath='" + sourceFilePath + '\'' +
                ", sourceFile=" + sourceFile +
                ", content='" + content + '\'' +
                '}';
    }
}
