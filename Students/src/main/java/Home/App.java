package Home;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Group group = new Group(generateGroup());
        group.calculate();
        group.print();
    }

    public static Masterable[] generateGroup(){
        Masterable[] masterables = new Masterable[9];

        for (int i = 0; i <3; i++) {
            masterables[i]= StudentFactory.createStudent(Type.FIRST);
        }
        for (int i = 3; i <6; i++) {
            masterables[i]= StudentFactory.createStudent(Type.SECOND);
        }
        for (int i = 6; i <9; i++) {
            masterables[i]= StudentFactory.createStudent(Type.THIRD);
        }
        return masterables;
    }


}
