import java.util.concurrent.*;

class Shared{
    static int count = 0;
}

class MyThread extends Thread{
    Semaphore sem;
    String threadName;

    public MyThread(Semaphore sem, String threadName){
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;

    }

    public void run(){

        if(this.getName().equals("A")){
            System.out.println("Iniciando a thread " + threadName);

            try{
                System.out.println(threadName + " esta esperando uma permissao");

                sem.acquire();

                System.out.println(threadName + " tem a permissao");

                for(int i=0; i<5; i++){
                    Shared.count++;

                    System.out.println(threadName + ": " + Shared.count);

                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("ERRO: " + e);
            }

            System.out.println(threadName + " libera a permissao");
            sem.release();
        }
        //se for a thread B
        else{

            System.out.println("Iniciando a thread " + threadName);

            try{
                System.out.println(threadName + " esta esperando uma permissao");

                sem.acquire();

                System.out.println(threadName + " tem a permissao");

                for(int i=0; i<5; i++){
                    Shared.count--;

                    System.out.println(threadName + ": " + Shared.count);

                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("ERRO: " + e);
            }

            System.out.println(threadName + " libera a permissao");
            sem.release();
        }
    }
}

public class SemaphoreDemo {
    public static void main(String [] args) throws InterruptedException{

        //o 1 é o numero de permissoes
        Semaphore sem =  new Semaphore(1);

        MyThread mtA = new MyThread(sem, "A");
        MyThread mtB = new MyThread(sem, "B");

        mtA.start();
        mtB.start();

        mtA.join();
        mtB.join();

        System.out.println("Contador final: "+ Shared.count);

    }
}
