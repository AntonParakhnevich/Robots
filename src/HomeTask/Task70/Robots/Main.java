package HomeTask.Task70.Robots;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

public class Main {
    public static final List<String> DETALS = Arrays.asList("HDD", "Left hand", "Rightr hand", "Head", "CRM");

    public static void main(String[] args) {
        Random random = new Random();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Fabrika fabrika = new Fabrika( DETALS,cyclicBarrier);
        Doc firstDoctor = new Doc();
        Doc secondDoctor = new Doc();

        Assistent firstAssistent = new Assistent(fabrika, "First",cyclicBarrier);
        Assistent secondAssistent = new Assistent(fabrika, "Second",cyclicBarrier);

        for (int i = 0; i <20 ; i++) {
            fabrika.addDetalOfFabrika(DETALS.get(random.nextInt(DETALS.size())));
        }

        for (int i = 1; i < 100; i++) {
            System.out.println("Next night");
            FutureTask<List<String>> firstFuture = new FutureTask<List<String>>(firstAssistent);
            FutureTask<List<String>> secondFuture = new FutureTask<List<String>>(secondAssistent);

            Thread thread = new Thread(fabrika);
            Thread thread1 = new Thread(firstFuture);
            Thread thread2 = new Thread(secondFuture);

            thread.start();
            thread1.start();
            thread2.start();

            try {
                thread.join();
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            firstDoctor.setDetails(firstAssistent.getDetails());
            secondDoctor.setDetails(secondAssistent.getDetails());
        }

        firstDoctor.counts(DETALS);
        secondDoctor.counts(DETALS);

        result(firstDoctor.getCountOfRobots(),secondDoctor.getCountOfRobots());

    }

    public static void result(int firstCountOfRobots,int secondCountOfRobots){
        System.out.println("Первый доктор  :: "+firstCountOfRobots);
        System.out.println("Второй доктор :: "+secondCountOfRobots);

        if(firstCountOfRobots>secondCountOfRobots){
            System.out.println("Победил первый доктор");
        }else if(secondCountOfRobots>firstCountOfRobots){
            System.out.println("Победил второй доктор");
        }else System.out.println("Ничья");
    }
}
