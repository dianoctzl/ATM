package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import factory.ConnectionFactory;
import to.ContaTO;
import to.MovimentacaoTO;

public class MovimentacaoDAO {

	ResultSet rs;
	
public int mostraQuantidade(int conta) throws SQLException {
		
		String sqlSelect = "SELECT count(c.id) FROM movimentacao c WHERE c.conta = ?";
		System.out.println(conta);
		PreparedStatement stm = null;
		ResultSet rs = null;

		int a = 1;
		try {new ConnectionFactory();
	         Connection	conn = ConnectionFactory.obtemConexao();
			stm = conn.prepareStatement(sqlSelect);
			stm.setLong(1, conta);
			rs = stm.executeQuery();
			
			System.out.println(rs.next());
			a = rs.getInt(1);
			
		}

		catch (Exception e) {
			e.printStackTrace();
			try {Connection	conn = ConnectionFactory.obtemConexao();
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return a;
	}
	
	public void insereMovimento(MovimentacaoTO to) throws SQLException
	{
		String sqlInsert = "INSERT INTO `mydb`.`movimentacao` (`cliente`,`valor`, `operacao`, `agencia`, `conta`,`data`) VALUES (?,?,?,?,?,?);";
		
		Date data = new Date(System.currentTimeMillis());
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setDouble(2, to.getValor());
			stm.setString(3, to.getOperacao());
			stm.setInt(4, to.getAgencia());
			stm.setInt(5, to.getConta());
			stm.setDate(6,data);
			stm.execute();}
			 catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insereMovimento(MovimentacaoTO to,int contaDestino, int agenciaDestino) throws SQLException
	{
		String sqlInsert = "INSERT INTO `mydb`.`movimentacao` (`cliente`,`valor`, `operacao`, `agencia`, `conta`,`contaDest`,`agenciaDest`,`data`) VALUES (?,?,?,?,?,?,?,?);";
		// usando o try with resources do Java 7, que fecha o que abriu
		Date data = new Date(System.currentTimeMillis());
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setDouble(2, to.getValor());
			stm.setString(3, to.getOperacao());
			stm.setInt(4, to.getAgencia());
			stm.setInt(5, to.getConta());
			stm.setInt(6, contaDestino);
			stm.setInt(7, agenciaDestino);
			stm.setDate(8, data);
			stm.execute();}
			 catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MovimentacaoTO carregar(int seq)
	{
		MovimentacaoTO to = new MovimentacaoTO();
		String sqlSelect = "SELECT cliente,conta,valor,operacao,agencia,data,contaDest,agenciaDest FROM movimentacao WHERE movimentacao.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, seq);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString(1));
					to.setConta(rs.getInt(2));
					to.setValor(rs.getDouble(3));
					to.setOperacao(rs.getString(4));
					to.setAgencia(rs.getInt(5));
					to.setData(rs.getDate(6));
					to.setContaDestino(rs.getInt(7));
					to.setAgenciaDestino(rs.getInt(8));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
}
