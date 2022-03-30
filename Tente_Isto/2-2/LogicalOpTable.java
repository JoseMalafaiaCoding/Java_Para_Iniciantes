class LogicalOpTable{
	public static void main(String args[]){
		boolean p = true, q = true;
		//Cabeçalho da tabela
		System.out.println("p\tq\tAND\tOR\tXOR\tNOTp\tNOTq");
		//valores da tabela
		
		System.out.println(p + "\t" + q + "\t" + (p&&q) + "\t" + (p||q) + "\t" + (p^q) + "\t" + !p + "\t" + !q);
		q = false;		
		System.out.println(p + "\t" + q + "\t" + (p&&q) + "\t" + (p||q) + "\t" + (p^q) + "\t" + !p + "\t" + !q);
		p = false; q = true;
		System.out.println(p + "\t" + q + "\t" + (p&&q) + "\t" + (p||q) + "\t" + (p^q) + "\t" + !p + "\t" + !q);
		q = false;
		System.out.println(p + "\t" + q + "\t" + (p&&q) + "\t" + (p||q) + "\t" + (p^q) + "\t" + !p + "\t" + !q);
	}
}