package ua.google.team.hashcode.commons;

import ua.google.team.hashcode.model.Endpoint;
import ua.google.team.hashcode.model.Video;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

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

    public static BigDecimal of(Long videoId, Long serverId, Endpoint... endpoints) {
        return Arrays.stream(endpoints)
                .map(e -> {
                    Optional<Video> video = e.getVideoRequests()
                            .keySet()
                            .stream()
                            .filter(v -> v.getId() == videoId)
                            .findFirst();

                    return of(e.getGlobalLatency(),
                            e.getServerLatency()
                                    .keySet()
                                    .stream()
                                    .filter(s -> s.getId() == serverId)
                                    .findFirst()
                                    .map(s -> e.getServerLatency().get(s))
                                    .orElse(0L),
                            video.map(v -> e.getVideoRequests().get(v)).orElse(0L),
                            video.map(Video::getSize).orElse(1L)
                    );
                }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}