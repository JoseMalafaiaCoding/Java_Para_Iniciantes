class GalToLit{
	public static void main(String args[]){
		double galoes;
		System.out.println("Insira o valor de galoes a ser convertido:");
		galoes = 10.0;
		if(galoes < 2){
			System.out.println("Valor muito baixo");
		}
		System.out.println(galoes + "galoes equivale a " + galoes * 3.7854 + " litros.");
	}
}
