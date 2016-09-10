package util;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;

import dao.ContaDAO;
import dao.MovimentacaoDAO;
import to.ContaTO;
import to.MovimentacaoTO;
import view.Util;

public class JSONWrite {


	public static JSONObject geraTO(int conta)
	{
		ContaDAO dao = new ContaDAO();
		ContaTO to = dao.carregar(conta) ;
		JSONObject obj = new JSONObject();

		obj.put("nome" , to.getCli());
		obj.put("saldo" , to.getSaldo());
		obj.put("conta" , to.getConta());
		obj.put("agencia" , to.getAgencia());
		obj.put("senha" ,to.getSenha());


		return obj;
	}

	public static JSONObject geraExtrato() throws SQLException
	{
		
		MovimentacaoDAO dao = new MovimentacaoDAO();

		int seq = dao.mostraQuantidade(Util.getConta().getConta());
		
		JSONObject obj = new JSONObject();

		for(int i = 1; i <= seq ; i++)
		{	

			MovimentacaoTO to = dao.carregar(i);					

			obj.put("nome" , to.getNome());
			obj.put("conta" , to.getConta());
			obj.put("valor" , to.getValor());
			obj.put("operacao" , to.getOperacao());
			obj.put("agencia" ,to.getAgencia());
			obj.put("data" ,to.getData());
			obj.put("contaDest" ,to.getContaDestino());
			obj.put("agenciaDest" ,to.getAgenciaDestino());
		}

		return obj;
	}

	public static void gravaJSON(JSONObject rec,String arquivo)
	{
		try{
			FileWriter writeFile = null;

			writeFile = new FileWriter(arquivo+".json");
			//Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(rec.toJSONString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void gravaJSON(JSONArray texto,String arquivo)
	{
		try{
			FileWriter writeFile = null;

			writeFile = new FileWriter(arquivo+".json");
			//Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(texto.toString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static String listExtract(ArrayList<MovimentacaoTO> lista) throws JSONException {
		MovimentacaoTO to2 = new MovimentacaoTO();
		JSONArray vetor = new JSONArray();
		lista = to2.geraLista();
		for (MovimentacaoTO to : lista) {
			JSONObject obj = new JSONObject();
			obj.put("nome" , to.getNome());
			obj.put("conta" , to.getConta());
			obj.put("valor" , to.getValor());
			obj.put("operacao" , to.getOperacao());
			obj.put("agencia" ,to.getAgencia());
			obj.put("data" ,to.getData());
			obj.put("contaDest" ,to.getContaDestino());
			obj.put("agenciaDest" ,to.getAgenciaDestino());
			vetor.put(obj);
		}
		gravaJSON(vetor,"extract");

		JOptionPane.showMessageDialog(null,"JSON Gerado Com Sucesso!!!");

		return vetor.toString();
	}
	/*
	public static void main(String[] args) throws JSONException {

		//Cria um Objeto JSON

		gravaJSON(geraTO(101010),"rec");

		//Imprimne na Tela o Objeto JSON para vizualização
		System.out.println(geraTO(101010));
		MovimentacaoTO to2 = new MovimentacaoTO();

		System.out.println(listExtract(to2.geraLista()));
	} */
}