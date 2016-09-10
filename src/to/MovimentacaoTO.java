package to;

import java.sql.Date;
import java.util.ArrayList;

import dao.MovimentacaoDAO;
import view.Util;

public class MovimentacaoTO {

	private ContaTO cli;
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
	public ContaTO getCli() {
		return cli;
	}
	public void setCli(ContaTO cli) {
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

	public ArrayList<MovimentacaoTO> geraLista()
	{
		MovimentacaoDAO dao = new MovimentacaoDAO();
		ArrayList<MovimentacaoTO> lista = new ArrayList<MovimentacaoTO>();
		int i = 1;
		for (i = 1; i < 20 ; i++)
		{
			if(dao.carregar(i).conta == Util.getConta().getConta() )
			{
				lista.add(dao.carregar(i));
			}
		}
		
		
		return lista;
	}
}
