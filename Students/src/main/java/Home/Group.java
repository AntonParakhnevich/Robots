package Home;

/**
 * Created by .
 */
public class Group {
    private final int TIME = 66;
    private Student[] students;

    public Group(Masterable[] masterables) {
        students = new Student[masterables.length];
        for (int i = 0; i < masterables.length; i++) {
            students[i] = new Student(masterables[i]);
        }
    }

    public void calculate() {
        for (Student student : students) {
            student.calculateTime(TIME);
        }
    }

    public void print() {
        for (Student student : students) {
            student.print();
        }
    }
}
