package br.com.vendexpress.catalog.exceptions;

public class BusinessException extends RuntimeException {
    
    public BusinessException(String mensagem) {
        super(mensagem);
    }
}
