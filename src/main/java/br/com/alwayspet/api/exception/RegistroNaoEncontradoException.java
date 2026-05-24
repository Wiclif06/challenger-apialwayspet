package br.com.alwayspet.api.exception;
public class RegistroNaoEncontradoException extends RuntimeException {
    public RegistroNaoEncontradoException(String mensagem){ super(mensagem); }
}
