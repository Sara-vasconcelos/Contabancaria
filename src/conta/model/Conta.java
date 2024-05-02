package conta.model;

public  abstract class Conta {

	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public int getAgencia() {
		return agencia;
	}



	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public String getTitular() {
		return titular;
	}



	public void setTitular(String titular) {
		this.titular = titular;
	}



	public float getSaldo() {
		return saldo;
	}



	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
     //metodo criado para Sacar:
	//O Método sacar, do tipo boolean, foi criado contendo o parâmetro float valor, 
	//que receberá o valor a ser sacado da conta. O parâmetro valor é do tipo float porquê o Atributo saldo é do tipo float.
	
	//Através do laço condicional if, verifica se o valor do saque é menor do que o saldo disponível na conta.
	//Para obter o saldo atual da conta, foi utilizado o método getSaldo().
	//A palavra reservada this foi utilizada para fazer referência ao Objeto que está executando o Método getSaldo().
	
	//Caso o saldo seja insuficiente, será exibida a mensagem de Saldo Insuficiente no console.
	
	//Como se trata de um Método do tipo boolean, é necessário retornar uma resposta true ou false. 
	//Como o saque nesta condição não pode ser efetuada, retornaremos false. 
	//O comando return tem a função de retornar um valor após o Método finalizar o processamento
	
	// Caso a condição anterior seja falsa (o saldo é suficiente), o saque será efetuado. 
	//Para atualizar o saldo, foi utilizado o método setSaldo(float saldo).
	//Como parâmetro do Método, foi enviada a operação saldo - valor, onde o saldo atual da conta foi obtido através do método getSaldo(). 
	//A palavra reservada this foi utilizada para fazer referência ao Objeto que está executando o Método getSaldo().
	//O Método setSaldo(float saldo) irá atualizar o Atributo saldo do Objeto com o resultado da subtração (saldo - valor).

// Como o saque foi efetuado, retornaremos true.
	
	public boolean sacar(float valor) {
		if(this.getSaldo()< valor) {
			System.out.println("\n Saldo insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	//essse metodo tipo void foi criado porque não vai precisar retornar uma confirmação
	//ou seja , não será verificado o valor da conta antes de depositar , só vai direto
	//setSaldo , está atualizando o valor
	//getSaldo mostrará o valor atualizado , e o VALOR , que será depositado
	
	
	//foi criado com void , porque esse metodo só precisa visualizar 
	
	//Foi criada a variável String, chamada tipo, para receber textualmente o tipo da Conta
	
	//Através do laço condicional case, vamos checar se o tipo da conta é 1 ou 2.
	//Caso seja 1, exibe Conta Corrente, caso seja 2 exibe Conta Poupança. 
	//Como parâmetro do comando switch, foi passado o Atributo tipo.
	//A palavra reservada this foi utilizada para fazer referência ao Atributo tipo.
	
	
	public void depositar(float valor ) {
		this.setSaldo(this.getSaldo()+valor);
	}
	
	
	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo){
		case 1:
			tipo = "Conta Corrente";
			break;
			
		case 2:
			tipo = "Conta Poupança";
			break;
			
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da Conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: " + this.saldo);
		
		
	}
	
	
	}
	
	
	


