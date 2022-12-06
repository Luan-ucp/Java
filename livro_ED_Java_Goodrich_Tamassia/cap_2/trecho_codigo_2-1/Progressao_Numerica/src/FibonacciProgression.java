class FibonacciProgression extends Progression{

    /**Valor anterior*/

    long prev;
    //herda variaveis cur e first

    /** Construtor default inicializa os dois primeiros valores como sendo 0 e 1*/

    FibonacciProgression(){
        this(0, 1);
    }

    /** construtor paramétrico fornece o primeiro e o segundo valores
     * @param value1 primeiro valor
     * @param value2 segundo valor
     */

    FibonacciProgression(long value1, long value2){
        first = value1;
        prev = value2 - value1; //valor fictício que antecede o primeiro
    }

    /**avança a progressão somando o valor anterior no valor atual
     * @return próximo valor da progressão
     */

    protected long nextValue(){
        long temp = prev;
        prev = cur;
        cur += temp;
        return cur;
    }

    //herda os métodos firstValue() e printProgression()
}
