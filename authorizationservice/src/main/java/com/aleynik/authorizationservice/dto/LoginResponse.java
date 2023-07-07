package com.aleynik.authorizationservice.dto;

import lombok.Data;

@Data
public class LoginResponse {
	private String login;
	private String accessToken;
	public LoginResponse(String login, String accessToken) {
		this.login = login;
		this.accessToken = accessToken;
	}
}
