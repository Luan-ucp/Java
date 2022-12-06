class ArithProgression extends Progression {
    /**incremento*/

    protected long inc;

    //herda variaveis de Progression

    /** construtor default inicializa com incremento de 1*/
    ArithProgression(){
        this(1);
    }

    /**construtor parametrico fornece o incremento*/
    ArithProgression(long increment){
        inc =  increment;
    }

    /** Avança a progressão acrescentando o incremento ao valor atual
     * @return próximo valor da progreção
     */

    protected long nextValue(){
        cur += inc;
        return cur;
    }

    //herda os métodos firstValue() e printProgression()
}