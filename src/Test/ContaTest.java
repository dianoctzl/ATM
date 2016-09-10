package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dao.ContaDAO;
import model.Conta;

public class ContaTest {
     Conta ble;
	Conta bla;
	ContaDAO dao;
	@Before
	public void setUP() 
	{
		bla = new Conta(1,"Diano",840,1,"1");
		dao = new ContaDAO();
		ble = new Conta(1);
		ble.carrega();

	}
	
	@Test
	public void testCarregar(){
		
		assertEquals(bla, ble);
		
	}
	
	
	@Test
	public void testSaldo() throws SQLException
	{
		double a = ble.getSaldo();
		double b = dao.mostraSaldo(dao.carregar(1));
		assertEquals(b,a,2580);
	}
	
	@Test
	public void testSaque() throws SQLException
	{
		ble.saque(1000);
		assertEquals(ble.saldo(),2000,2000);
	}
}
