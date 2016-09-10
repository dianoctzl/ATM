package to;

public class ContaTO {

	private String cli;
	private double saldo;
	private int conta;
	private int agencia;
	private String senha;
	
		
	public ContaTO()
	{
		cli = "";
		saldo = 0.0;
		conta = 0;
		agencia = 0;
		senha = "0";
	}
	
	public ContaTO(String cli,double saldo,int conta,int agencia, String senha)
	{
		this.cli = cli;
		this.saldo = saldo;
		this.conta = conta;
		this.agencia = agencia;
		this.senha = senha;
	}
	
	public String getNome()
	{
	  return cli;
	}

	public String getCli() {
		return cli;
	}

	public void setCli(String cli) {
		this.cli = cli;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaTO other = (ContaTO) obj;
		if (cli == null) {
			if (other.cli != null)
				return false;
		} else if (!cli.equals(other.cli))
			return false;
		if (conta != other.conta)
			return false;
		if (saldo != other.saldo)
			return false;
		if (agencia != other.agencia)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	

	

	
	
}
