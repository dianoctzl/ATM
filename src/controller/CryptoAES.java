package controller;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoAES {
	private byte[] textoCifrado;
	private byte[] textoDecifrado;
	private static final byte[] chaves = "                ".getBytes();
	private static final SecretKeySpec key = new SecretKeySpec(chaves, "AES");

	public CryptoAES() {
		textoCifrado = null;
		textoDecifrado = null;
	}

	

	public void geraCifra(byte[] texto) throws Exception {
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		aescf.init(Cipher.ENCRYPT_MODE, key);
		textoCifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoCifrado() throws Exception {
		return textoCifrado;
	}

	public void geraDecifra(byte[] texto) throws Exception {
		
		Cipher cifra = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cifra.init(Cipher.DECRYPT_MODE, key);
		textoDecifrado = cifra.doFinal(texto);
	}

	public byte[] getTextoDecifrado() throws Exception {
		return textoDecifrado;
	}
}
