package ashwin.joshi.xmlxslt.service.impl;

import ashwin.joshi.xmlxslt.dao.XmlDocumentDAO;
import ashwin.joshi.xmlxslt.exception.DocumentObjectException;
import ashwin.joshi.xmlxslt.model.XmlDocument;
import ashwin.joshi.xmlxslt.service.XmlDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class XmlDocumentServiceImpl implements XmlDocumentService {

    @Autowired
    private XmlDocumentDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<XmlDocument> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public XmlDocument findById(String id) {
        Optional<XmlDocument> xml = dao.findById(id);
        if(!xml.isPresent()){
            throw new DocumentObjectException("Document object with id='"+id+"\' does not exist.");
        }
        return xml.get();
    }

    @Override
    @Transactional
    public XmlDocument create(XmlDocument xmlDocument) {
        Optional<XmlDocument> xml = dao.findById(xmlDocument.getId());
        if(xml.isPresent()){
            throw new DocumentObjectException("Document object with id='"+xmlDocument.getId()+"\' already exists.");
        }
        return dao.save(xmlDocument);
    }

    @Override
    @Transactional
    public XmlDocument update(String id, XmlDocument xmlDocument) {
        Optional<XmlDocument> xml = dao.findById(id);
        if(!xml.isPresent()){
            throw new DocumentObjectException("Document object with id='"+id+"\' does not exist.");
        }
        return dao.save(xmlDocument);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Optional<XmlDocument> xml = dao.findById(id);
        if(!xml.isPresent()){
            throw new DocumentObjectException("Document object with id='"+id+"\' does not exist.");
        }
        dao.delete(xml.get());
    }
}
