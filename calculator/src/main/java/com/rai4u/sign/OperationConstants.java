package com.rai4u.sign;

import java.math.BigDecimal;
import java.util.function.BiFunction;

/**
 * Created by user on 15.09.2017.
 */
public class OperationConstants {
    public static final String[] SUM_ALIASES = new String[]{"+", "Plus"};
    public static final String[] SUB_ALIASES = new String[]{"-", "Minus"};
    public static final String[] DIV_ALIASES = new String[]{":", "Divide"};
    public static final String[] MULT_ALIASES = new String[]{"*", "Multiply"};

    private OperationConstants() {
    }

    static BigDecimal sumAction(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }

    static BigDecimal subAction(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    static BigDecimal divAction(BigDecimal left, BigDecimal right) {
        if(BigDecimal.ZERO.equals(right)){
            return BigDecimal.valueOf(Long.MAX_VALUE);
        }
        return left.divide(right);
    }

    static BigDecimal multAction(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }


}
