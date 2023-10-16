package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {

	private LocalDate dataVencimento;
	private Double quantia;
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Parcela() {

	}

	public Parcela(LocalDate dataVencimento, Double quantia) {
		this.dataVencimento = dataVencimento;
		this.quantia = quantia;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	@Override
	public String toString() {
		return fmt.format(dataVencimento) + " - " + String.format("%.2f", quantia);
	}
	
	

}
