package HomeTask.Task70.Robots;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Fabrika implements Runnable {
    private List<String> detailsOfFabrika=new ArrayList<>();
    private List<String> details;
    private Random random=new Random();
    private CyclicBarrier cyclicBarrier;

    public Fabrika(List<String> details,CyclicBarrier cyclicBarrier) {
        this.details = details;
        this.cyclicBarrier=cyclicBarrier;
    }
    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        synchronized (getDetailsOfFabrika()){
            int count=random.nextInt(4)+1;
            for (int i = 0; i <count ; i++) {
                detailsOfFabrika.add(details.get(random.nextInt(details.size())));
            }
            System.out.println("Выброшено "+count+" деталей.");
            System.out.println("На свалке "+detailsOfFabrika.size()+ " деталей");

        }
    }

    public List<String> getDetailsOfFabrika() {
        return detailsOfFabrika;
    }

    public void deleteDetal(String detail) {
        detailsOfFabrika.remove(detail);
    }

    public void addDetalOfFabrika(String detal){
        detailsOfFabrika.add(detal);
    }
}
