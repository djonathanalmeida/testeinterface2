package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Parcela;
import servicos.ServicoContrato;
import servicos.ServicoPayPal;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato: ");
		System.out.println("Número: ");
		Integer numero = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		System.out.println("Valor do contrato: ");
		Double valor = sc.nextDouble();

		Contrato obj = new Contrato(numero, data, valor);

		System.out.println("Entre com o número de parcelas: ");
		Integer n = sc.nextInt();

		ServicoContrato servico = new ServicoContrato(new ServicoPayPal());
		servico.processarContrato(obj, n);

		System.out.println("Parcelas: ");
		for (Parcela parcela : obj.getParcela()) {
			System.out.println(parcela);
		}

		sc.close();
	}

}
