package TDD;

import static org.junit.Assert.*;

public class ReverseTest {

    @org.junit.Test
    public void reverse() {

        Reverse re = new Reverse();
        assertEquals("AB",re.reverse("BA"));

    }
}