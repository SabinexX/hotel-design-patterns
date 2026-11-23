package br.com.hotel.decorator;

/**
 * Classe abstrata que representa o Decorator.
 *
 * Implementa a mesma interface da hospedagem
 * e mantém uma referência para outra Hospedagem.
 *
 * Permite adicionar novos comportamentos sem
 * modificar a classe HospedagemBasica.
 */
public abstract class HospedagemDecorator implements Hospedagem {

    // Hospedagem que será envolvida pelo Decorator.
    protected final Hospedagem hospedagem;

    /**
     * Recebe a hospedagem que será decorada.
     */
    public HospedagemDecorator(Hospedagem hospedagem) {

        if (hospedagem == null) {
            throw new IllegalArgumentException(
                    "A hospedagem não pode ser nula."
            );
        }

        this.hospedagem = hospedagem;
    }

    /**
     * Por padrão, delega o cálculo à hospedagem envolvida.
     * As subclasses acrescentarão seus próprios custos.
     */
    @Override
    public double calcularCusto() {
        return hospedagem.calcularCusto();
    }

    /**
     * Por padrão, utiliza a descrição da hospedagem envolvida.
     * As subclasses acrescentarão seus serviços.
     */
    @Override
    public String getDescricao() {
        return hospedagem.getDescricao();
    }
}
