package com.rai4u.sign;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by user on 15.09.2017.
 */


public enum Operation {
    SUM(Arrays.stream(OperationConstants.SUM_ALIASES).collect(Collectors.toSet()), OperationConstants::sumAction),
    SUB(Arrays.stream(OperationConstants.SUB_ALIASES).collect(Collectors.toSet()), OperationConstants::subAction),
    DIV(Arrays.stream(OperationConstants.DIV_ALIASES).collect(Collectors.toSet()), OperationConstants::divAction),
    MULT(Arrays.stream(OperationConstants.MULT_ALIASES).collect(Collectors.toSet()), OperationConstants::multAction);


    private Set<String> aliases;

    private BiFunction<BigDecimal, BigDecimal, BigDecimal> action;

    Operation(Set<String> aliases, BiFunction<BigDecimal, BigDecimal, BigDecimal> action) {
        this.aliases = aliases;
        this.action = action;
    }

    public static Operation get(String sign) {
        return Arrays.stream(values())
                .filter(s -> isContainsAlias(sign, s))
                .findFirst()
                .orElse(null);
    }

    private static boolean isContainsAlias(String sign, Operation s) {
        return s.aliases.stream()
                .anyMatch(alias -> alias.equalsIgnoreCase(sign));
    }

    public BigDecimal calculate(BigDecimal left, BigDecimal right) {
        return action.apply(left, right);
    }
}


