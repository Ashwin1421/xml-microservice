package ashwin.joshi.xmlxslt.service;

import ashwin.joshi.xmlxslt.model.PdfDocument;

import java.util.List;

public interface PdfDocumentService {

    List<PdfDocument> findAll();
    PdfDocument findById(String id);
    PdfDocument create(PdfDocument pdfDocument);
    PdfDocument update(String id, PdfDocument pdfDocument);
    void delete(String id);
}
