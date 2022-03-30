class BubbleSort{
	//Declara um array que vai receber os valores a serem classificados
	int lista[];
	int size;
	
	//O construtor vai receber como argumento de seu parametro um array com os valores a serem classificados
	BubbleSort(int lista[], int size){
		this.lista = lista;
		this.size = size;
	}
	
	//O método sort() irá realizar a classificação de lista[]
	int[] sortDownUp(){
		//Como lista[] é um membro de BubbleSort, posso utiliza-lo aqui para fazer a classificação e retorná-lo da função
		int buffer; 
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size - (i + 1); j++){
				if(this.lista[j + 1] < this.lista[j]){ //Verifica se o elemento do array seguinte é menor que o atual, se for, entra no bloco da instrução condicional
					buffer = this.lista[j]; //A variavel buffer recebe o valor atual do array para ser atribuída ao elemento seguinte
					//O valor do elemento atual(que é maior) é atribuído ao elemento seguinte do array, ja que a função classifica na ordem crescente
					this.lista[j] = this.lista[j + 1]; 
					//O elemento seguinte do array recebe o valor do buffer que representava o maior valor, nesta comparação, no array
					this.lista[j + 1] = buffer;
				}
			}
		}
		return this.lista;
	}
	
	int[] sortUpDown(){
		int buffer;
		for(int i = 0; i < this.size; i++){
			for(int j = this.size - 1; j > i; j--){
				if(this.lista[j - 1] > this.lista[j]){
					buffer = this.lista[j - 1];
					this.lista[j - 1] = this.lista[j];
					this.lista[j] = buffer;
				}
			}
		}
		return this.lista;
	}
}

class Bubble{
	public static void main(String args[]){
		int lista[] = new int[10];
		int count = 0;
		BubbleSort classificador = new BubbleSort(lista, lista.length);
		for(int i = lista.length; i > 0; i--){
			lista[count] = i;
			count++;
		}
		for(int i = 0; i < lista.length; i++){
			System.out.println(lista[i]);
		}
		System.out.println();
		lista = classificador.sortUpDown();
		for(int i = 0; i < lista.length; i++){
			System.out.println(lista[i]);
		}
	}
}