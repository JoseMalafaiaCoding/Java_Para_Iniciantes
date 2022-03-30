//Pilha, definição FILO - first-in last-out
//Fila, definição FIFO - first-in first-out
//Trabalhar com o conceito de fila não linear, nesse caso os espaços dos arrays subjacentes ao removido não são reutilizados

class Queue{
	char q[];
	
	Queue(int size){
		this.q = new char [size];
	}
	
	boolean isEmpty(){
		//Verifica se a fila esta vazia, checando todos os elementos do array e retornando true caso seja encontrado algum caractere diferente de vazio (\0)
		for(int i = 0; i < this.q.length; i++){
			//caso o elemento seja igual ao laço, o bloco da condicional não é executado e o comando do programa volta pro laço
			if(this.q[i] != '\0'){
				return false;
			}
		}
		return true;
	}
	//Método que checa se a fila está cheia
	boolean isFull(){
		//se o ultimo elemento da fila estiver preenchido significa que a fila está cheia
		if(this.q[this.q.length - 1] != '\0'){
			return true;
		}
		return false;
	}
	
	boolean put(char value){
		//insere um valor no primeiro elemento da fila caso ela esteja vazia
		if(isEmpty()){
			this.q[0] = value;
			return true;
		}
		int counter = 1;
		//se a fila não estiver vazia a instrução abaixo percorre o array até encontrar um elemento vazio e então insere um valor nesse elemento
		//primeiramente verifica se a fila está cheia, caso esteja a instrução while não é executada
		while(!isFull()){
			if(this.q[counter] == '\0'){
				this.q[counter] = value;
				return true;
			}
			counter++;
		}
			return false;
	}
	
	int getIndexOfLast(){
		int counter = 0, indexOfLast = 0;
		if(isFull()){
			return (this.q.length - 1);
		}
		while(this.q[counter] != '\0'){
			indexOfLast = counter;
			counter++;
		}
		return indexOfLast;
	}
	
	char get(){
		//retorna o primeiro valor da fila e o retira dela, em seguida empurra os demais elementos do array para frente até atingir o ultimo elemento
		char first = q[0];
		int indexOfLast = 0, counter = 0;
		if(isEmpty()){//caso esteja vazia o metodo retorna um valor vazio
			return '\0';
		}else if(this.q.length == 1){
			//em seguida verifica se a fila tem tamanho 1 e neste caso remove e retorna este valor
			this.q[0] = '\0';
			return first;
		}
		//A condicional abaixo vai realizar a busca pelo último elemento, ou seja, o elemento anterior ao elemento cujo valor é vazio
		//Caso a fila esteja cheia, o último elemento é o de maior índice, ou seja q.length - 1
		if(isFull()){
			indexOfLast = this.q.length - 1;
		}else{
			//Se a fila não estiver cheia, o laço abaixo vai verificar a partir do contador se o elemento de índice contador está vazio, se não estiver ele atribui este índice
			//à variável indexOfLast e soma mais 1 no contador, quando é feita a verificação e o resultado é que o elemento de indice contador tem valor vazio, o laço é encerrado
			//e portanto vai ficar armazenado em indexOfLast o valor do contador da última iteração do while
			while(this.q[counter] != '\0'){
				indexOfLast = counter;
				counter++;
			}
		}
		//Depois de achar o indice do último elemento na fila, agora será possível percorrer todo o array, sem fazer iterações desnecessárias ou perder valores
		for(int i = 0; i < indexOfLast; i++){
			this.q[i] = this.q[i + 1]; 
		}
		
		if(isFull()){
			this.q[this.q.length - 1] = '\0';
		}else{
			this.q[indexOfLast] = '\0';
		}
		
		return first;
	}
	
}

class QDemo{
	public static void main(String args[]) throws java.io.IOException{
		Queue fila1 = new Queue(5);
		char valor = ' ', escolha = ' ', ignore;
		while(valor != 'x'){
			ignore = ' ';
			System.out.println("Escolha um valor para inserir na fila: g para retirar um valor da fila - s para mostrar a fila - x para sair");
			valor = (char) System.in.read();
			while(ignore != '\n'){
					ignore = (char) System.in.read();
			}
			if(valor == 'g'){
				if(!fila1.isEmpty()){
					System.out.println(fila1.get());
				}else{
					System.out.println("A fila esta vazia");
				}
			}else if(valor == 's'){
			
				if(!fila1.isEmpty()){
					for(int i = 0; i <= fila1.getIndexOfLast(); i++){
						System.out.println(fila1.q[i]);
					}
				}else{
					System.out.println("A fila esta vazia");
				}
			}else{
				if(valor == 'x'){
					break;
				}
				if(!fila1.isFull()){
					fila1.put(valor);
					System.out.println("O valor " + valor + " Foi adicionado a fila");
				}else{
					System.out.println("A fila esta cheia");
				}
			}
		}
	}
}
