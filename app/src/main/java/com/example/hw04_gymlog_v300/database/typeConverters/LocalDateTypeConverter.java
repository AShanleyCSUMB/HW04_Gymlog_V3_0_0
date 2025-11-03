package com.example.gymlog.database.typeConverters;

import android.os.Build;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class LocalDateTypeConverter {
    @TypeConverter
    public long convertDateToLong(LocalDateTime date){
        ZonedDateTime zdt = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            zdt = ZonedDateTime.of(date, ZoneId.systemDefault());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return zdt.toInstant().toEpochMilli();
        }
        return 0;
    }

    @TypeConverter
    public  LocalDateTime convertLongToDate (Long epochMilli){
        Instant instant = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            instant = Instant.ofEpochMilli(epochMilli);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        }
        return null;
    }
}
