public class SleepMessages {
    public static void main(String [] args) throws InterruptedException{

            String importantInfos [] = {
                    "Eu gosto do Rubens",
                    "Eu amo o meu comuninha",
                    "Ele é lindo <3",
                    "Eu quero um abraço dele agora"
            };

            for(int i = 0; i < importantInfos.length; i++) {

                //1 milisegundo é 10^-3 segundos, 4000 milisegundos é 4 segundos
                Thread.sleep(4000);
                System.out.println(importantInfos[i]);
            }
    }
}
