package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável pela conexão com banco de dados MySQL
 */

public class ConnectionFactory {
	// -----------------------------------------------------------
	// Carrega driver JDBC
	//
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}



	// -----------------------------------------------------------
	// Obtém conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=alunos&password=alunos");
	}
}