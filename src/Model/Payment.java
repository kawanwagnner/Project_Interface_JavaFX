package Model;

public class Payment {
	private long id;

	private String nome;
	private int conta;
	private String CVV;
	private String MMA;
	
	public Payment(long id, String nome, int conta, String CVV, String MMA) {
		super();
		this.id = id;
		this.nome = nome;
		this.conta = conta;
		this.CVV = CVV;
		this.MMA = MMA;
	}

	public Payment() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String CVV) {
		this.CVV = CVV;
	}

	public String getMMA() {
		return MMA;
	}

	public void setMMA(String MMA) {
		this.MMA = MMA;
	}
	
}
