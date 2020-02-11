package br.com.inmetrics.automacao.steps.pull;

import br.com.inmetrics.automacao.funcoes.pull.PullFuncoes;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PullSteps {

	PullFuncoes pull = new PullFuncoes();

	@Dado("^carregue os dados de source$")
	public void carregue_os_dados_de_source(DataTable data) throws Throwable {
		pull.setSource(data);
	}

	/*
	 * @Dado("^carregue os dados de destination$") public void
	 * carregue_os_dados_de_destination(DataTable data) throws Throwable {
	 * pull.setDestination(data); }
	 */

	@Dado("^carregue o dados da aplicacao amount$")
	public void carregue_o_dados_da_aplicacao_amount(DataTable data) throws Throwable {
		pull.setAmount(data);
	}

	@Dado("^carregue o json para o pull$")
	public void carregue_o_json_para_o_pull(DataTable data) throws Throwable {
		pull.setPull(data);
	}

	@Quando("^enviar a requisicao para o pull$")
	public void enviar_a_requisicao_para_o_pull() throws Throwable {
		pull.sendRequest();
	}

	@Entao("^a aplicacao retorna o status solicitado$")
	public void a_aplicacao_retorna_o_status_solicitado(DataTable data) throws Throwable {
		pull.getResponse(data);
	}
}
