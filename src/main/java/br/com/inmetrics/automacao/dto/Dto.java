package br.com.inmetrics.automacao.dto;

public class Dto {

	// Armazenar token
	public static String token = null;

	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		Dto.token = token;
	}

}