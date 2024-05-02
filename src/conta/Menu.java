package conta;

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
		int opcao;
		
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
			
			
			opcao = leia.nextInt();
			
			
			if(opcao ==9) {
				
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);//força o programa a fechar aqui
				
			}
			
			switch(opcao) {
			
			case 1 :
				System.out.println( Cores.TEXT_WHITE+ "Criar conta \n\n");
				break;
				
			case 2 : 
				System.out.println( Cores.TEXT_WHITE+"Listar todas as contas \n\n");
				break;
			case 3 :
				System.out.println(Cores.TEXT_WHITE+"Consultar dados da conta - por número \n\n");
				break;
				
			case 4 :
				System.out.println(Cores.TEXT_WHITE+"Atualizar dados da  conta\n\n");
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE+"Apagar a conta \n\n");
				break;
				
			case 6 : 
				System.out.println(Cores.TEXT_WHITE+"Saque\n\n");
				break;
				
			case 7 :
				System.out.println(Cores.TEXT_WHITE+"Deposito\n\n");
				break;
				
			case 8 :
				System.out.println(Cores.TEXT_WHITE+"Transferência entre contas\n\n");
				break;
				
			default: 
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção inválida!\n"+ Cores.TEXT_RESET); //caso o cliente não digite as opções acima
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

}
