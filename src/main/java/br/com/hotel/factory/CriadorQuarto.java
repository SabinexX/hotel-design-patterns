package br.com.hotel.factory;

import br.com.hotel.model.Quarto;

/**
 * Classe abstrata responsável por definir o Factory Method.
 *
 * No padrão Factory Method, esta classe representa
 * o Creator (Criador).
 *
 * As subclasses decidem qual tipo concreto de
 * quarto será instanciado.
 */
public abstract class CriadorQuarto {

    /**
     * Factory Method.
     *
     * Define o contrato para criação de quartos.
     * Cada subclasse deverá implementar este método.
     *
     * @return um objeto do tipo Quarto
     */
    public abstract Quarto criarQuarto();

    /**
     * Utiliza o Factory Method sem precisar conhecer
     * a classe concreta do quarto.
     */
    public void apresentarQuarto() {

        // A criação é delegada à subclasse concreta.
        Quarto quarto = criarQuarto();

        // Comportamento comum a todos os tipos de quarto.
        quarto.exibirInformacoes();
    }
}
