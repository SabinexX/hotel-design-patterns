
package br.com.hotel.factory;

import br.com.hotel.model.Quarto;
import br.com.hotel.model.SuitePresidencial;

/**
 * Criador concreto responsável por produzir
 * suítes presidenciais.
 *
 * Representa um ConcreteCreator no Factory Method.
 */
public class CriadorSuitePresidencial extends CriadorQuarto {

    @Override
    public Quarto criarQuarto() {

        // Instancia o produto concreto SuitePresidencial.
        return new SuitePresidencial();
    }
}
