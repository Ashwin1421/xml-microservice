package ashwin.joshi.xmlxslt.controller;

import ashwin.joshi.xmlxslt.model.XmlDocument;
import ashwin.joshi.xmlxslt.service.XmlDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/docs/xml")
public class XmlDocumentController {

    @Autowired
    private XmlDocumentService service;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<XmlDocument> findAll(){
        return service.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public XmlDocument findById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public XmlDocument create(@RequestBody XmlDocument xmlDocument){
        return service.create(xmlDocument);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public XmlDocument update(@PathVariable("id") String id, @RequestBody XmlDocument xmlDocument){
        return service.update(id, xmlDocument);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }

}
