import java.util.*;
import java.text.DecimalFormat;

public class Matrizes {

    /*VARIAVEIS VISÍVEIS PARA TODOS OS METODOS DESTA CLASSE Matrizes*/

    public static int LINHA = 4;        /*SERÁ USADO MATRIZ QUADRADA 4x4*/
    public static int COLUNA = LINHA;
    public static int VETOR = 1;        /*usado nos 'vetores' com uma coluna ou uma linha*/

    public static int escolhaMatriz(){
        
        Scanner in = new Scanner(System.in);
        int op;

        System.out.println("\nEscolha uma matriz, A(1) ou B(2)?: ");
        op = in.nextInt();
 
        return op;
    }

    public static double[][] inserirValoresMatriz(int li, int col){
        
        double[][] mat = new double[li][col];
        int i, j;
        Random aleatorio = new Random();    
        int aux;

        for(i=0; i<li; i++){
            for(j=0; j<col; j++){
                
                aux = aleatorio.nextInt(7);       //insere numeros de 0 a 6
                
                if(aux == 6){                    //se algum valor for 6, ele passa a ser 1.0 para a matriz, aos inves de 0.6 será 1.0
                    mat[i][j] = 1.0;
                }
                else{
                    mat[i][j] = (double) aux / 10;   //passa os inteiros para 0.x e insere na mat de retorno
                }
            }
        }

        return mat;
    }

    public static void printaMatriz(int li, int col, double[][] mat){
        int i, j;
        DecimalFormat Df = new DecimalFormat("#.##");

        for(i=0; i<li; i++){
            for(j=0; j<col; j++){

                System.out.println("Celula " + i + " "+ j +": " + Df.format(mat[i][j]) + " ");
            }
            //System.out.println("\n");
        }
        System.out.println("\n");
    }
 
    public static double esparsidade(double[][] mat){
        
        int nulos = 0, total = LINHA * COLUNA;
        int i, j;

        for(i=0; i<LINHA; i++){
            for(j=0; j<COLUNA; j++){
                
                if(mat[i][j] == 0.0){
                    nulos++;
                }
            }
        }

        return (double)nulos/total;
    }

    public static double similaridade(double[][] mat1, double[][] mat2){
        
        /* somente compara matrizes de tamanhos iguais */
        
        int similares = 0, total = LINHA * COLUNA;
        int i, j;

        for(i=0; i<LINHA; i++){
            for(j=0; j<COLUNA; j++){

                if(mat1[i][j] == mat2[i][j]){
                    similares++;
                }
            }
        }
        
        return (double)similares / total;
    }

    public static double[][] somaMatrizes(double[][] mat1, double[][] mat2){
        
        int i, j;
        double[][] mat = new double[LINHA][COLUNA];

        for(i=0; i<LINHA; i++){
            for(j=0; j<COLUNA; j++){
                mat[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return mat;
    } 
    
    public static double[][] multiplicaMatrizes(int linhaMat1, int colunaMat2, int linhaColuna, double[][] mat1, double[][] mat2){

        /*assumo que ao chamar este método, serei resposável por tomar cuidado com a regra que mat1 terá a quantidade de
        colunas igual a de linhas da mat2*/
        double[][] matProduto = new double[linhaMat1][colunaMat2];
        int i, j, k;
        double aux = 0.0;

        for(i=0; i<linhaMat1; i++){             //controla a posicao da linha da matriz A
            for(j=0; j<colunaMat2; j++){        //controla a coluna da matriz B
                for(k=0; k<linhaColuna; k++){       //percorre os valores em ambas
                    aux = aux + (mat1[i][k] * mat2[k][j]);
                }
                matProduto[i][j] = aux;     //insere o resultado do somatório dos produtos na matriz de retorno
                aux = 0.0;
            }
        }

        return matProduto;
    }

    public static double[][] matrizTransposta(double[][] mat){
        int i, j;
        double[][] matTransposta = new double[COLUNA][LINHA];

        for(i=0; i<LINHA; i++){
            for(j=0; j<COLUNA; j++){
                matTransposta[j][i] = mat[i][j];
            }
        }

        return matTransposta;
    }

    public static double[] passaVetorParametro(int colunaVet, double[][] vetLinha){
        int i, j;
        double[] vet = new double[colunaVet];

        for(j=0, i=0; j<colunaVet; j++){
            vet[j] = vetLinha[i][j];
        }

        return vet;
        
    }

    public static void printaVetor(int tam, double[] vet){
        int i;
        DecimalFormat Df = new DecimalFormat("#.##");

        for(i=0; i<tam; i++){
                System.out.println("Celula " + i + ": " + Df.format(vet[i]) + " ");
            }
            //System.out.println("\n");
        
        System.out.println("\n");
    }
   
    public static double[] inserirValoresVetor(int tam){
        
        double[] vet = new double[tam];
        int i;
        Random aleatorio = new Random();    
        int aux;

        for(i=0; i<tam; i++){
                
            aux = aleatorio.nextInt(7);       //insere numeros de 0 a 6
            
            if(aux == 6){                    //se algum valor for 6, ele passa a ser 1.0 para a matriz, aos inves de 0.6 será 1.0
                vet[i] = 1.0;
            }
            else{
                vet[i] = (double) aux / 10;   //passa os inteiros para 0.x e insere na mat de retorno
            }  
        }

        return vet;
    }

    public static double[][] vetorParaMatriz(double[] vet){
        int i, j;
        double[][] mat = new double[LINHA][COLUNA];

        /*está definido no main que este vetor passado como parametro será do mesmo tamanho que as colunas da minha matriz*/
        
        for(i=0; i<LINHA; i++){
            for(j=0; j<COLUNA; j++){
                mat[i][j] = vet[j];
            }
        }

        return mat;
    }
    
    public static void main(String[] args) throws Exception {
        
        double[][] matA = new double[LINHA][COLUNA];            /*MATRIZ A*/
        double[][] matB = new double[LINHA][COLUNA];            /*MATRIZ B*/
        double[][] matResultante = new double[LINHA][COLUNA];   /*MATRIZ RESULTANTE*/
        double[][] vetColuna = new double[LINHA][VETOR];        /*VETOR-COLUNA*/
        double[][] vetLinha = new double[VETOR][COLUNA];        /*VETOR-LINHA*/
        double[] vetResultante = new double[COLUNA];
        double[] vetParaMatriz = new double[COLUNA];
        Scanner entrada = new Scanner(System.in);
        int op;
        
        //chamar metodo para preencher matrizes
        matA = inserirValoresMatriz(LINHA, COLUNA);
        matB = inserirValoresMatriz(LINHA, COLUNA);

        //chamar metodo para preencher vetores
        vetColuna = inserirValoresMatriz(LINHA, VETOR);
        vetLinha = inserirValoresMatriz(VETOR, COLUNA);

        //printa na tela matrizes e vetores
        System.out.println("\t\t**MATRIZ A**");
        printaMatriz(LINHA, COLUNA, matA);

        System.out.println("\t\t**MATRIZ B**");
        printaMatriz(LINHA, COLUNA, matB);

        System.out.println("\t\t**VETOR-COLUNA**");
        printaMatriz(LINHA, VETOR, vetColuna);

        System.out.println("\t\t**LINHA-VETOR**");
        printaMatriz(VETOR, COLUNA, vetLinha);


        do{
            System.out.println("***************************************OPCOES***********************************************\n");
            System.out.println("\n\n1 - Fator esparsidade           6 - Produto de matriz por vetor-coluna\n");
            System.out.println("2 - Fator similaridade          7 - Produto de vetor-linha por matriz\n");
            System.out.println("3 - Soma das matrizes           8 - Matriz com valores de um vetor\n");
            System.out.println("4 - Produto das matrizes        9 - Vetor com elementos de vetor passado como parâmetro\n");
            System.out.println("5 - Transposta de uma matriz    0 - SAIR\n");
        
            System.out.println("Insira a opcao desejada:");
            op = entrada.nextInt();
            
            switch(op){
                case 1:
                    //fator esparsidade
                        
                    if(escolhaMatriz() == 1){
                        System.out.println("\n************************************SAIDA*******************************************\n");
                        System.out.println("\tO fator esparsidade da Matriz A eh: " + esparsidade(matA));
                        System.out.println("\n************************************************************************************\n");
                    }else{
                        System.out.println("\n************************************SAIDA*******************************************\n");
                        System.out.println("\tO fator esparsidade da Matriz B eh: " + esparsidade(matB));
                        System.out.println("\n************************************************************************************\n");
                    }
                    break;

                case 2: 
                    //fator similaridade
                    
                    System.out.println("\n************************************SAIDA*******************************************\n");
                    System.out.println("\tO fator de similaridade entre as matrizes A e B eh: " + similaridade(matA, matB));
                    System.out.println("\n************************************************************************************\n");
                    //System.out.println("teste");
                    break;
                case 3:
                    //soma de matrizes
                    
                    matResultante = somaMatrizes(matA, matB);
                    
                    System.out.println("\n************************************SAIDA*******************************************\n");
                    System.out.println("\tA matriz resultante da soma das matrizes A e B eh: \n");
                    printaMatriz(LINHA, COLUNA, matResultante);
                    System.out.println("\n************************************************************************************\n");
                    break;
                case 4:
                    //produto das matrizes
                    
                    System.out.println("\n************************************SAIDA*******************************************\n");
                    System.out.println("\tA matriz resultante do produto das matrizes A e B eh: \n");
                    matResultante = multiplicaMatrizes(LINHA, COLUNA, COLUNA, matA, matB);
                    printaMatriz(LINHA, COLUNA, matResultante);
                    System.out.println("\n************************************************************************************\n");
                    break;
                case 5: 
                    //transposta de uma matriz

                    if(escolhaMatriz()== 1){
                        matResultante = matrizTransposta(matA);
                        System.out.println("\n************************************SAIDA*******************************************\n");
                        System.out.println("\tMatriz A Transposta: \n");
                    }else{
                        matResultante = matrizTransposta(matB);
                        System.out.println("\n************************************SAIDA*******************************************\n");
                        System.out.println("\tMatriz B Transposta: \n");
                    }
                

                    printaMatriz(COLUNA, LINHA, matResultante);
                    System.out.println("\n************************************************************************************\n");
                    break;
                case 6:
                    //produto de matriz vetor-coluna
                    if(escolhaMatriz()== 1){
                        matResultante = multiplicaMatrizes(LINHA, VETOR, LINHA, matA, vetColuna);
                    }else{
                        matResultante = multiplicaMatrizes(LINHA, VETOR, LINHA, matB, vetColuna);
                    }
                    
                    System.out.println("\n************************************SAIDA*******************************************\n");
                    System.out.println("\tMatriz produto matriz * vetor-coluna: \n");
                    printaMatriz(LINHA, VETOR, matResultante);
                    System.out.println("\n************************************************************************************\n");
                    break;
                case 7:
                    //produto de vetor-linha matriz
                    if(escolhaMatriz()== 1){
                        matResultante = multiplicaMatrizes(VETOR, COLUNA, COLUNA, vetLinha, matA);
                    }else{
                        matResultante = multiplicaMatrizes(VETOR, COLUNA, COLUNA, vetLinha, matB);
                    } 
                    
                    System.out.println("\n************************************SAIDA*******************************************\n");
                    System.out.println("\tMatriz produto vetor-linha * matriz: \n");
                    printaMatriz(VETOR, COLUNA, matResultante);
                    System.out.println("\n************************************************************************************\n");
                    break;
                case 8:
                    //matriz com valor de um vetor
                    vetParaMatriz = inserirValoresVetor(COLUNA);    //cria uma vetor com outros valores aleatorios
                    System.out.println("\n************************************SAIDA*******************************************\n");
                    System.out.println("\tVetor que ira para matriz: \n");
                    printaVetor(COLUNA, vetParaMatriz); 

                    matResultante = vetorParaMatriz(vetParaMatriz);     //passa o vetor para a matriz
                    System.out.println("\n\tMatriz com valores do vetor: \n");
                    printaMatriz(LINHA,COLUNA, matResultante);
                    System.out.println("\n************************************************************************************\n");
                    break;
                case 9:
                    //vetor com valor de vetor parametro
                    /*vou passar o vetor vetLinha (00, 01, 02, 03), porque possui apenas uma linha*/

                    vetResultante = passaVetorParametro(COLUNA, vetLinha);  //passa como parametro o vetor-linha 
                    System.out.println("\n************************************SAIDA*******************************************\n");
                    System.out.println("\tVetor igual ao vetor-linha: \n");
                    printaVetor(COLUNA, vetResultante);
                    System.out.println("\n************************************************************************************\n");
                    break;
                case 0:
                    System.out.println("\n\n\t\tSaindo...\n\n");
                    break;
                default:
                    System.out.println("\n\n\t\tERRO! Opcao invalida!\n\n");
                    break;
        
            }
        }while(op != 0);

        entrada.close();    //fecha o scanner
        

    }
}