import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    @Test
    public void konstuktorTest() {
        Person p1 = new Person("Max", "Mustermann");
        assert p1.getVorname().equals("Max");
        assert p1.getNachname().equals("Mustermann");
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestVornameLeer() throws IllegalArgumentException{
        Person p1 = new Person("", "Mustermann");
    }
    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestNachnameLeer() throws IllegalArgumentException{
        Person p1 = new Person("Max", "");
    }

    @Test
    public void testEqualsTrue() {
        Person p1 = new Person ("Max", "Mustermann");
        Person p2 = new Person ("Max", "Mustermann");
        assertEquals(p1, p2);
    }
    @Test
    public void testEqualsFalse() {
        Person p1 = new Person ("Max", "Mustermann");
        Person p2 = new Person ("Max", "AndererMustermann");
        assertNotEquals(p1, p2);
    }

    @Test
    public void testToString() {
        Person p1 = new Person("Max", "Mustermann");
        String expected = "Max Mustermann";
        String actual = p1.toString();
        assertEquals(actual, expected);
    }

    @Test
    public void getVorname() {
        Person p1 = new Person("Max", "Mustermann");
        String expected = "Max";
        String actual = p1.getVorname();
        assertEquals(actual, expected);
    }

    @Test
    public void getNachname() {
        Person p1 = new Person("Max", "Mustermann");
        String expected = "Mustermann";
        String actual = p1.getNachname();
        assertEquals(actual, expected);
    }
}
