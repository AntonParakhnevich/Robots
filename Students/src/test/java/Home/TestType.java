package Home;

import junit.framework.TestCase;

/**
 * Created by .
 */
public class TestType extends TestCase {
    public void testFirstType() {
        Masterable student = StudentFactory.createStudent(Type.FIRST);
        assertTrue(student instanceof FirstType);
    }

    public void testSecondType(){
        Masterable student = StudentFactory.createStudent(Type.SECOND);
        assertTrue(student instanceof SecondType);
    }

    public void testThirdType(){
        Masterable student = StudentFactory.createStudent(Type.THIRD);
        assertTrue(student instanceof ThirdType);
    }
}
