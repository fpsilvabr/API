package br.com.inmetrics.commons.enuns;

public enum Substatus {

	MASSA_DADOS("massa_dados"), 
	AMBIENTE("ambiente"),
	ANALISE_AUTOMACAO("analise_automacao"),
	REGRA_NEGOCIO("regra_negocio");

	private Substatus(String substatus) {
		this.substatus = substatus;
	}

	private String substatus;

	public String getSubStatus() {
		return substatus;
	}
}