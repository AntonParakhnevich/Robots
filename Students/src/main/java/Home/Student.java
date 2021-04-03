package Home;

/**
 * Created by .
 */
public class Student {
    private Masterable masterable;
    private double talent;

    public double getTalent() {
        return talent;
    }

    public Student(Masterable masterable) {
        this.masterable = masterable;
        talent = (double) ((int) (Math.random() * 10 + 1)) / 10;
    }

    public double calculateTime(int timeForPractic){
        return masterable.calculateTime(timeForPractic,talent);
    }

    public void print(){
        masterable.print();
    }
}
