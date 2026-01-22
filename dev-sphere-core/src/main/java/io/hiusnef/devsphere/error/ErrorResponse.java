package io.hiusnef.devsphere.error;

import java.time.LocalDateTime;

import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;
    private String path;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, WebRequest request) {
        this(status, message, request.getDescription(false).replace("uri=", ""), LocalDateTime.now());
    }

}