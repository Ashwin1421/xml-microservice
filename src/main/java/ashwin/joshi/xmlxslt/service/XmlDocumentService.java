package ashwin.joshi.xmlxslt.service;

import ashwin.joshi.xmlxslt.model.XmlDocument;

import java.util.List;

public interface XmlDocumentService {
    List<XmlDocument> findAll();
    XmlDocument findById(String id);
    XmlDocument create(XmlDocument xmlDocument);
    XmlDocument update(String id, XmlDocument xmlDocument);
    void delete(String id);
}
