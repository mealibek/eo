package kg.bakai.eo.utils.exceptions.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ExceptionResponse(

        String message,

        HttpStatus status,

        String className) {
}
