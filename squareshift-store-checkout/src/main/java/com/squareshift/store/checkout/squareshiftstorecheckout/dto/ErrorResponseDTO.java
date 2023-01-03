
package com.squareshift.store.checkout.squareshiftstorecheckout.dto;

import java.util.Date;

public class ErrorResponseDTO {

	private String originalCall;

	private Date errorDateTime;

	private String errorDescription;

	private String errorMessage;

	/**
	 * Instantiates a new api error response dto.
	 *
	 * @param errorDateTime
	 * @param errorDescription
	 * @param errorMessage
	 * @param originalCall
	 * @param errorLayer
	 */
	public ErrorResponseDTO(Date errorDateTime, String errorDescription, String errorMessage, String originalCall) {
		super();
		this.errorDateTime = errorDateTime;
		this.errorDescription = errorDescription;
		this.errorMessage = errorMessage;
		this.originalCall = originalCall;
	}

	public ErrorResponseDTO() {
		super();
	}

	public String getOriginalCall() {
		return originalCall;
	}

	public void setOriginalCall(String originalCall) {
		this.originalCall = originalCall;
	}

	public Date getErrorDateTime() {
		return errorDateTime;
	}

	public void setErrorDateTime(Date errorDateTime) {
		this.errorDateTime = errorDateTime;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
