package model;

import java.sql.Date;

import dao.MovimentacaoDAO;
import to.MovimentacaoTO;

public class Movimentacao {

	private Conta cli;
	private int seq;
	private int conta;
	private int agencia;
	private String operacao;
	private String nome;
	private int contaDestino;
	private int agenciaDestino;
	private double valor;
	private Date data;
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Movimentacao(int sequencia) {
		this.seq = sequencia;
	}

	public Movimentacao(int seq, Conta cli, String operacao, double valor,Date data) {
		this.agencia = cli.getAgencia();
		this.cli = cli;
		this.conta = cli.getConta();
		this.nome = cli.getNome();
		this.operacao = operacao;
		this.seq = seq;
		this.valor = valor;
		this.data = data;
	}

	public Movimentacao(int seq, String nome, String operacao, double valor, int conta, int agencia, Date data) {
		this.seq = seq;
		this.nome = nome;
		this.operacao = operacao;
		this.valor = valor;
		this.conta = conta;
		this.agencia = agencia;
		this.data = data;
	}

	public Conta getCli() {
		return cli;
	}

	public void setCli(Conta cli) {
		this.cli = cli;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}

	public int getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(int agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void carrega()
	{
		MovimentacaoDAO dao = new MovimentacaoDAO();
		MovimentacaoTO to = dao.carregar(seq);
		setNome(to.getNome());
		setAgencia(to.getAgencia());
		setConta(to.getConta());
		setValor(to.getValor());
		setSeq(to.getSeq());
		setOperacao(to.getOperacao());
		
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (cli == null) {
			if (other.cli != null)
				return false;
		} else if (!cli.equals(other.cli))
			return false;
		if (conta != other.conta)
			return false;
		if (seq != other.seq)
			return false;
		if (valor != other.valor)
			return false;
		if (agenciaDestino != other.agenciaDestino)
			return false;
		if (contaDestino != other.contaDestino)
			return false;
		if (agencia != other.agencia)
			return false;
		if (operacao == null) {
			if (other.operacao != null)
				return false;
		} else if (!operacao.equals(other.operacao))
			return false;
		return true;
	}
	
}
