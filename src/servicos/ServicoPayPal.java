package servicos;

public class ServicoPayPal implements ServicoPagamentoOnline{


	public Double taxaPagamento(Double quantia) {
		return quantia * 0.02;
	}


	public Double juros(Double quantia, int meses) {
		return quantia * 0.01 * meses;
	}
	
}
