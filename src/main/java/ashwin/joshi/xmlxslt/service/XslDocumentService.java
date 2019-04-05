package ashwin.joshi.xmlxslt.service;

import ashwin.joshi.xmlxslt.model.XslDocument;

import java.util.List;

public interface XslDocumentService {

    List<XslDocument> findAll();
    XslDocument findById(String id);
    XslDocument create(XslDocument xslDocument);
    XslDocument update(String id, XslDocument xslDocument);
    void delete(String id);
}
