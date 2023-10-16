package servicos;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Parcela;

public class ServicoContrato {

	private ServicoPagamentoOnline servicoPagamentoOnline;

	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}

	public void processarContrato(Contrato contrato, Integer meses) {

		Double valorParcela = contrato.getTotalValor() / meses;

		for (Integer i = 1; i <= meses; i++) {

			LocalDate dataVencimento = contrato.getData().plusMonths(i);
			Double juros = servicoPagamentoOnline.juros(valorParcela, i);
			Double taxa = servicoPagamentoOnline.taxaPagamento(juros);
			
			Double totalParcela = contrato.getTotalValor() + juros + taxa;
			
			contrato.getParcela().add(new Parcela(dataVencimento, totalParcela));
		}

	}

}
