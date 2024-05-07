package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// Criação do Menu da conta

		

		
		// Cria um Objeto da Classe ContaController,
		// para armazenar os dados das contas na Collection listaContas e executar os
		// Métodos do CRUD e os Métodos Bancários.
		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario,numeroDestino;
		String titular;
		float saldo, limite,valor;

		System.out.println("\nCriar Conta\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Maria dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {

			System.out.println(
					Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "*********************************************");
			System.out.println("                                             ");
			System.out.println("           BANCO DO BRAZIL COM Z             ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("       1 - Criar Conta                       ");
			System.out.println("       2 - Listar todas as Contas            ");
			System.out.println("       3 - Buscar conta por Número           ");
			System.out.println("       4 - Atualizar dados da Conta          ");
			System.out.println("       5 - Apagar Conta                      ");
			System.out.println("       6 - Sacar                             ");
			System.out.println("       7 - Depositar                         ");
			System.out.println("       8 - Transferir valores entre Contas   ");
			System.out.println("       9 - Sair                              ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("       Entre com a opção desejada :          ");
			System.out.println("                                             " + Cores.TEXT_RESET);

			// A estrutura Try...Catch foi implementada na entrada de dados via teclado da
			// variável opcao (recebe o numero do item do menu) para capturar eventuais erros de digitação.
			
			// No nosso Menu, caso seja digitado um valor diferente de um número inteiro, será exibida a mensagem:
			
			// Digite valores inteiros!. Na sequência, a variável opcao será reiniciada
			// (valor zero) e será solicitado a digitação de um novo numero.

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) { // erro : incompatibilidade de entrada
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {

				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);// força o programa a fechar aqui

			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar conta \n\n");
				System.out.println("Digite o número da agência");
				agencia = leia.nextInt();

				System.out.println("Digite o nome do titular");
				leia.skip("\\R");// aqui ele está ignorando esse caracter , que no caso é quebras de linhas .
									// Skip significa saltitar , ou seja , pular . Ele ignora a expressão que esse
									// caracter representa
				titular = leia.nextLine();

				// Garantir que a variável tipo receba via teclado somente os números 1 - *Conta
				// Corrente ou 2 - Conta Poupança.
				do {
					System.out.println("Digite o tipo da Conta -  1 : Para Conta Corrente ou 2 : Para Conta Poupança");
					tipo = leia.nextInt();

				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da Conta  (R$): ");
				saldo = leia.nextFloat();

				// Switch Expression , nesse abaixo eu consigo criar os cases todos dentro de
				// chaves , utilizando o -> deixando o código mais limpo, não preciso usar break
				// nesse caso
				switch (tipo) {

				// Caso a conta seja do tipo Conta Corrente (tipo 1), solicita a entrada de
				// dados via teclado para a variável limite e executa o Método cadastrar da
				// Classe ContaController.
				case 1 -> {
					System.out.println("Digite o limite de crédito  (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));

				}

				// Caso a conta seja do tipo Conta Poupança (tipo 2), solicita a entrada de
				// dados via teclado para a variável aniversario e executa o Método cadastrar da
				// Classe ContaController.
				case 2 -> {
					System.out.println("Digite o dia de aniversario da Conta :  ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();// esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as contas \n\n");
				contas.listarTodas();// Executa o Método listarTodas(), da Classe ContaController, para listar os
										// dados de todas as contas armazenadas na Collection listaContas.

				keyPress();// esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;

			case 3:

				// Executa o Método procurarPorNumero(int numero), da Classe ContaController,
				// passando como parâmetro a variável numero, que contém o numero da conta
				// (recebido via teclado), que deverá ser procurada na Collection listaContas.
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da conta - por número \n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();// esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;

			case 4:
				System.out.println("Atualizar dados da  conta\n\n");

				System.out.println("Digite o número da conta : ");
				numero = leia.nextInt();

				var buscaConta = contas.buscarNaCollection(numero); //localizará a Conta a partir do numero.

				if (buscaConta != null) {//verifica se a conta foi encontrada 

					tipo = buscaConta.getTipo();//retornará qual é o tipo da conta: 1 - Conta Corrente ou 2 - Conta Poupança. Esta informação, será armazenada na variável auxiliar tipo.

					System.out.println("Digite o número da agência : ");
					agencia = leia.nextInt();

					System.out.println("Digite o nome do titular : ");
					leia.skip("\\R");//ignora quebra de linha 
					titular = leia.nextLine();

					System.out.println("Digite o saldo da Conta R$ : ");
					saldo = leia.nextFloat();

					switch (tipo) {//verifica o tipo de conta 

					case 1 -> {//Se for Corrente irá solicitar o limite

						System.out.println("Digite o limite da Conta R$ : ");
						limite = leia.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));//metodo composto por variaveis que recebem valores via teclado
					}

					case 2 -> {//Se for Poupança irá solicitar o aniversário da conta

						System.out.println("Digite o aniversário  da Conta : ");
						aniversario = leia.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));//metodo composto por variaveis que recebem valores via teclado
					}
					default -> {

						System.out.println("Tipo de conta inválido!");//Caso o usuário digite algo diferente de 1 ou 2 
					}

					}

				} else {
					System.out.println("A conta não foi encontrada!");
				}

				keyPress();
				break;
				

			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a conta \n\n");
				
				System.out.println( "Digite o número da conta");
				numero =leia.nextInt();// receberá o numero da conta
				
				contas.deletar(numero);//Executa o Método deletar(int numero), da Classe ContaController, passando o numero como parâmetro
				
				keyPress();// esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				
				System.out.println( "Digite o número da conta");
				numero =leia.nextInt();// receberá o numero da conta
				
				do {
					System.out.println( "Digite o valor do saque R$");
					valor=leia.nextInt();
					
				}while(valor <= 0 );//garantir que a variável valor receba via teclado um numero positivo e maior do que zero.
				
				contas.sacar(numero, valor);//numero: Numero da Conta onde o saque será efetuado;//valor: Valor que será debitado da conta.

				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				
				System.out.println( "Digite o número da conta");
				numero =leia.nextInt();// receberá o numero da conta
				
				do {
					System.out.println( "Digite o valor do depósito R$");
					valor=leia.nextInt();
					
				}while(valor <= 0 );//garantir que a variável valor receba via teclado um numero positivo e maior do que zero.
				
				contas.depositar(numero, valor);//chamando o metodo da contaController
				

				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre contas\n\n");
				System.out.println( "Digite o número da Conta de Origem");
				numero =leia.nextInt();// receberá o numero da conta
				
				
				System.out.println( "Digite o número da Conta de Destino");
				numeroDestino =leia.nextInt();
				

				do {
					System.out.println( "Digite o valor da transferência R$");
					valor=leia.nextInt();
					
				}while(valor <= 0 );//garantir que a variável valor receba via teclado um numero positivo e maior do que zero.
				
				contas.transferir(numero, numeroDestino, valor); //chamando o metodo da contaController
				
				
				keyPress(); // esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!\n" + Cores.TEXT_RESET); // caso o cliente digite nenhuma das opções
																									
				keyPress();// esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;

			}
		}

	}

	public static void sobre() {
		System.out.println(
				"\n*******************************************************************************************");
		System.out.println("Projeto desenvolvido por : ");
		System.out.println("Sara Vasconcelos Freitas Souza  - vasconcelossara11@gmail.com");
		System.out.println("github.com/Sara-vasconcelos");
		System.out.println(
				"A mente que se abre a uma nova ideia jamais voltará ao seu tamanho original - Albert Einstein");
		System.out.println(
				"*********************************************************************************************");
	}

	// Nesta etapa, vamos implementar o Método keyPress() na Classe Menu.
	// Este Método tem por Objetivo exigir que a tecla enter do seu teclado seja
	// pressionada para finalizar uma opção do Menu.
	// No estágio atual, quando você seleciona uma opção do Menu, ele mostra a
	// mensagem e recarrega o Menu novamente.
	// Com o Método keyPress(), o Menu será recarregado somente depois de pressionar
	// a tecla enter.

	// o buffer é como um preprocessador dos dados que estão sendo recebidos via
	// teclado
	// imagina que temos a maquina virtual do java e nela tem a memória do
	// processamento da sua aplicação,
	// mas antes de chegar la esse dados digitado precisa ter uma "mão" que vai
	// carregar esse dado até a JVM, essa "mão" seria o buffer

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();// indica a leitura de um dispositivo de entrada padrão (teclado),
			// os dados do buffer nativo são transferidos para a JVM e o primeiro byte
			// digitado é retornado ao usuário e retirado do buffer.

			// Porém se o buffer nativo estiver vazio, o método retorna -1. No caso do
			// Método keyPress(), ao pressionar a tecla , automaticamente o Menu é
			// reiniciado.

		} catch (IOException e) { // IOException entrada e saida do teclado , e verifica se a tecla está correta

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}

	}

}
