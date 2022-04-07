class QuickSort{
	
	public static void sort(char items []){
		qsort(items, 0, items.length - 1);
	}
	
	private static void qsort(char[] items, int left, int right){
		//x e y vão guardar os elementos do array para fazer as trocas de valores entre os índices
		char x, y;
		//i e j vão servir para percorrer o array pra cada vez que o método for chamado
		int i, j;
		//x recebe o elemento que se encontra no meio da partição gerada do array, a partição é representada pelos índices left e right
		x = items[(left + right)/2];
		//i recebe left pois é a variavel que vai percorrer a partição da esquerda para a direita e j recebe right ja que ela percorre da direita para a esquerda
		i = left; j = right;
		do{
			//O while abaixo busca por um elemento à esquerda que seja maior que o elemento no meio da partição enquanto não for, i é incrementado, caso seja, as iterações são interrompidas e i vai ter o mesmo valor daquele índice que possui o elemento maior que o elemento ao meio da partição, como queremos uma classificação crescente, então os elementos maiores da partição ficarão à direita
			while((items[i] < x) && (i < right))i++; 
			//No while seguinte a busca é feita por um elemento que seja menor que o elemento central, enquanto n for encontrado, j é decrementado, quando for encontrado a iteração é interrompida, importante notar que em ambos os casos, caso nenhum valor seja encontrado no range estipulado, a iteração também é interrompida, ja que os elementos ja estão organizados para a chamada atual
			while((items[j] > x) && (j > left))j--;
			if(i <= j){ 
			//essa condição só será verdadeira caso realmente exista algum valor para ser organizado, senão i será maior do que j, ja que as iterações passaram do elemento central da partição
			//A troca de valores é feita como num bubble sort, mas os elementos sendo manipulados não estão, necessariamente um ao lado do outro
			y = items[i];
			items[i] = items[j];
			items[j] = y;
			//abaixo i é incrementado e j decrementado pois os valores de cada lado do array(direito e esquerdo) foram inseridos em suas posições corretas para a chamada atual
			i++; j--;
			}
		}while(i <= j);
		//ao final das iterações acima, i e j sempre vão chegar no indice do elemento central ou passar uma unidade dele
		
		//O if abaixo testa se ainda é possível fazer uma partição à esquerda da metade da partição da chamada atual, se for, então uma nova partição é feita
		//o caso base é não haverem mais partições a serem feitas em cada lado do array
		//O teste é feito se j é menor do que left, ja que aquela variável é decrementada ao longo do percurso na partição e portanto ela vai se encontrar uma unidade à esquerda da partição atual, o que significa que estará na extremidade direita da partição seguinte, na próxima chamada
		if(left < j) qsort(items, left, j);
		//O if abaixo testa se ainda é possível fazer uma partição à esquerda da metade da partição da chamada atual, lembrando que o programa só chega aqui quando o array total for reduzido em todas as possíveis partições da esquerda, sendo os retornos feitos consecutivamente para começar a fazer chamadas em partições à direita de cada partição criada à esquerda do array total
		//o teste é feito se i é maior que right, ja que aquela variavel é incrementada ao longo do percurso na partição e portanto, ao final ela vai se encontrar à direita da partição atual
		if(right > i) qsort(items, i, right);
	}
	
}

class QSDemo{
	public static void main(String[] args){
		char[] unsortedArray = {'f', 'e', 'd', 'a', 'c', 'b'};
		for(char x: unsortedArray){
			System.out.print(x + " ");
		}
		System.out.println();
		QuickSort.sort(unsortedArray);
		for(char x: unsortedArray){
			System.out.print(x + " ");
		}
	}
}