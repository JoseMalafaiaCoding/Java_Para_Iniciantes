class CLArgs{
	public static void main(String args[]){
		System.out.println("O array de String, args[] recebe todos os argumentos passados na linha de comando apos o nome do programa quando ele e chamado:");
		for(int i = 0; i < args.length; i++){
			System.out.println("args[" + i + "]:" + args[i]);
		}
		System.out.println("Cada argumento e separado por um espaco");
	}
}  