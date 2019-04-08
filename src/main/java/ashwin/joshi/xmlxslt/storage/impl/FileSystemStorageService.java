package ashwin.joshi.xmlxslt.storage.impl;

import ashwin.joshi.xmlxslt.config.StorageProperties;
import ashwin.joshi.xmlxslt.exception.StorageException;
import ashwin.joshi.xmlxslt.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path root;

    public FileSystemStorageService(StorageProperties properties){
        this.root = Paths.get(properties.getLocation());
    }
    @Override
    public void init() {
        try{
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage service", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(file.isEmpty()){
                throw new StorageException("Failed to store empty file "+fileName);
            }

            if(fileName.contains("..")){
                throw new StorageException("Cannot store file '"+fileName+"' with relative path outside current directory.");
            }

            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (IOException e) {
            throw new StorageException("Failed to store file '"+fileName+"'.", e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try{
            return Files.walk(root, 1).filter( path -> !path.equals(root)).map(root::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to load stored files", e);
        }
    }

    @Override
    public Path load(String fileName) {
        return root.resolve(fileName);
    }

    @Override
    public Resource loadAsResource(String fileName) {
        try{
            Path file = load(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new StorageException("File '"+fileName+"' could not be read.");
            }
        } catch (MalformedURLException e) {
            throw new StorageException("Failed to read file '"+fileName+"'.", e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }
}
