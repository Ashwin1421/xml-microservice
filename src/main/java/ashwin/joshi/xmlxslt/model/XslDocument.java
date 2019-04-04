package ashwin.joshi.xmlxslt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class XslDocument extends BaseDocument{

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "XslDocument{" +
                "id='" + id + '\'' +
                '}';
    }
}
