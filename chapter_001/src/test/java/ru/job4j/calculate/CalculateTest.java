package ru.job4j.calculate;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
*
* @author Oleg Korneev
* @version $Id$
* @since 2018
*/

public class CalculateTest {
    /**
    * Test echo.
    */ 
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Oleg Korneev";
        String expect = "Echo, echo, echo: Oleg Korneev";

        Calculate calc = new Calculate();
    
        String result = calc.echo(input);
    
        assertThat(result, is(expect));
    } 
}