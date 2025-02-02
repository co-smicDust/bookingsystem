package com.bloodDonation.commons.exceptions;

import com.bloodDonation.commons.Utils;
import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends AlertBackException {
    public UnAuthorizedException() {
        this(Utils.getMessage("UnAuthorized","errors"));
    }

    public UnAuthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
