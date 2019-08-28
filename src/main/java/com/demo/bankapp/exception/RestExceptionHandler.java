package com.demo.bankapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.bankapp.error.ApiError;
import com.demo.bankapp.error.ApiErrorMessage;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(getClass());
	public static final String ORIGIN_ACCOUNTS_SERVICE = "accounts-service";

	@ExceptionHandler(CustomerNotFoundException.class)
	protected ResponseEntity<ApiError> handleEntityNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		log.info("handleEntityNotFoundException()");

		final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ApiErrorMessage.NOT_FOUND_ERROR, (ServletWebRequest) request);
		apiError.setMessage(ex.getMessage());
		apiError.setOrigin(ORIGIN_ACCOUNTS_SERVICE);

		return ResponseEntity.status(apiError.getHttpStatus()).body(apiError);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ApiError> handleOtherException(Exception ex, WebRequest request) {
		log.info("handleException()");

		final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ApiErrorMessage.GENERIC_ERROR, (ServletWebRequest) request);
		apiError.setMessage(ex.getMessage());
		apiError.setOrigin(ORIGIN_ACCOUNTS_SERVICE);

		return ResponseEntity.status(apiError.getHttpStatus()).body(apiError);
	}
}
