public class Progression {
    /**
     * uma classe de progressão aritmética
     */

    /** primeira valor da progressão */
    protected long first;
    /** segundo valor da progressão */
    protected long cur;

    Progression(){
        cur = first = 0;
    }
    /** reinicializa a progressão com o valor inicial
     *
     * @return valor inicial
     */

    protected long firstValue(){
        cur = first;
        return cur;
    }
    /** Avança a progressão para o próximo valor
     * @return proximo valor da progressão
     */

    protected long nextValue(){
        return ++cur; //próximo valor default
    }

    /**
     * imprime os primeiros valores n da progressão
     * @param n de valores a serem impressos
     */
    public void printProgression(int n){
        System.out.print(firstValue());

        for(int i = 2; i<= n; i++)
            System.out.print(" " + nextValue());
        System.out.println(); //termina a linha
    }

}
