package Reverse;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    @Test
    public void reverse() {

        ReverseString re = new ReverseString();
        assertEquals("A",re.reverse("A"));


    }
    @Test
    public void reverse2(){

        ReverseString re = new ReverseString();
        assertEquals("AB",re.reverse("BA"));


    }
}


//    ReverseString re = new ReverseString();
//       //assertEquals("AB",re.reverse("BA"));
//       assertEquals("CBA",re.reverse("ABC"));