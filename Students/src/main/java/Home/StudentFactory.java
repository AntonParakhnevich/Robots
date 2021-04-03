package Home;


/**
 * Created by .
 */
public class StudentFactory {

    public static Masterable createStudent(Type type) {
        Masterable masterable=null;
        switch (type) {
            case FIRST:
                masterable = new FirstType();
                break;
            case SECOND:
                masterable = new SecondType();
                break;
            case THIRD:
                masterable = new ThirdType();
                break;
        }
        return masterable;
    }
}
