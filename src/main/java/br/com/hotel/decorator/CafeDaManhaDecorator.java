package br.com.hotel.decorator;

/**
 * Decorator responsável por adicionar
 * o serviço de café da manhã à hospedagem.
 *
 * Representa um ConcreteDecorator.
 */
public class CafeDaManhaDecorator extends HospedagemDecorator {

    // Valor do café da manhã por diária.
    private static final double VALOR_POR_DIARIA = 30.00;

    private final long quantidadeDiarias;

    /**
     * Recebe a hospedagem original e o número de diárias.
     */
    public CafeDaManhaDecorator(
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
     * Acrescenta o valor do café da manhã
     * ao custo da hospedagem envolvida.
     */
    @Override
    public double calcularCusto() {
        return super.calcularCusto()
                + (VALOR_POR_DIARIA * quantidadeDiarias);
    }

    /**
     * Acrescenta o serviço à descrição.
     */
    @Override
    public String getDescricao() {
        return super.getDescricao()
                + " + Café da manhã";
    }
}
