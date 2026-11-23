package br.com.hotel.decorator;

import br.com.hotel.model.Reserva;

/**
 * Representa a hospedagem básica, sem serviços adicionais.
 *
 * No padrão Decorator, esta classe é o ConcreteComponent.
 *
 * O custo inicial é calculado utilizando a reserva
 * construída anteriormente pelo padrão Builder.
 */
public class HospedagemBasica implements Hospedagem {

    private final Reserva reserva;

    public HospedagemBasica(Reserva reserva) {

        if (reserva == null) {
            throw new IllegalArgumentException(
                    "A reserva não pode ser nula."
            );
        }

        this.reserva = reserva;
    }

    @Override
    public double calcularCusto() {

        // Multiplica a quantidade de diárias pelo valor do quarto.
        return reserva.getQuantidadeDiarias()
                * reserva.getQuarto().getValorDiaria();
    }

    @Override
    public String getDescricao() {

        return "Hospedagem no quarto "
                + reserva.getQuarto().getCategoria()
                + " - "
                + reserva.getQuantidadeDiarias()
                + " diária(s)";
    }
}
