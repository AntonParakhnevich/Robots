package HomeTask.Task70.Robots;

import java.util.ArrayList;
import java.util.List;

public class Doc {
    private List<String> details=new ArrayList<>();
    private int countOfRobots=0;


    public void setDetails(List<String> details) {
        this.details.addAll(details);
    }

    public int getCountOfRobots() {
        return countOfRobots;
    }

    public void counts(List<String> detailsOfRobot){
        int count=0;
        while (details.containsAll(detailsOfRobot)){
            count++;
            for (String detail:detailsOfRobot){
                details.remove(detail);
            }
        }
        countOfRobots=count;
//        return count;
    }
}
