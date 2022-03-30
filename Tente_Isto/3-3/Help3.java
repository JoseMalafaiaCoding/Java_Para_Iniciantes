class Help3{
public static void main(String args[]) throws java.io.IOException{
	for(;;){
		//Mostrar a sintaxe das instruções if, switch, for, while e do-while
		char entrada, ignore;
		//Permanece no laço até uma entrada válida ser inserida
		do{
			//Mostra o menu de opções para o usuário
			System.out.println("\nMenu");
			System.out.println("Digite uma das opcoes a seguir:");
			System.out.println("1. if \t2. switch \t3. for \t4. while \t5. do-while\t6. break \t7. continue\tq. para sair");
			//Solicita do usuário a opção desejada
			entrada = (char) System.in.read();
			//Retira do buffer de entrada caracteres inseridos a mais e o carriage return
			do{
				ignore = (char) System.in.read();
			}while(ignore != '\n');
			//Seleciona a opção escolhida
			switch (entrada){
				case '1':
					System.out.println("Essa e a sintaxe geral da instrucao if\n if (condicao){\n \tinstrucao\n} else{\n \tinstrucao");
					break;
				case '2':
					System.out.println("Essa e a sintaxe geral da instrucao switch\nswitch (expressao){\n\tcase constante1:\n\t\t instrucao\n break;" +
					"\n\tcase constante2\n \t\tinstrucao\n break;\n\tdefault: \n\t\tinstrucao caso nenhum dos cases seja selecionado");
					break;
				case '3':
					System.out.println("Esta e a sintaxe da instrucao for");
					System.out.println("for(inicializacao; condicao; incremento){\n\tsequencia de exprecoes\n}");
					break;
				case '4':
					System.out.println("Esta e a sintaxe da instrucao while");
					System.out.println("while(condicao){\n\tsequencia de exprecoes\n}");
					break;
				case '5':
					System.out.println("Esta e a sintaxe da instrucao do-while");
					System.out.println("do{\n\tsequencia de exprecoes\n}while(condicao);");
					break;
				case '6':
					System.out.println("Esta e a sintaxe da instrucao break");
					System.out.println("laco(condicao){ ou rotulo: laco(condicao){");
					System.out.println("\tsequencia de instrucoes\n\tbreak ou break rotulo;\n}");
					break;
				case '7':
					System.out.println("Esta e a sintaxe da instrucao continue");
					System.out.println("laco(condicao) ou rotulo: laco(condicao){");
					System.out.println("\tsequencia de instrucoes\n\tcontinue; ou continue rotulo;\n}");
					break;
				case 'q':
					System.out.print("Saindo...");
					break;
				default: 
					System.out.println("Nenhuma das opcoes foi selecionada.");
			}
		}while((entrada < '1' || entrada > '7') && entrada != 'q');
		if(entrada == 'q') break;
	}
}
}