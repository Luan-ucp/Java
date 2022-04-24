public class SleepMessages {
    public static void main(String [] args) /*throws InterruptedException*/{

            String importantInfos [] = {
                    "Eu gosto do Rubens",
                    "Eu amo o meu comuninha",
                    "Ele é lindo <3",
                    "Eu quero um abraço dele agora"
            };

                for (int i = 0; i < importantInfos.length; i++) {


                    //1 milisegundo é 10^-3 segundos, 4000 milisegundos é 4 segundos

                    try{
                        Thread.sleep(2000);

                    } catch (InterruptedException e){

                        if (Thread.interrupted()) {

                            //aqui ele verifica se o processo foi interrompido (APENAS PARA VERIFICAR MESMO)
                            //NAO EXIBE A MENSAGEM (???)
                            System.out.println("\n\tVerificou se a Thread estava interrompida");
                        }
                    }

                    System.out.println(importantInfos[i]);
                }

    }
}
