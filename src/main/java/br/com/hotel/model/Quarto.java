
package br.com.hotel.model;

/**
 * Representa um quarto do hotel.
 *
 * Armazena as informações básicas necessárias
 * para realizar uma reserva.
 */
public class Quarto {

    private final int numero;
    private final String categoria;
    private final double valorDiaria;

    /**
     * Cria um quarto com número, categoria
     * e valor de diária definidos.
     */
    public Quarto(int numero, String categoria, double valorDiaria) {
        if (numero <= 0) {
            throw new IllegalArgumentException(
                    "O número do quarto deve ser positivo."
            );
        }

        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException(
                    "A categoria do quarto é obrigatória."
            );
        }

        if (valorDiaria <= 0) {
            throw new IllegalArgumentException(
                    "O valor da diária deve ser positivo."
            );
        }

        this.numero = numero;
        this.categoria = categoria;
        this.valorDiaria = valorDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}
