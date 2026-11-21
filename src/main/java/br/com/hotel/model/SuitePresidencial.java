package br.com.hotel.model;

/**
 * Representa a categoria Suíte Presidencial.
 *
 * Possui o maior valor de diária do hotel.
 *
 * No padrão Factory Method, representa
 * um ConcreteProduct (Produto Concreto).
 */
public class SuitePresidencial extends Quarto {

    @Override
    public String getCategoria() {
        return "Suíte Presidencial";
    }

    @Override
    public double getValorDiaria() {
        return 600.00;
    }
}
