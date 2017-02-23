package ua.google.team.hashcode.commons;

import java.math.BigDecimal;

public final class ScoreCalculator {
    private ScoreCalculator() {
    }

    public static BigDecimal of(Long globalLatency, Long localLatency, Long requestsCount, Long fileSize) {

        BigDecimal glVsLocal = BigDecimal.valueOf(globalLatency)
                  .subtract(BigDecimal.valueOf(localLatency));

        if (glVsLocal.longValue() <= 0) // todo compare with 0? maybe with percent of global latency
            return new BigDecimal(0);

        return glVsLocal.multiply(BigDecimal.valueOf(requestsCount))
                .divide(BigDecimal.valueOf(fileSize), BigDecimal.ROUND_UNNECESSARY);
    }
}