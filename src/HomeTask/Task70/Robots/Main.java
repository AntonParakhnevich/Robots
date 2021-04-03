package HomeTask.Task70.Robots;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static final List<String> DETALS = Arrays.asList("HDD", "Left hand", "Rightr hand", "Head", "CRM");

    public static void main(String[] args) {
        Random random = new Random();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Fabrika fabrika = new Fabrika(DETALS, cyclicBarrier);
        Doc firstDoctor = new Doc();
        Doc secondDoctor = new Doc();

        Assistent firstAssistent = new Assistent(fabrika, "First", cyclicBarrier);
        Assistent secondAssistent = new Assistent(fabrika, "Second", cyclicBarrier);

        for (int i = 0; i < 20; i++) {
            fabrika.addDetalOfFabrika(DETALS.get(random.nextInt(DETALS.size())));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i < 100; i++) {
            System.out.println("Next night");

            executorService.submit(fabrika);
            executorService.submit(firstAssistent);
            executorService.submit(secondAssistent);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            firstDoctor.setDetails(firstAssistent.getDetails());
            secondDoctor.setDetails(secondAssistent.getDetails());
        }
        executorService.shutdown();

        firstDoctor.counts(DETALS);
        secondDoctor.counts(DETALS);

        result(firstDoctor.getCountOfRobots(), secondDoctor.getCountOfRobots());

    }

    public static void result(int firstCountOfRobots, int secondCountOfRobots) {
        System.out.println("Первый доктор  :: " + firstCountOfRobots);
        System.out.println("Второй доктор :: " + secondCountOfRobots);

        if (firstCountOfRobots > secondCountOfRobots) {
            System.out.println("Победил первый доктор");
        } else if (secondCountOfRobots > firstCountOfRobots) {
            System.out.println("Победил второй доктор");
        } else System.out.println("Ничья");
    }
}
