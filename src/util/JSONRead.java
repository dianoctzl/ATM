package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import to.ContaTO;

public class JSONRead {



	public static ContaTO lerJSON(String arquivo)
	{
		JSONObject jsonObject;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		ContaTO to = null;
		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(arquivo+".json"));

			String cli = (String) jsonObject.get("nome");
			String senha = (String) jsonObject.get("senha");
			long conta = (long) jsonObject.get("conta");
			long agencia = (long) jsonObject.get("agencia");
			double saldo = (double) jsonObject.get("saldo");

			to = new ContaTO(cli,saldo,(int)conta,(int)agencia,senha);

			//Salva nas variaveis os dados retirados do arquivo


			System.out.printf(
					"Nome: %s\nconta: %s\nagencia: %s\nsaldo: %s\nsenha: %s\n ",
					cli, conta, agencia, saldo,senha);

			System.out.println("Agencia:"+to.getAgencia()+"\nConta:"+to.getConta()+
					"\nNome:"+to.getCli()+"\nSaldo"+to.getSaldo()+"\nSenha:"+to.getSenha());
		} 
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to;
	}
	/*
	public static void main(String[] args) {

		JSONObject jsonObject;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		//Variaveis que irao armazenar os dados do arquivo JSON
		String cli;
		double saldo;
		long conta;
		long agencia;
		 String senha;

		 JSONRead js = new JSONRead();

		 js.lerJSON("rec");
		}*/

}
