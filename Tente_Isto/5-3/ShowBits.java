class BitInteger{
	int num;
	//num é a variável de instância que recebe o número a ser convertido em sua forma binária
	BitInteger(int num){
		//Neste programa não são mostrados números negativos
		this.num = num < 0 ? -num : num;
	}
	
	int getBaseNumber(){
		//Na conversão é necessário encontrar uma potência de 2 que será usada em uma operação bitwise para converter o número solicitado
		//A cada iteração o número de base é mutiplicado por 2 e a instrução for repete enquanto i for maior que 0, iniciando pelo valor num, quando i chega em 0
		//Mais uma iteração é feita e o número base é uma "casa" maior que num e assim, na conversão, todas as "casas" de num serão testadas
		int baseNumber = 1;
		for(int i = this.num; i > 0; i = i/2){
			baseNumber = baseNumber * 2;
		}
		return baseNumber;
	}
	
	int []getBits(){
		//Os bits são armazenados em um array, para não serem mostrados por um método da classe e sim na main
		//Para encontrar o tamanho do array é preciso saber qual o log de num na base 2, que equivale ao número de algarismos do valor na forma binária
		int bitsArray[] = new int[(int)((Math.log(getBaseNumber()) / Math.log(2)))];
		int arrayIndex = 0;
		//Na iteração t recebe o numero base menos 1 bit da direita que é para não 
		//ultrapassar o número de algarismos que tem num em binário, pois geraria um bit 0 a mais na esquerda
		for(int t = getBaseNumber() >> 1; t > 0; t = t/2){
			if((this.num & t) != 0){
				bitsArray[arrayIndex] = 1;
				arrayIndex++;
			}else{
				bitsArray[arrayIndex] = 0;
				arrayIndex++;
			}
		}
		return bitsArray;
	}
}

class ShowBits{
	public static void main(String args[]){
		BitInteger newBits = new BitInteger(64);
		int newArray[] = newBits.getBits();
		for(int x: newArray){
			System.out.print(x + " ");
		}
	}
}