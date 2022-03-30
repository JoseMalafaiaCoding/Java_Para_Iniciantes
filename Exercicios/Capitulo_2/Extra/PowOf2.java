class PowOf2{
	public static void main (String args[]){
		//No primeiro laço é definido qual o intervalo de potencias será exibido
		for(int i = 0; i < 10; i++){
			int potencia = 1;
			//No segundo laço são feitas as iterações a depender da potencia que está sendo calculada
			for(int j = 0; j < i; j++){
				potencia *= 2;
			}
			System.out.println(potencia);
		}
	}
}