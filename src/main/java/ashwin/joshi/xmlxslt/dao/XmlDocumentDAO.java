package ashwin.joshi.xmlxslt.dao;

import ashwin.joshi.xmlxslt.model.XmlDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface XmlDocumentDAO extends MongoRepository<XmlDocument, String> {
}
