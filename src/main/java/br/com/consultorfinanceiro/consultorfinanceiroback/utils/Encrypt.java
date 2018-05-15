package br.com.consultorfinanceiro.consultorfinanceiroback.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt 
{
	public static String toHash( 
		final String value )
	{
		try 
		{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(value.getBytes(), 0, value.length());
			return new BigInteger(1,md5.digest()).toString(16); 
		} 
		catch( NoSuchAlgorithmException e )
		{
			throw new RuntimeException( "Erro ao Criar Senha Criptografada.", e );
		}
	}
}