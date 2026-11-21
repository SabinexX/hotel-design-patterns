package br.com.hotel.factory;

import br.com.hotel.model.Quarto;
import br.com.hotel.model.QuartoStandard;

/**
 * Criador concreto responsável por produzir
 * quartos da categoria Standard.
 *
 * Representa um ConcreteCreator no Factory Method.
 */
public class CriadorQuartoStandard extends CriadorQuarto {

    @Override
    public Quarto criarQuarto() {

        // Instancia o produto concreto Standard.
        return new QuartoStandard();
    }
}
