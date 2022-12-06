class GeomProgression extends Progression {
    /**Base*/

    protected long base;

    //herda as variéveis first e cur

    /**construtor default inicializa o valor base com 2*/

    GeomProgression(){
        this(2);
    }

    /** Construtor paramétrico fornece o valor base
     * @param b é o valor base da progressão
     */
    GeomProgression(long b){
        base = b;
        first = 1;
         cur = first;
    }

    /** Avança a progressão multiplicando a base pelo valor corrente
     * @return próximo valor da progressão
     */

    protected long nextValue(){
        cur *= base;
        return cur;
    }

    //herda os métodos firstValue() e printProgression()
}
