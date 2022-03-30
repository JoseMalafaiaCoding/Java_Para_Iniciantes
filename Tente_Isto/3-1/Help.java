class Help{
	public static void main(String args[]) throws java.io.IOException {
		//Exibe String do menu com as opções possíveis
		System.out.println("Menu\n Escolha uma das opcoes:\n 1. Instrucao de controle if \t 2. Instrucao de controle switch");
		//Instrução de entrada pelo console
		char entrada = (char)System.in.read();
		//Instrução switch para selecionar a escolha da entrada
		switch (entrada){
			case '1':
				System.out.println("Essa e a sintaxe geral da instrucao if\n if (condicao){\n \tinstrucao\n} else{\n \tinstrucao");
			break;
			case '2':
				System.out.println("Essa e a sintaxe geral da instrucao switch\nswitch (expressao){\n\tcase constante1:\n\t\t instrucao\n break;" +
				"\n\tcase constante2\n \t\tinstrucao\n break;\n\tdefault: \n\t\tinstrucao caso nenhum dos cases seja selecionado");
			break;
			default: 
				System.out.println("Nenhuma das opcoes foi selecionada.");
		}
	}
}