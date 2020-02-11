package br.com.inmetrics.commons.util;

import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {

	// Criar JsonRequest e Header
	public static String buildRequest(Object pojoObject) throws UnsupportedEncodingException {

		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String jsonRequest = null;

		try {
			jsonRequest = mapper.writeValueAsString(pojoObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonRequest;
	}
}