package view;

import java.sql.Connection;
import java.util.Locale;
import java.util.ResourceBundle;

import dao.ContaDAO;
import model.Conta;
import to.ContaTO;

public class Util {

	private static ResourceBundle bundle;
	private static Conta cli;
	private static Connection conn;
	private static ContaTO c;
	private static ContaDAO dao;
	
	public static void setCli(Conta a)
	{
		cli = a;
	}
	
	public static Conta getCli()
	{
		return cli;
	}
	
	public static void setBundle(ResourceBundle b) {
		bundle = b;
		
	}
	
	public static ResourceBundle getBundle()
	{
		if (bundle == null)
		{
			bundle = ResourceBundle.getBundle("ling",new Locale("pt","BR"));
		}
		return bundle;
	}
	
	public static Connection getConn()
	{
		return conn;
	}
	
	public static void setConn(Connection conex)
	{
		conn = conex;
	}

	public static void setConta(ContaTO contaTO)
	{
		c = contaTO;
	}

	public static ContaTO getConta()
	{
		return c;
	}
	
	public static ContaDAO getContaDAO()
	{
		return dao;
	}
	
	public static void setContaDAO(ContaDAO dao2)
	{
		dao = dao2;
	}
	
	
}
