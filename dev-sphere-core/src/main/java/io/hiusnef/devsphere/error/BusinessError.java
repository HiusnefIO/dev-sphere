package io.hiusnef.devsphere.error;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessError extends RuntimeException {

    private final HttpStatus status;

    public BusinessError(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
