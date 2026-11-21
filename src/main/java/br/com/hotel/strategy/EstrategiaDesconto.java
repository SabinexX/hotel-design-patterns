package br.com.hotel.strategy;

/**
 * Interface que representa o padrão Strategy.
 *
 * Define um contrato comum para diferentes
 * estratégias de cálculo de descontos.
 *
 * Cada implementação decidirá como calcular
 * o valor final da hospedagem.
 */
public interface EstrategiaDesconto {

    /**
     * Calcula o valor final após aplicar o desconto.
     *
     * @param valorOriginal valor total sem desconto
     * @return valor final com o desconto aplicado
     */
    double calcularValorFinal(double valorOriginal);
}
