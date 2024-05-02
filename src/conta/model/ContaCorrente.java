package conta.model;

//Herança (extends) - quando uma classe herda as caracteristicas de outra Classe , que no caso é a Conta  que é a Classe mãe
public class ContaCorrente extends Conta  {

	
	private float limite; //Esse parametro é novo e foi acrescentado aqui nessa classe , então devo acrescentá-lo no metodo construtor abaixo
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);
	}

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo); //herança da classe Mãe
		this.limite = limite; // aqui indica que é um parametro que foi criado nesta classe
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	
	//métodos especificos da ContaCorrente
	
	
	
	//O Método sacar da Classe ContaCorrente é praticamente igual ao Método sacar da Classe Conta.
	//A única mudança será no laço condicional if, que verifica se o valor do saque é menor do que o saldo disponível na conta.
	//Numa Conta Corrente, para obter o saldo atual da conta, será necessário somar o saldo e o limite. 
	//Observe que foram utilizados os métodos getSaldo() e getLimite() para obter os valores de ambos os Atributos e posteriormente somar
	// A palavra  this foi utilizada para fazer referência ao Objeto que está executando os Métodos.
	
	
	
	//os métodos sacar e visualizar são os mesmos que estão na classe Conta , porém para que a classe ContaCorrenta tivesse acesso diretamente a eles :
	//Eles foram sobrescritos.
	
	@Override //indicando que o Método foi sobrescrito
	public boolean sacar (float valor) {
	
	if(getSaldo() + this.getLimite() < valor ) {
		System.out.println("\nSaldo Insuficiente!");
		return false;
	}
	this.setSaldo(this.getSaldo() - valor); // Atualizar o saldo , fazendo o saldo anterior menos o valor . 
	return true;
		
	}
	
	@Override
	public void visualizar() {
		super.visualizar(); //Vai rodar o visualizar da classe Conta , e vai acrescentar a linha debaixo LIMITE. Nesse caso , eu não preciso escrever tudo de novo
		System.out.println("\nLimite de crédito : " + this.limite);
	}

}
