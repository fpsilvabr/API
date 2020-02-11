package br.com.inmetrics.automacao.funcoes.pull;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import br.com.inmetrics.automacao.dto.Dto;
import br.com.inmetrics.automacao.objetos.pull.Amount;
import br.com.inmetrics.automacao.objetos.pull.Destination;
import br.com.inmetrics.automacao.objetos.pull.Pull;
import br.com.inmetrics.automacao.objetos.pull.Source;
import br.com.inmetrics.commons.util.JsonUtil;
import br.com.inmetrics.commons.util.PropertiesHelper;
import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PullFuncoes {

	private Source source = new Source();
	private Destination destination = new Destination();
	private Amount amount = new Amount();
	private Pull pull = new Pull();

	protected Response response = null;
	protected RequestSpecification request = null;

	public void setSource(DataTable data) {

		//String phoneNumber = Long.parseLong(data.asMaps(String.class, String.class).get(0).get("phoneNumber"));
		//String cardNumbe = Long.parseLong(data.asMaps(String.class, String.class).get(0).get("cardNumbe"));
		
		String phoneNumber = data.asMaps(String.class, String.class).get(0).get("phoneNumber");		
		String expireDate = data.asMaps(String.class, String.class).get(0).get("expireDate");
		String cardNumber = data.asMaps(String.class, String.class).get(0).get("cardNumber");
		String accountType = data.asMaps(String.class, String.class).get(0).get("accountType");
		
		source.setPhoneNumber(phoneNumber);		
		source.setExpireDate(expireDate);
		source.setCardNumber(cardNumber);		
		source.setAccountType(accountType);
	}

	/*
	 * public void setDestination(DataTable data) {
	 * 
	 * String credentialID = data.asMaps(String.class,
	 * String.class).get(0).get("credentialID"); String credentialKey =
	 * data.asMaps(String.class, String.class).get(0).get("credentialKey");
	 * 
	 * destination.setCredentialID(credentialID);
	 * destination.setCredentialKey(credentialKey); }
	 */

	public void setAmount(DataTable data) {
		double value = Double.parseDouble(data.asMaps(String.class, String.class).get(0).get("value"));
		String currency = data.asMaps(String.class, String.class).get(0).get("currency");

		amount.setValue(value);
		amount.setCurrency(currency);
	}

	public void setPull(DataTable data) {

		//int installments = Integer.parseInt(data.asMaps(String.class, String.class).get(0).get("installments"));
		//String description = data.asMaps(String.class, String.class).get(0).get("description");
		String transactionCryptogram = data.asMaps(String.class, String.class).get(0).get("transactionCryptogram");

		pull.setTransactionCryptogram(transactionCryptogram);
		pull.setSource(source);
		//pull.setDestination(destination);
		pull.setAmount(amount);
		

	}

	public void sendRequest() throws UnsupportedEncodingException {

		String json = JsonUtil.buildRequest(pull);
		String url = PropertiesHelper.getProperties("test.properties", "environments.hml");
		String endPoint = PropertiesHelper.getProperties("test.properties", "endpoints.loginUser");

		String token = Dto.getToken();

		//Header h1 = new Header("Accept", "*/*");
		//Header h2 = new Header("Accept-Language", "pt-BR");
		//Header h3 = new Header("User-Agent", "Mozilla/5.0");
		//Header h4 = new Header("access-token", "f0f59fd1-006c-3e58-86a0-d6c82ba8cd76");//token);
		//-----------------------------------------------------------------------------------------
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("request_id", "ba6a2f6f-cc00-4616-858a-b16db4ee0c44");
		Header h3 = new Header("external_transfer_id", "6822496821883");
		Header h4 = new Header("frd_anls_advertisement_id", "83f5ca52-15e7-43e9-90f4-ce7185fc0e16");
		Header h5 = new Header("frd_anls_ip", "172.13.1.4");
		Header h6 = new Header("frd_anls_partner_risk_score", "20");
		Header h7 = new Header("frd_anls_wa_account_id", "b36ad749-6234-47e2-bdf4-bce7a3881a7b");
		Header h8 = new Header("Authorization", "Bearer f0f59fd1-006c-3e58-86a0-d6c82ba8cd76");
		
		//-----------------------------------------------------------------------------------------
		List<Header> list = new ArrayList<Header>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);
		list.add(h5);
		list.add(h6);
		list.add(h7);
		list.add(h8);

		Headers header = new Headers(list);
		//request.headers(header);

		request = RestAssured.with();
		request.headers(header);
		//request = RestAssured.with();
		request.given().contentType(ContentType.JSON).body(json).log().all();

		response = request.when().post(url + endPoint + "/transfers");

	}

	public void getResponse(DataTable data) {
		int statusCode = Integer.parseInt(data.asMaps(String.class, String.class).get(0).get("status"));

		response.then().statusCode(statusCode).extract().response();

		switch (statusCode) {
		case 200:
			System.out.println("[Passed:" + response + "]");
			break;

		default:
			break;
		}
	}
}