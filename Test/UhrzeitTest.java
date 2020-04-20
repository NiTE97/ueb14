import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UhrzeitTest {

    @Test
    public void konstuktorTest(){
        Uhrzeit beginn = new Uhrzeit(13,30);
        assert beginn.getStunde() == 13;
        assert beginn.getMinute() == 30;
    }

    @Test
    public void konstuktorTestStundeNull(){
        Uhrzeit beginn = new Uhrzeit(0,30);
        assert beginn.getStunde() == 0;
        assert beginn.getMinute() == 30;
    }

    @Test
    public void konstuktorTestStundeVoll(){
        Uhrzeit beginn = new Uhrzeit(23,30);
        assert beginn.getStunde() == 23;
        assert beginn.getMinute() == 30;
    }

    @Test
    public void konstuktorTestMinuteNull(){
        Uhrzeit beginn = new Uhrzeit(10,0);
        assert beginn.getStunde() == 10;
        assert beginn.getMinute() == 0;
    }

    @Test
    public void konstuktorTestMinuteVoll(){
        Uhrzeit beginn = new Uhrzeit(10,59);
        assert beginn.getStunde() == 10;
        assert beginn.getMinute() == 59;
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestStundeNegativ() throws IllegalArgumentException{
        Uhrzeit beginn = new Uhrzeit(-1,30);
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestStundeZuVoll() throws IllegalArgumentException{
        Uhrzeit beginn = new Uhrzeit(24,30);
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestMinuteNegativ() throws IllegalArgumentException{
        Uhrzeit beginn = new Uhrzeit(13,-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestMinuteZuVoll() throws IllegalArgumentException{
        Uhrzeit beginn = new Uhrzeit(23,60);
    }

    @Test
    public void testEqualsTrueTest() {
        Uhrzeit beginn = new Uhrzeit(10,59);
        Uhrzeit ende = new Uhrzeit(10,59);
        assertEquals(beginn, ende);
    }

    @Test
    public void testEqualsFalseTest() {
        Uhrzeit beginn = new Uhrzeit(10,59);
        Uhrzeit ende = new Uhrzeit(11,59);
        assertNotEquals(beginn, ende);
    }

    @Test
    public void testToString() {
        Uhrzeit beginn = new Uhrzeit(10,59);
        String expected = "10:59 Uhr";
        String actual = beginn.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void getStunde() {
        Uhrzeit beginn = new Uhrzeit(10,59);
        int expected = 10;
        int actual = beginn.getStunde();
        assertEquals(expected, actual);
    }

    @Test
    public void getMinute() {
        Uhrzeit beginn = new Uhrzeit(10,59);
        int expected = 59;
        int actual = beginn.getMinute();
        assertEquals(expected, actual);
    }
}
