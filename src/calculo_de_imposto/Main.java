package calculo_de_imposto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Contribuinte;
import entities.Empresa;
import entities.Individual;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Contribuinte> list = new ArrayList<>();
		System.out.println("Insira o número de contribuintes:");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Dados do contribuinte nº " + i + ":");
			System.out.println("Indivíduo ou empresa (i/c)");
			char tipo = sc.next().charAt(0);
			if(tipo == 'i') {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Renda anual: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Despesas de saúde: ");
				Double gastoComSaude = sc.nextDouble();
			
				list.add(new Individual(nome, rendaAnual, gastoComSaude));

			}if(tipo == 'c') {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Renda anual: ");
				Double rendaAnual = sc.nextDouble();
				System.out.print("Numero de funcionarios: ");
				int numeroDeFuncionarios = sc.nextInt();
				list.add(new Empresa(nome,rendaAnual, numeroDeFuncionarios));
				
			}


		}
		double soma = 0.0;
		System.out.println();
		System.out.println("IMPOSTOS PAGOS: ");
		for(Contribuinte cont : list) {
			double tax = cont.imposto();
			System.out.println(cont.getNome() + ": $ " + String.format("%.2f", tax));
			soma += tax; 

		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", soma));;

		sc.close();

		

	}

}
