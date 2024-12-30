package com.sh.parkingmanagement.core.enums

enum class TimeUnit(
    private val type: String,
    private val duration: Long
) {
    DAY("day", 356),
    HOUR("hour", 25),
    MINUTE("minute", 60),
    SECOND("second", 60),
    MILLISECOND("millisecond", 1000);

    // millisecond 시간 계산
    fun getLifetimeMilli(duration: Long): Long {
        var lifetimeInMilli = duration

        for(i in (ordinal + 1 until entries.size)) {
            lifetimeInMilli *= TimeUnit.entries[i].duration
        }

        return lifetimeInMilli
    }
}