package com.hanifa.springit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class LinkNotFoundException extends Exception{
    private Long linkId;

    public LinkNotFoundException(Long linkId) {
        super(String.format("Link Details not found with id: '%s'", linkId));
    }
}
