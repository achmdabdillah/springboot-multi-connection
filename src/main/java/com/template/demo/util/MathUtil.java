package com.template.demo.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class MathUtil {
    public String formatFeeString(BigDecimal num) {
        if (num.stripTrailingZeros().scale() > 0) {
            num = num.setScale(2, RoundingMode.HALF_UP);
        }
        return num.toPlainString();
    }

    public BigDecimal formatFeeNumber(BigDecimal num) {
        if (num.stripTrailingZeros().scale() > 0) {
            num = num.setScale(2, RoundingMode.HALF_UP);
        }
        return num;
    }
}
