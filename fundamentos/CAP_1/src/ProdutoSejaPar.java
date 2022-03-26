import java.util.Random;

public class ProdutoSejaPar {

    //construtor que gera um array de numeros aleatorios
    ProdutoSejaPar(int[] num){
        int i;
        Random gerador = new Random();

        for(i=0; i<10; i++)
            num[i] = gerador.nextInt(1000);

        //this.CalculaProduto(num);
    }

    public void CalculaProduto(int[] num){
        int i;

        for(i=0; i< num.length - 2; i++){

            if((num[i] * num[i+1]) % 2 == 0){
                System.out.println("\n\tO numero "+ num[i] + " * " + num[i+1] + " eh PAR!\n");
                System.out.println("Rodou "+ (i+1) + " vezes\n");
                break;
            }
            else if(i == num.length - 2){
                System.out.println("Nao teve nenhum par de numeros que o produto fosse PAR!");
            }
        }

    }
}

