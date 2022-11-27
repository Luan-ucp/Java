public class Calculadora {
    float valor1, valor2, resultado;
    char ope;
    Calculadora(float num1, float num2, char op){
        valor1 = num1;
        valor2 = num2;
        ope = op;

        this.operador(ope);
    }

    public void operador(char ope){

        switch (ope){
            case '+':
                this.soma(valor1, valor2);
                break;
            case '-':
                this.subtracao(valor1, valor2);
                break;
            case '*':
                this.multiplicacao(valor1, valor2);
                break;
            case '/':
                this.divisao(valor1, valor2);
                break;
            default:
                System.out.println("Operador invalido!");

        }
    }

    public void soma(float valor1, float valor2){
        this.exibeResultado(valor1 + valor2);
    }

    public void subtracao(float valor1, float valor2){
        this.exibeResultado(valor1 - valor2);
    }

    public void multiplicacao(float valor1, float valor2){
        this.exibeResultado(valor1 * valor2);
    }

    public void divisao(float valor1, float valor2){
        this.exibeResultado(valor1 / valor2);
    }

    public void exibeResultado(float resultado){
        System.out.println("Resultado: "+ resultado);
    }
}
