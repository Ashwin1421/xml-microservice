package ashwin.joshi.xmlxslt.dao;

import ashwin.joshi.xmlxslt.model.PdfDocument;
import org.springframework.data.repository.CrudRepository;

public interface PdfDocumentDAO extends CrudRepository<PdfDocument, String> {
}
