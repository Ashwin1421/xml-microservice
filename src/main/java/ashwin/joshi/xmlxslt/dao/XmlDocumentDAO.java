package ashwin.joshi.xmlxslt.dao;

import ashwin.joshi.xmlxslt.model.XmlDocument;
import org.springframework.data.repository.CrudRepository;

public interface XmlDocumentDAO extends CrudRepository<XmlDocument, String> {
}
