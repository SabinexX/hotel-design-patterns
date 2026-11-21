package br.com.hotel.factory;

import br.com.hotel.model.Quarto;
import br.com.hotel.model.QuartoLuxo;

/**
 * Criador concreto responsável por produzir
 * quartos da categoria Luxo.
 *
 * Representa um ConcreteCreator no Factory Method.
 */
public class CriadorQuartoLuxo extends CriadorQuarto {

    @Override
    public Quarto criarQuarto() {

        // Instancia o produto concreto Luxo.
        return new QuartoLuxo();
    }
}
