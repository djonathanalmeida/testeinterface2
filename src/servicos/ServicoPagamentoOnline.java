package servicos;

public interface ServicoPagamentoOnline {
	
	Double taxaPagamento(Double quantia);
	Double juros(Double quantia, int meses);

}
