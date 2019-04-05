package ashwin.joshi.xmlxslt.service.impl;

import ashwin.joshi.xmlxslt.dao.XslDocumentDAO;
import ashwin.joshi.xmlxslt.exception.DocumentObjectException;
import ashwin.joshi.xmlxslt.model.XslDocument;
import ashwin.joshi.xmlxslt.service.XslDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class XslDocumentServiceImpl implements XslDocumentService {

    @Autowired
    private XslDocumentDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<XslDocument> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public XslDocument findById(String id) {
        Optional<XslDocument> xsl = dao.findById(id);
        if(!xsl.isPresent()){
            throw new DocumentObjectException("Document object with id='"+id+"\' does not exist.");
        }
        return xsl.get();
    }

    @Override
    @Transactional
    public XslDocument create(XslDocument xslDocument) {
        Optional<XslDocument> xsl = dao.findById(xslDocument.getId());
        if(xsl.isPresent()){
            throw new DocumentObjectException("Document object with id='"+xslDocument.getId()+"\' already exists.");
        }
        return dao.save(xslDocument);
    }

    @Override
    @Transactional
    public XslDocument update(String id, XslDocument xslDocument) {
        Optional<XslDocument> xsl = dao.findById(id);
        if(!xsl.isPresent()){
            throw new DocumentObjectException("Document object with id='"+xslDocument.getId()+"\' does not exist.");
        }
        return dao.save(xslDocument);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Optional<XslDocument> xsl = dao.findById(id);
        if(!xsl.isPresent()){
            throw new DocumentObjectException("Document object with id='"+id+"\' does not exist.");
        }
        dao.delete(xsl.get());
    }
}
