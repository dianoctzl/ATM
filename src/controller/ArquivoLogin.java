package controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.Conta;

public class ArquivoLogin {

	private Conta conta;
	private Scanner leitor = null;
	private ArrayList<Conta> listaDeUsuarios;
	
	private static String i18n = "ISO-8859-1";
	private static CryptoAES caes = new CryptoAES();

	public Conta verificaUsuario(Conta usuarioTentandoLogar) {
		
		String texto = desfasCriptografia();
		System.out.println(texto);
		
		try {
			leitor = new Scanner(texto);

			listaDeUsuarios = new ArrayList<Conta>();

			while (leitor.hasNext()) {
				Conta c =  new Conta(Integer.parseInt(leitor.next()));
				
				
				c.setAgencia(Integer.parseInt(leitor.next()));
				c.setSenha(leitor.next());

				listaDeUsuarios.add(c);
			}

		} catch (NumberFormatException en) {}
		
		int inicio = 0;
		int fim = listaDeUsuarios.size() - 1;

		while (inicio <= fim) {
			int meio = (inicio + fim) / 2;
			System.out.println(meio);
			conta = listaDeUsuarios.get(meio);

			if (conta.getAgencia() == usuarioTentandoLogar.getAgencia() 
					&& conta.getConta() == usuarioTentandoLogar.getConta() 
					&& conta.getSenha() == usuarioTentandoLogar.getSenha()) {
			
				leitor.close();
				return conta;
				
			} else {
				if(usuarioTentandoLogar.getAgencia() > conta.getAgencia()){
					inicio = meio + 1;
				} else {
					fim = meio - 1;
				}
			}
		}

		return null;
	}
	
	public static byte[] leTudo() {
		try {
			System.out.println(Files.readAllBytes(Paths.get("ACESSO.txt")));
			return Files.readAllBytes(Paths.get("ACESSO.txt"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static String fazCriptografia(){
		try {
			byte[] bytesMsgClara = leTudo();
			caes.geraCifra(bytesMsgClara);
			
			byte[] bytesMsgCifrada = caes.getTextoCifrado();
			
			return new String(bytesMsgCifrada, i18n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		
		String string =   desfasCriptografia();
	//	String string =  fazCriptografia(); 
		escreveNoAcesso(string);
		System.out.println(string);
		
	}
	
	public static void escreveNoAcesso(String texto) {
		try {
			FileWriter handler = new FileWriter(new File("ACESSO.txt"));
			handler.write(texto);
			handler.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String desfasCriptografia(){
		byte[] msgCifrada = leTudo();
		try {
			caes.geraDecifra(msgCifrada);
			byte[] decifrado = caes.getTextoDecifrado();
			return new String(decifrado, i18n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}