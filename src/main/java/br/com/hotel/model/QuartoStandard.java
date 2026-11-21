package br.com.hotel.model;

/**
 * Representa um quarto da categoria Standard.
 *
 * Esta classe herda de Quarto e implementa
 * os métodos abstratos definidos na classe-base.
 *
 * No Factory Method, representa um ConcreteProduct
 * (Produto Concreto).
 */
public class QuartoStandard extends Quarto {

    @Override
    public String getCategoria() {
        return "Standard";
    }

    @Override
    public double getValorDiaria() {
        return 150.00;
    }
}
