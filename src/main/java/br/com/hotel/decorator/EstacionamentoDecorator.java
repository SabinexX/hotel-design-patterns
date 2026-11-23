package br.com.hotel.decorator;

/**
 * Decorator concreto responsável por adicionar
 * estacionamento à hospedagem.
 *
 * Cada diária de estacionamento custa R$ 20,00.
 */
public class EstacionamentoDecorator extends HospedagemDecorator {

    private static final double VALOR_POR_DIARIA = 20.00;

    private final long quantidadeDiarias;

    public EstacionamentoDecorator(
            Hospedagem hospedagem,
            long quantidadeDiarias
    ) {
        super(hospedagem);

        if (quantidadeDiarias <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade de diárias deve ser positiva."
            );
        }

        this.quantidadeDiarias = quantidadeDiarias;
    }

    /**
     * Soma o estacionamento ao custo da hospedagem.
     */
    @Override
    public double calcularCusto() {
        return super.calcularCusto()
                + (VALOR_POR_DIARIA * quantidadeDiarias);
    }

    /**
     * Adiciona estacionamento à descrição.
     */
    @Override
    public String getDescricao() {
        return super.getDescricao()
                + " + Estacionamento";
    }
}
