package ashwin.joshi.xmlxslt.dao;

import ashwin.joshi.xmlxslt.model.XslDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface XslDocumentDAO extends MongoRepository<XslDocument, String> {
}
