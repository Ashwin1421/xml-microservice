package ashwin.joshi.xmlxslt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DocumentObjectException extends RuntimeException {

    public DocumentObjectException(String message){
        super(message);
    }
}
