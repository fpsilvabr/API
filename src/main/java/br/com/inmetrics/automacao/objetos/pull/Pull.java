package br.com.inmetrics.automacao.objetos.pull;

public class Pull {

	private Source source;
	private Destination destination;
	private Amount amount;	
	private String transactionCryptogram;

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public String getTransactionCryptogram() {
		return transactionCryptogram;
	}

	public void setTransactionCryptogram(String transactionCryptogram) {
		this.transactionCryptogram = transactionCryptogram;
	}
}
