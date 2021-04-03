package HomeTask.Task70.Robots;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class Assistent implements Callable {
    private String name;
    private List<String> details = new ArrayList<>();
    private Fabrika fabrika;
    private Random random = new Random();
    private CyclicBarrier cyclicBarrier;

    public Assistent(Fabrika fabrika, String name, CyclicBarrier cyclicBarrier) {
        this.fabrika = fabrika;
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    public List<String> getDetails() {
        return details;
    }


    @Override
    public List<String> call() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        synchronized (fabrika.getDetailsOfFabrika()) {
            int count = random.nextInt(4) + 1;
            details.clear();
            if (fabrika.getDetailsOfFabrika().isEmpty()) {
                System.out.println("Помощник " + name + " уходит ни с чем");
            } else {
                for (int i = 0; i < count; i++) {
                    String detail = fabrika.getDetailsOfFabrika().get(random.nextInt(fabrika.getDetailsOfFabrika().size()));
                    details.add(detail);
                    fabrika.deleteDetal(detail);
                    if (fabrika.getDetailsOfFabrika().isEmpty()) {
                        break;
                    }
                }
                System.out.println("Помощник " + name + " взял :: " + details);
            }
        }

        return details;
    }
}
