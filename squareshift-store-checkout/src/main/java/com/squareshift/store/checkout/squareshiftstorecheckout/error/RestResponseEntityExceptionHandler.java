package com.squareshift.store.checkout.squareshiftstorecheckout.error;

import java.util.Date;

import com.squareshift.store.checkout.squareshiftstorecheckout.dto.ErrorResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	public static final String DATA_NOT_FOUND = "Data Not Found";

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleEntityNotFoundToException(EntityNotFoundException ex,
			final WebRequest req) {
		LOG.error("EntityNotFoundException Occurred ", ex);
		ErrorResponseDTO apiErrorDetailsDto = new ErrorResponseDTO(new Date(), DATA_NOT_FOUND, ex.getMessage(),
				req.getDescription(false));
		return new ResponseEntity<>(apiErrorDetailsDto, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ErrorResponseDTO> handleBadRequestException(BadRequestException ex,
			final WebRequest req) {
		LOG.error("BadRequestException Occurred ", ex);
		ErrorResponseDTO apiErrorDetailsDto = new ErrorResponseDTO(new Date(), DATA_NOT_FOUND, ex.getMessage(),
				req.getDescription(false));
		return new ResponseEntity<>(apiErrorDetailsDto, HttpStatus.BAD_REQUEST);
	}
}
