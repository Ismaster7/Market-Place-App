package com.marketplace.marketplace.exception;

import java.util.Date;

public record ExceptionResponse(
        String message,
        Date timeStamp,
        String details

) {
}
