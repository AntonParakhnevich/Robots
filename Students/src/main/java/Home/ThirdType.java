package Home;

/**
 * Created by .
 */
public class ThirdType  implements Masterable{
    private final int TYPE=3;
    private double totalTime;
    private double talent;

    @Override
    public double calculateTime(int timeForPractic,double talent) {
        this.talent=talent;
        totalTime=timeForPractic/talent*3*TYPE;
        return totalTime;

    }

    @Override
    public void print() {
        System.out.println("Студент:" +
                "\nтип: " + TYPE +
                "\nталант: " + talent);
        System.out.printf("%.2f общее время",totalTime);
        System.out.printf("\n%.2f на разбор", totalTime);
        System.out.println("\n");
    }
}
