package com.rai4u.sign;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by user on 15.09.2017.
 */
public class OperationTest {
    @Test
    public void shouldReturnSign_whenCallingGet_andNameIsOk() {
        Operation expected = Operation.SUM;

        Operation actual = Operation.get("+");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSign_whenCallingGet_andNameDoNotMatchInCase() {
        Operation expected = Operation.DIV;

        Operation actual = Operation.get("dIvIde");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNull_whenCallingGet_andNameIsWrong() {
        Operation actual = Operation.get("WrongName");

        assertNull(actual);
    }

    @Test
    public void shouldSum_whenCallingCalculate_andSignIsSum() {
        BigDecimal expected = new BigDecimal(5);

        BigDecimal actual = Operation.SUM.calculate(new BigDecimal(2), new BigDecimal(3));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSubtract_whenCallingCalculate_andSignIsSub() {
        BigDecimal expected = new BigDecimal(1);

        BigDecimal actual = Operation.SUB.calculate(new BigDecimal(3), new BigDecimal(2));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDivide_whenCallingCalculate_andSignIsDiv() {
        BigDecimal expected = new BigDecimal(2);

        BigDecimal actual = Operation.DIV.calculate(new BigDecimal(6), new BigDecimal(3));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMaxValueOfLong_whenCallingCalculate_andSignIsDiv_andDividerIsZero() {
        BigDecimal expected = new BigDecimal(Long.MAX_VALUE);

        BigDecimal actual = Operation.DIV.calculate(new BigDecimal(6), new BigDecimal(0));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldMultiply_whenCallingCalculate_andSignIsMult() {
        BigDecimal expected = new BigDecimal(6);

        BigDecimal actual = Operation.MULT.calculate(new BigDecimal(2), new BigDecimal(3));

        assertEquals(expected, actual);
    }
}