import java.util.Scanner;
public class Main{

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Calculadora calculo;

        System.out.println("Digite dois valores dando espaço entre eles: ");
        float valor1 = in.nextFloat();
        float valor2 = in.nextFloat();

        System.out.println("Digite o tipo de operação escolhida (+, -, * ou /: ");
        char op = in.next().charAt(0);

        calculo = new Calculadora(valor1, valor2, op);


    }
}

