package com.example.teamapt.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

/**
 * @author iModupsy
 * @created 30/11/2021
 */
public class JsonResponse {

	@JsonProperty("status")

	private HttpStatus status;

	@JsonProperty("success")

	private boolean success;

	@JsonProperty("data")

	private Object data;

	@JsonProperty("message")

	private String message;

	public JsonResponse(HttpStatus status, boolean success, String message, Object data) {

		this.status = status;

		this.success = success;

		this.message = message;

		this.data = data;

	}

	public JsonResponse(HttpStatus status, boolean success, String message) {

		this.status = status;

		this.success = success;

		this.message = message;

	}

	public JsonResponse(HttpStatus status, boolean success, Object data) {

		this.status = status;

		this.success = success;

		this.data = data;

	}

	public JsonResponse(HttpStatus status, String message) {

		this.status = status;

		this.message = message;

	}

	public JsonResponse(HttpStatus status, Object data) {

		this.status = status;

		this.data = data;

	}

}
