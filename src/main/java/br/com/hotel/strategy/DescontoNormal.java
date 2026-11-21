package br.com.hotel.strategy;

/**
 * Estratégia de desconto normal.
 *
 * Não aplica desconto ao valor original.
 *
 * Representa uma ConcreteStrategy.
 */
public class DescontoNormal implements EstrategiaDesconto {

    @Override
    public double calcularValorFinal(double valorOriginal) {

        // Retorna o valor sem desconto.
        return valorOriginal;
    }
}
