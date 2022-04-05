//O nome da classe é OvlQueue por estar fazendo referência à sobrecarga(Overload) de construtores
class OvlQueue{
    //Serão duas variáveis de instância nesta classe, diferente do que ocorreu no outro problema
    private int putIndex;
    private int [] queueArray;
    //Irei tratar todas como private, pois elas não precisam ser acessadas diretamente por outras classes, e os objetos dessa não poderão fazer modificações em seus valores

    //O primeiro construtor vai criar uma nova fila com valores iniciais próprios
    OvlQueue(int length){
        this.putIndex = 0;
        this.queueArray = new int[length];
    }

    //Agora o construtor sobrecarregado cria uma nova fila a partir de outra
    OvlQueue(OvlQueue newQueue){
        this.putIndex = newQueue.getPutIndex();
        queueArray = new int [newQueue.getQueueLength()];
    }

    //gets necessários para retornar os valores de putIndex e getIndex e assim atribuir seus valores às variaveis de um objeto criado a partir de outro
    public int getPutIndex(){
        return this.putIndex;
    }

    public int getQueueLength(){
        return this.queueArray.length;
    }

    //O método isEmpty() verifica se a fila está cheia checando se o indice de inserção é o mesmo do de retirada, este é um indicativo de que a fila está vazia, já que os valores são inseridos apenas em índices vazios e retirados de índices não vazios
    public boolean isEmpty(){
        if((putIndex == 0)) return true;
        return false;
    }
    //O método isFull() verifica se a fila está cheia comparando o valor de putIndex com o tamanho da fila, caso seja o mesmo, isso índica que todos os elementos da fila foram preenchidos já que o índice do último elemento é equivalente ao tamanho da fila menos 1 e portanto não seria possível acessar nenhuma valor posterior de índice
    public boolean isFull(){
        if(putIndex == queueArray.length) return true;
        return false;
    }

    //Para inserir um valor na fila é necessário verificar se ela está cheia antes e depois a inserção é feita pela atribuição do valor do parâmetro no elemento do array com índice do local de inserção, em seguida é feito um incremento no valor de putIndex para outras possíveis inserções
    public boolean put(int value){
        if(isFull()){
            return false;
        }
        queueArray[putIndex++] = value;
        return true;
    }
    
    //Na retirada de um valor, o mesmo deve ser retirado da fila e retornado pelo método
    //primeiramente é criada uma variável que vai receber o valor do primeiro elemento da fila em seguida é verificado se a fila está vazia, neste caso um valor arbitrário é retornado, se falso a variável a ser retornada recebe o valor inicial da fila e um for percorre a fila atribuindo sequencialmente os valores dos elementos seguintes (i + 1) aos atuais (i), sem com a preocupação de tentar acessar um índice invalido, ja que i é comparado a se ele for menor que putIndex - 1, ao final é necessário decrementar 1 unidade de putIndex
    public int get(){
        int getValue = 0;
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        getValue = queueArray[0];
        for(int i = 0; i < putIndex - 1; i++){
            queueArray[i] = queueArray[i + 1];
        }
        putIndex--;
        return getValue;
    }
}
//classe com método main para testes
class NewQueue {
    public static void main(String [] args){
        OvlQueue fila1 = new OvlQueue(5);
        System.out.println(fila1.isEmpty());
        fila1.put(1);
        System.out.println(fila1.isEmpty());
        fila1.get();
        System.out.println(fila1.isEmpty());
        fila1.put(9);
        System.out.println(fila1.get());
        System.out.println(fila1.get());
        fila1.put(3);
        System.out.println(fila1.get());
        for(int i = 0; i <= fila1.getQueueLength(); i++){
            System.out.println(fila1.put(i * 3));
        }
        OvlQueue fila2 = new OvlQueue(fila1);
        for(int i = 0; i <= fila1.getQueueLength(); i++){
            System.out.println(fila1.get());
        }
        for (int i = 0; i < fila1.getQueueLength(); i++) {
            System.out.print(fila1.put(4 * (i + 1)) + ": ");
            System.out.println(fila1.get());
        }

        System.out.println(fila1.isEmpty() + " " + fila1.isFull());
        System.out.println(fila2.isEmpty());
    }
}