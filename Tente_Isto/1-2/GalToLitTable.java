class GalToLitTable{
	public static void main(String args[]){
		double galoes;
		int count = 0;
		for(int i = 0; i < 100; i++){
			galoes = i + 1;
			System.out.println(galoes + " galoes equivale a " + galoes * 3.7854 + " litros");
			count++;
			if(count == 10){
				System.out.println();
				count = 0;
			}
		}
	}
}