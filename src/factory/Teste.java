package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Teste {

	private static DateFormat formatter;
	private static Cliente cl;
	private static Pedido pd;
	public static DateFormat getFormatter() {
		return formatter;
	}

	public static void setFormatter(DateFormat formatter) {
		Teste.formatter = formatter;
	}

	public static Cliente getCl() {
		return cl;
	}

	public static void setCl(Cliente cl) {
		Teste.cl = cl;
	}

	public static Pedido getPd() {
		return pd;
	}

	public static void setPd(Pedido pd) {
		Teste.pd = pd;
	}

	public static ConnectionFactory getBd() {
		return bd;
	}

	public static void setBd(ConnectionFactory bd) {
		Teste.bd = bd;
	}

	private static ConnectionFactory bd;

	/**
	 * Programa principal
	 */

	public static void main(String[] args) {
		Connection conn = null;
		formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			bd = new ConnectionFactory();
			conn = ConnectionFactory.obtemConexao();
			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);

			String sqlInsert = "INSERT INTO conta(conta, cliente, banco, status,saldo,codAcesso,agencia ) VALUES (?, ?, ?, ?, ?, ? , ?)";

			PreparedStatement stm = null;
			
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, 22222);
			stm.setString(2, "Teste");
			stm.setInt(3, 1);
			stm.setString(4, "S");
			stm.setDouble(5, 40);
			stm.setString(6, "2222");
			stm.setInt(7, 222222);
			stm.execute();

			// *** IMPORTANTE ***: Efetiva exclusão
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
}
