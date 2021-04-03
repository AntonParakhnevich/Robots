package Home;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by .
 */
public class TestHours extends TestCase {
    public static void testCalculateTimeFirstType() {
        Student student = new Student(new FirstType());
        double time = 22 / student.getTalent() * 3;
        Assert.assertEquals(time, student.calculateTime(22), 0.01);
    }

    public static void testCalculateTimeSecondType() {
        Student student = new Student(new SecondType());
        double time = 22 / student.getTalent() * 3 * 2;
        Assert.assertEquals(time, student.calculateTime(22), 0.01);
    }

    public static void testCalculateTimeThirdType() {
        Student student = new Student(new ThirdType());
        double time = 22 / student.getTalent() * 3 * 3;
        Assert.assertEquals(time, student.calculateTime(22), 0.1);
    }
}
