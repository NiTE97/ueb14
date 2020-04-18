import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @org.junit.jupiter.api.Test
    void konstuktorTest() {
        Person p1 = new Person("Max", "Mustermann");
        assert p1.getVorname().equals("Max");
        assert p1.getNachname().equals("Mustermann");
    }

    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestVornameLeer() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person p1 = new Person("", "Mustermann");
        });
        String expectedMessage = "Name darf nicht leer sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestNachnameLeer() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person p1 = new Person("Max", "");
        });
        String expectedMessage = "Name darf nicht leer sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testEqualsTrue() {
        Person p1 = new Person ("Max", "Mustermann");
        Person p2 = new Person ("Max", "Mustermann");
        assertTrue(p1.equals(p2));
    }
    @Test
    void testEqualsFalse() {
        Person p1 = new Person ("Max", "Mustermann");
        Person p2 = new Person ("Max", "AndererMustermann");
        assertFalse(p1.equals(p2));
    }

    @Test
    void testToString() {
        Person p1 = new Person("Max", "Mustermann");
        String expected = "Max Mustermann";
        String actual = p1.toString();
        assertTrue(actual.equals(expected));
    }

    @Test
    void getVorname() {
        Person p1 = new Person("Max", "Mustermann");
        String expected = "Max";
        String actual = p1.getVorname();
        assertTrue(actual.equals(expected));
    }

    @Test
    void getNachname() {
        Person p1 = new Person("Max", "Mustermann");
        String expected = "Mustermann";
        String actual = p1.getNachname();
        assertTrue(actual.equals(expected));
    }
}