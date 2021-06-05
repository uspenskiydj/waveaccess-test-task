package com.waveaccess.waveaccesstesttask.util;

import java.time.LocalDateTime;

public class DateTimeUtil {

    public static boolean isNotOverlapping(LocalDateTime firstStart, LocalDateTime firstEnd, LocalDateTime secondStart, LocalDateTime secondEnd) {
        return (firstStart.isBefore(secondStart) && firstEnd.isBefore(secondStart)) || (firstStart.isAfter(secondEnd) && firstEnd.isAfter(secondEnd));
    }

    public static String toSimpleString(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate() + " " + localDateTime.toLocalTime();
    }
}
