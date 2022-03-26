import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int[] num;
        num = new int[10];

        Scanner in = new Scanner(System.in);
        ProdutoSejaPar objPar = new ProdutoSejaPar(num);
        objPar.CalculaProduto(num);

    }
}
