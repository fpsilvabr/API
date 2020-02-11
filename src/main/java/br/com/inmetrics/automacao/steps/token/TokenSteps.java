package br.com.inmetrics.automacao.steps.token;

import br.com.inmetrics.automacao.dto.Dto;
import br.com.inmetrics.automacao.funcoes.token.TokenFuncoes;
import cucumber.api.java.pt.Dado;

public class TokenSteps {

	@Dado("^que estaja logado na aplicacao$")
	public void que_estaja_logado_na_aplicacao() throws Throwable {
		Dto.setToken(TokenFuncoes.getToken());
	}
}
