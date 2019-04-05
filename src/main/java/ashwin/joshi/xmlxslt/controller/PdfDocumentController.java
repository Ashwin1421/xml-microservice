package ashwin.joshi.xmlxslt.controller;

import ashwin.joshi.xmlxslt.model.PdfDocument;
import ashwin.joshi.xmlxslt.service.PdfDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/docs/pdf")
public class PdfDocumentController {

    @Autowired
    private PdfDocumentService service;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<PdfDocument> findAll(){
        return service.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public PdfDocument findById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public PdfDocument create(@RequestBody PdfDocument pdfDocument){
        return service.create(pdfDocument);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public PdfDocument update(@PathVariable("id") String id, @RequestBody PdfDocument pdfDocument){
        return service.update(id, pdfDocument);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
