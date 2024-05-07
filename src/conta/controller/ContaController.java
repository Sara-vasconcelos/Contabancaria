package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Criamos uma Collection ArrayList, do tipo Conta (Classe Abstrata), chamada
	// listaContas.
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	// Criamos uma variável do tipo int chamada numero, armazenará o numero da
	// última conta que foi criada.
	int numero = 0;

	
	// variável do tipo int, chamada numero, que receberá o número da conta que se deseja localizar.
	//Se foi encontrado, exibe os dados na tela através do Método visualizar().
	//Caso contrário (Objeto null), exibe na tela a mensagem informando que a conta não foi encontrada.
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();

		else

			System.out.println("\n Conta número : " + numero + " não foi encontrada");

	}

	// o Método exibirá todos os Objetos da Classe Conta, armazenados na Collection
	// listaContas.
	// Linha 20: Através do Laço de Repetição for...each, percorremos toda a
	// Collection listaContas.

	// var: É uma palavra reservada do Java, que tem o objetivo de criar variáveis
	// locais,
	// sem a definição do tipo. O tipo da variável é definido por inferência, ou
	// seja,
	// a palavra reservada var define o tipo da variável através do valor de
	// inicialização da variável.

	// No código do Método listarTodas(), como o Laço de Repetição está percorrendo
	// a Collection listaContas,
	// que armazena Objetos da Classe Conta, a palavra reservada var entende por
	// inferência
	// , que a variável conta deve ser criada como um Objeto da Classe Conta.

	// o conta.visualizar exibe os dados do Objeto da Classe Conta armazenado na
	// variável conta,
	// através do Método visualizar(), que foi criado na Classe Model Conta e
	// Herdado pelas Classes ContaCorrente e ContaPoupanca.
	@Override
	public void listarTodas() {
		//
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {// foi inserido como parâmetro um Objeto da Classe Conta, chamado conta.Este
										// Objeto será adicionado na Collection listaContas.
		listaContas.add(conta);// Para inserir um novo Objeto da Classe Conta, utilizamos o Método add(), da
								// Collection ArrayList, passando como parâmetro o Objeto da Classe Conta,
								// chamado conta.
		System.out.println("\nA conta número : " + conta.getNumero() + " foi criada com sucesso");

	}

	
	//Se a conta foi encontrada, os dados do Objeto são atualizados na Collection listaContas através do Método set()
	//listaContas.indexOf(buscaConta): Método que identifica o índice (posição) do Objeto conta encontrado na Collection listaContas, ou seja, os dados atuais.
	//conta: O Objeto conta, que foi enviado como parâmetro do Método (dados obtidos via teclado), onde estão os novos dados da conta, que substituirão os dados atuais.
	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta !=null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nConta número : "+ conta.getNumero() + " foi atualizada com sucesso!");
		}else {
			System.out.println("\nConta número : "+ conta.getNumero() + " não foi encontrada!");
		}

	}

	@Override
	public void deletar(int numero) {// int número  receberá o número da conta que se deseja deletar.
	var conta = buscarNaCollection(numero);//verificar se o Objeto conta existe. E var conta receberá essa informação
	
	if(conta !=null) {//verifica se o Objeto Conta foi encontrado.
		if(listaContas.remove(conta) == true)//o Objeto conta será apagado na Collection listaContas através do Método remove(). Será checado se a exclusão foi bem sucedida
		
			System.out.println("\nA Conta número "+ numero + " foi deletada com sucesso!");
	}else 
		
		System.out.println("\nA Conta número "+ numero + " não foi  encontrada!");
	

	}

	@Override
	public void sacar(int numero, float valor) {//Número da conta que será efetuada a operação de Saque. //O valor que será debitado da conta.
		var conta = buscarNaCollection(numero);

		if(conta !=null) {////Antes de Efetuar o saque na conta, precisamos verificar se a conta existe.
			if(conta.sacar(valor) == true ) // checar se o saque foi bem sucedido 
				System.out.println("\nO saque da  Conta número "+ numero + " foi efetuado com sucesso!");
			
		}else 
			System.out.println("\nA Conta número "+ numero + " não foi encontrada !");
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta !=null) {//verificar se a conta existe.
			conta.depositar(valor);
			System.out.println("\nO depósito da  Conta número "+ numero + " foi efetuado com sucesso!");
			
		}else 
			System.out.println("\nA Conta número "+ numero + " não foi encontrada ou a Conta  destino não é uma Conta Corrente!");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino !=null) {//verificar se a conta existe
			if(contaOrigem.sacar(valor) == true) {//checar se o saque na conta origem foi bem sucedido 
				
				contaDestino.depositar(valor);//se sim, vai executar esse aqui , que é o depósito na conta destino
				System.out.println("\nA transferência foi feita com sucesso!");
				
			}
		}else {
			System.out.println("\nA conta de Origem e/ou Destino não foram encontradas !");
		}
		

	}

	// Método tem como único Objetivo retornar o número da conta todas as vezes que
	// uma nova conta for cadastrada.
	public int gerarNumero() {
		return ++numero;// a cada conta criada ele gera um número , somando +1 . Ele pegou a variavel
						// numero que valia zero , e a cada conta criada ele acrescenta 1 , então fica
						// assim: 1,2,3,4....
	}

	// variável do tipo int, chamada numero, que receberá o número da conta que se
	// deseja localizar.
	// Verifica se o Atributo numero (obtido através do Método getNumero()), do
	// Objeto da Classe Conta armazenado na variável conta é o mesmo que foi enviado
	// na variável numero.
	// Se os números forem iguais, o Método devolve o Objeto Conta encontrado e
	// finaliza o Laço de repetição.Senão retorna null
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}

}
