package DateConversion.naztech2;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Conversion {
	Date date;

	
	
	public static LocalTime convertCalanderTimeToLocalTime(Calendar cal)
	{
		
		return LocalTime.of(cal.get(Calendar.HOUR),
				cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND));
		
		
	}

	public static LocalDate convertCalanderToLocalDate(Calendar cal) {
		return LocalDate.of(cal.get(Calendar.YEAR),
		        cal.get(Calendar.MONTH),
		        cal.get(Calendar.DAY_OF_MONTH));
		
		
	}
	
	public static LocalDateTime convertCalanderToLocalDateTime(Calendar cal) {
		return LocalDateTime.of(cal.get(Calendar.YEAR),
		        cal.get(Calendar.MONTH),
		        cal.get(Calendar.DAY_OF_MONTH),
		        cal.get(Calendar.HOUR),
		        cal.get(Calendar.MINUTE),
		        cal.get(Calendar.SECOND));
		
	}
	public static LocalDate convertDateToLocalDate(Date date)
	{
		
		return date.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
		
	}
	
	public static LocalTime convertTimeToLocalTime(Date time) {
	    return Instant.ofEpochMilli(time.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalTime();
	}
	
	public static Date convertLocalDateToDate(LocalDate date)
	{
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static Instant convertOffsetDateToInstant(OffsetDateTime offsetDateTime)
	{
		return offsetDateTime.toInstant();
	}
	
	public static LocalDate convertOffsetDateToLocalDate(OffsetDateTime offsetDateTime)
	{
		return offsetDateTime.toLocalDate();
	}
	
	public static LocalDateTime convertOffsetDateToLocalDateTime(OffsetDateTime offsetDateTime)
	{
		return offsetDateTime.toLocalDateTime();
	}
	
	public static LocalTime convertOffsetDateToLocalTime(OffsetDateTime offsetDateTime)
	{
		return offsetDateTime.toLocalTime();
	}
	
	public static OffsetTime convertOffsetDateToOffsetTime(OffsetDateTime offsetDateTime)
	{
		return offsetDateTime.toOffsetTime();
	}
	public static OffsetDateTime convertLocalDateTimeToOffsetDateTime(LocalDateTime date) {
		return date.atOffset(ZoneOffset.ofHours(6));
		
	}
	
	public static OffsetDateTime  convertLocalDateToOffsetDate(LocalDateTime ldt)
	{
		return OffsetDateTime.of(ldt, ZoneOffset.UTC);
	}
	
	
	
	

}
