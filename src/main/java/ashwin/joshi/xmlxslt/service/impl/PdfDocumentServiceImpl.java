package ashwin.joshi.xmlxslt.service.impl;

import ashwin.joshi.xmlxslt.dao.PdfDocumentDAO;
import ashwin.joshi.xmlxslt.exception.BadRequestException;
import ashwin.joshi.xmlxslt.exception.DocumentObjectException;
import ashwin.joshi.xmlxslt.model.PdfDocument;
import ashwin.joshi.xmlxslt.service.PdfDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class PdfDocumentServiceImpl implements PdfDocumentService {

    @Autowired
    PdfDocumentDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<PdfDocument> findAll() {
        return (List<PdfDocument>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PdfDocument findById(String id) {
        Optional<PdfDocument> pdf = dao.findById(id);
        if(!pdf.isPresent()){
            throw new DocumentObjectException("Document object with id='"+id+"\' not found.");
        }
        return pdf.get();
    }

    @Override
    public PdfDocument create(PdfDocument pdfDocument) {
        Optional<PdfDocument> pdf = dao.findById(pdfDocument.getId());
        if(pdf.isPresent()){
            throw new BadRequestException("Document object with id='"+pdfDocument.getId()+"\' already exists.");
        }
        return dao.save(pdfDocument);
    }

    @Override
    public PdfDocument update(String id, PdfDocument pdfDocument) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
