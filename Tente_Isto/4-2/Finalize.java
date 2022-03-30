class FDemo{
	int x;
	//construtor da classe FDemo
	FDemo(int i){
		x = i;
	}
	
	protected void finalize(){
		System.out.println("Finalizing " + x);
	}
	//Gera um objeto que é imediatamente destruido
	void generator(int i){
		FDemo o = new FDemo(i);
	}
}

class Finalize{
	public static void main(String args[]){
		int count;
		
		FDemo ob = new FDemo(0);
		
		for(count = 1; count < 100000; count++){
			ob.generator(count);
		}
	}
}