package ua.google.team.hashcode.commons;

import java.math.BigDecimal;

public final class ScoreCalculator {
    private ScoreCalculator() {
    }

    public static BigDecimal of(Long globalLatency, Long localLatency, Long requestsCount, Long fileSize) {
        return BigDecimal.valueOf(globalLatency)
                .subtract(BigDecimal.valueOf(localLatency))
                .multiply(BigDecimal.valueOf(requestsCount))
                .divide(BigDecimal.valueOf(fileSize), BigDecimal.ROUND_UNNECESSARY);
    }
}