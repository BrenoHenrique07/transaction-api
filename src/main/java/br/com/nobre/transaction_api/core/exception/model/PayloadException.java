package br.com.nobre.transaction_api.core.exception.model;

public class PayloadException extends RuntimeException {

    private final int statusCode = 422;

    public PayloadException(String message) {
        super(message);
    }

    public int getStatusCode() {
        return statusCode;
    }

}
