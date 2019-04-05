package ashwin.joshi.xmlxslt.controller;

import ashwin.joshi.xmlxslt.model.XslDocument;
import ashwin.joshi.xmlxslt.service.XslDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/docs/xsl")
public class XslDocumentController {

        @Autowired
        private XslDocumentService service;

        @RequestMapping(
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE
        )
        public List<XslDocument> findAll(){
            return service.findAll();
        }

        @RequestMapping(
                method = RequestMethod.GET,
                value = "/{id}",
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE
        )
        public XslDocument findById(@PathVariable("id") String id){
            return service.findById(id);
        }

        @RequestMapping(
                method = RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE
        )
        public XslDocument create(@RequestBody XslDocument xslDocument){
            return service.create(xslDocument);
        }

        @RequestMapping(
                method = RequestMethod.PUT,
                value = "/{id}",
                consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE
        )
        public XslDocument update(@PathVariable("id") String id, @RequestBody XslDocument xslDocument){
            return service.update(id, xslDocument);
        }

        @RequestMapping(
                method = RequestMethod.DELETE,
                value = "/{id}"
        )
        public void delete(@PathVariable("id") String id){
            service.delete(id);
        }
}
