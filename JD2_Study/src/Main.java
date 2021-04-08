import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by .
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("group.txt");

        List<Person> group = generateGroup();
        Set<Person> sortGroup = deleteDoublePerson(group);

        deleteAge21(sortGroup);

        writeInFile(sortGroup, file);

        List<Person> groupWithFile = readObjectInFile(file);
        List<String> people = readNameAndSurname(file);

        System.out.println(groupWithFile);

        for (String s : people) {
            System.out.println(s);
        }
    }

    private static Set<Person> deleteDoublePerson(List<Person> group) {
        return group.stream()
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static void writeInFile(Set<Person> group, File file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Person p : group) {
                objectOutputStream.writeObject(p);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Person> readObjectInFile(File file) {
        ArrayList<Person> people = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (objectInputStream.available() > -1) {
                people.add((Person) objectInputStream.readObject());

            }

        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return people;
    }

    private static List<String> readNameAndSurname(File file) {
        ArrayList<String> strings = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (objectInputStream.available() > -1) {
                Person p = (Person) objectInputStream.readObject();
                strings.add("Name: " + p.getName() + " Lastname: " + p.getLastName());
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static List<Person> generateGroup() {
        Random random = new Random();
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            people.add(new Person(random.nextInt(20), random.nextInt(50), random.nextInt(15) + 15));
        }
        return people;
    }

    public static Set<Person> deleteAge21(Set<Person> group) {
        group.removeIf(p -> p.getAge() > 21);
        return group;
    }
}
