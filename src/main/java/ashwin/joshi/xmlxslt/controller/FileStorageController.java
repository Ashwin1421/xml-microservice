package ashwin.joshi.xmlxslt.controller;

import ashwin.joshi.xmlxslt.exception.StorageException;
import ashwin.joshi.xmlxslt.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/files/")
public class FileStorageController {

    @Autowired
    private StorageService service;

    @RequestMapping(
            method = RequestMethod.GET
    )
    public String listUploadedFiles(Model model){
        model.addAttribute("files", service.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(
                        FileStorageController.class,
                        "serveFile",
                        path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{fileName:.+}"
    )
    public ResponseEntity<Resource> serveFile(@PathVariable String fileName){
        Resource file = service.loadAsResource(fileName);
        return ResponseEntity.ok().header(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+file.getFilename()+"\""
        ).body(file);
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        service.store(file);
        redirectAttributes.addFlashAttribute(
                "message",
                "File "+file.getOriginalFilename()+" was successfully uploaded."
        );

        return "redirect:/files/";
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageException e){
        return ResponseEntity.notFound().build();
    }
}
