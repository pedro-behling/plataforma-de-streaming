package br.com.alura.pedroflix.exceptions;

public class YearConversionError extends RuntimeException {
    private String message;

    public YearConversionError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
