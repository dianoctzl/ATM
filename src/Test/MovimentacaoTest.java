package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Movimentacao;

public class MovimentacaoTest {

	Movimentacao m1;
	Movimentacao m2;
	@Before
	public void setUP()
	{
		m1 = new Movimentacao(2);
		m1.carrega();
		
		m2 = new Movimentacao(2, "Diano", "saque", 5, 1, 1,m1.getData());
	}
	
	@Test
	public void test() {
		System.out.println(m1.getAgencia()+m1.getAgenciaDestino()+m1.getConta()+m1.getContaDestino()+m1.getNome()
		+m1.getOperacao()+m1.getSeq()+m1.getValor()+m1.getData());
		System.out.println(m2.getAgencia()+m2.getAgenciaDestino()+m2.getConta()+m2.getContaDestino()+m2.getNome()
		+m2.getOperacao()+m2.getSeq()+m2.getValor()+m2.getData());
		assertEquals(m1,m2);
	}

}
