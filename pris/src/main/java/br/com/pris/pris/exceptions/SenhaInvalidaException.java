package br.com.pris.pris.exceptions;

public class SenhaInvalidaException extends RuntimeException{
	
	public SenhaInvalidaException() {
        super("Email ou senha inválidos");
    }
}
