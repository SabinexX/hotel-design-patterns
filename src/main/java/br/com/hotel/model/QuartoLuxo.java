package br.com.hotel.model;

/**
 * Representa um quarto da categoria Luxo.
 *
 * Herda da classe abstrata Quarto e implementa
 * os métodos específicos desta categoria.
 *
 * No Factory Method, representa um ConcreteProduct.
 */
public class QuartoLuxo extends Quarto {

    @Override
    public String getCategoria() {
        return "Luxo";
    }

    @Override
    public double getValorDiaria() {
        return 300.00;
    }
}
