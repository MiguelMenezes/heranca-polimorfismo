package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> lista = new ArrayList<>();

		System.out.print("Informe o numero de pagadores: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("DADOS DO PAGADOR #" + i + " :");
			System.out.print("Pessoa Física ou Jurídica (F/J): ");
			char tipo = sc.next().charAt(0);
			sc.nextLine();

			if (tipo == 'F' || tipo == 'f') {

				System.out.print("Nome: ");
				String nome = sc.nextLine();

				System.out.print("Rendimento anual: R$");
				double rendaAnual = sc.nextDouble();

				System.out.print("Gastos com saúde: R$");
				double gastoSaude = sc.nextDouble();

				lista.add(new PessoaFisica(nome, rendaAnual, gastoSaude));

			} else if (tipo == 'J' || tipo == 'j') {

				System.out.print("Nome: ");
				String nome = sc.nextLine();

				System.out.print("Rendimento anual: R$");
				double rendaAnual = sc.nextDouble();

				System.out.print("Informe o número de funcionários: ");
				int numFuncionarios = sc.nextInt();

				lista.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));

			} else {
				System.out.println("OPÇÃO INVÁLIDA! SISTEMA DESLIGADO.");
				System.exit(0);
			}
		}
		
		System.out.println("----------------------------------------------------------------------------------");
		double soma = 0;
		System.out.println("IMPOSTOS PAGOS: ");
		for (Pessoa p : lista) {

			System.out.println(p.getNome() + ": R$" + String.format("%.2f", p.calcularImposto()));
			soma += p.calcularImposto();
		}
		System.out.println();
		System.out.print("TOTAL DE IMPOSTO PAGO: R$" + String.format("%.2f", soma));

		sc.close();
	}

}
