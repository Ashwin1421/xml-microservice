package ashwin.joshi.xmlxslt.model;

import javax.persistence.Transient;
import java.io.File;

public class BaseDocument {
    private String sourceFilePath;

    @Transient
    private File sourceFile;
    private String content;

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
}
