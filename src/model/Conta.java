package model;

import java.sql.SQLException;

import dao.ContaDAO;
import to.ContaTO;

public class Conta{

	private String nome;
	public String senha;
	private int	 conta;
	private int agencia;
	private double saldo;

	public Conta(int conta,String nome,double saldo,int agencia,String senha)
	{
		this.agencia = agencia;
		this.conta = conta;
		this.nome = nome;
		this.saldo = saldo;
		this.senha = senha;
	}
	
	public Conta(int conta)
	{
		this.conta = conta;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
	
	public double saldo() throws SQLException
	{
		ContaDAO dao = new ContaDAO();
		ContaTO to = new ContaTO();
		to.setCli(nome);
		to.setAgencia(agencia);
		to.setConta(conta);
		to.setSaldo(saldo);
		to.setSenha(senha);
		return dao.mostraSaldo(to);
	}
	
	public void saque(double valor) throws SQLException
	{
		ContaDAO dao = new ContaDAO();
		ContaTO to = dao.carregar(getConta());
		dao.saque(to, valor);
		setSaldo((getSaldo()-valor));
		dao.insereMov(to, valor, "saque");
	}
	
	public void carrega()
	{
		ContaDAO dao = new ContaDAO();
		ContaTO to = dao.carregar(conta);
		setNome(to.getNome());
		setAgencia(to.getAgencia());
		setConta(to.getConta());
		setSaldo(to.getSaldo());
		setSenha(to.getSenha());
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
