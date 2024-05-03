package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import conta.util.Cores;


public class Menu {

	public static void main(String[] args) {
		// Criação do Menu da conta
		
		
		//testando Classe Conta
		
		//aqui eu criei um objeto c1 , que é instaciado tipo o Scanner , e ele é da Classe conta , que fará o vinculo , e vai chamar os metodos que eu criei 
		//no pacote conta.model dentro de Conta. 
		//passei os paramêtros dentro , e cada metodo fará sua função 
//		
//		Conta c1 = new Conta (1,123, 1, "Sara", 1000.0f);
//		
//		c1.visualizar();
//		c1.sacar(12000.0f); // vai ser inserido lá em valor .
//		c1.visualizar();
//		c1.depositar(5000.0f);
//		c1.visualizar();
		
//está comentado porque a classe conta agora é abstract e não pode ser instaciada		

		
		//Testando a Classe Conta Correnta
		
		//isso daqui se chama instaciar
		ContaCorrente cc1 = new ContaCorrente (2,123,1,"Mariana",15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(1200.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		//Testando a classe Conta Poupanca
		
		ContaPoupanca cp1 = new ContaPoupanca (3,123,2,"Victor",100000.0f, 15);
		
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		
		Scanner leia = new Scanner(System.in);
		
		
		int opcao = 0;
		
		while(true) {
			
			
			System.out.println(Cores.TEXT_YELLOW+ Cores.ANSI_BLACK_BACKGROUND +
					           "*********************************************");
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
			System.out.println("                                             "+ Cores.TEXT_RESET);
			
			//A estrutura Try...Catch foi implementada na entrada de dados via teclado da variável opcao (recebe o numero do item do menu) para capturar eventuais erros de digitação. 
			//No nosso Menu, caso seja digitado um valor diferente de um número inteiro, será exibida a mensagem: 
			//Digite valores inteiros!. Na sequência, a variável opcao será reiniciada (valor zero) e será solicitado a digitação de um novo numero.
			
			try {
			opcao = leia.nextInt();
			}catch (InputMismatchException e) { // erro : incompatibilidade de entrada
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}
			
			if(opcao ==9) {
				
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);//força o programa a fechar aqui
				
			}
			
			switch(opcao) {
			
			case 1 :
				System.out.println( Cores.TEXT_WHITE+ "Criar conta \n\n");
				
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			case 2 : 
				System.out.println( Cores.TEXT_WHITE+"Listar todas as contas \n\n");
				
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
			case 3 :
				System.out.println(Cores.TEXT_WHITE+"Consultar dados da conta - por número \n\n");
				
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			case 4 :
				System.out.println(Cores.TEXT_WHITE+"Atualizar dados da  conta\n\n");
				
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE+"Apagar a conta \n\n");
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			case 6 : 
				System.out.println(Cores.TEXT_WHITE+"Saque\n\n");
				
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			case 7 :
				System.out.println(Cores.TEXT_WHITE+"Deposito\n\n");
				
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			case 8 :
				System.out.println(Cores.TEXT_WHITE+"Transferência entre contas\n\n");
				keyPress(); //esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			default: 
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção inválida!\n"+ Cores.TEXT_RESET); //caso o cliente não digite as opções acima
				keyPress();//esse aqui vai fazer com que toda vez que der enter vai rodar novamente o menu
				break;
				
			}
		}
		
		
		
		
	
		
	}
	
	public static void sobre() {
		System.out.println("\n*******************************************************************************************");
		System.out.println("Projeto desenvolvido por : ");
		System.out.println("Sara Vasconcelos Freitas Souza  - vasconcelossara11@gmail.com");
		System.out.println("github.com/Sara-vasconcelos");
		System.out.println("A mente que se abre a uma nova ideia jamais voltará ao seu tamanho original - Albert Einstein");
		System.out.println("*********************************************************************************************");
	}
	
	//Nesta etapa, vamos implementar o Método keyPress() na Classe Menu. 
	//Este Método tem por Objetivo exigir que a tecla enter do seu teclado seja pressionada para finalizar uma opção do Menu. 
	//No estágio atual, quando você seleciona uma opção do Menu, ele mostra a mensagem e recarrega o Menu novamente. 
	//Com o Método keyPress(), o Menu será recarregado somente depois de pressionar a tecla enter.
	
	
	//Buffer de dados é uma região de memória física utilizada para armazenar temporariamente 
	//os dados enquanto eles estão sendo movidos de um lugar para outro. Ao pressionar a tecla , os dados são enviados para a JVM.
	
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();//indica a leitura de um dispositivo de entrada padrão (teclado),
			// os dados do buffer nativo são transferidos para a JVM e o primeiro byte digitado é retornado ao usuário e retirado do buffer. 
			
			//Porém se o buffer nativo estiver vazio, o método retorna -1. No caso do Método keyPress(), ao pressionar a tecla , automaticamente o Menu é reiniciado.

		} catch (IOException e) { // quando clica a tecla diferente de Enter 

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}

}
	
}
