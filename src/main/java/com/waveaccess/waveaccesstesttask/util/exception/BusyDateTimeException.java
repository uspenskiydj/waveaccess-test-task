package com.waveaccess.waveaccesstesttask.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This date time is already busy")
public class BusyDateTimeException extends RuntimeException {
    public BusyDateTimeException(String msg) {
        super(msg);
    }
}
