package DateConversion.naztech2;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ConversionTest {

	@Test
	public void caldateTolocalDatetest() {
		Calendar cal = Calendar.getInstance();
		cal.set(2022, Calendar.FEBRUARY + 1, 16);
		LocalDate a = Conversion.convertCalanderToLocalDate(cal);
		assertEquals(LocalDate.of(2022, Month.FEBRUARY, 16), a);
	}

	@Test
	public void calTimetoLocalTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 3);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.SECOND, 50);
		LocalTime a = Conversion.convertCalanderTimeToLocalTime(cal);
		assertEquals(LocalTime.of(3, 30, 50), a);

	}

	@Test
	public void caldateTimeTolocalDateTimetest() {
		Calendar cal = Calendar.getInstance();
		cal.set(2022, Calendar.FEBRUARY + 1, 16);
		cal.set(Calendar.HOUR, 3);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.SECOND, 50);
		assertEquals(LocalDateTime.of(2022, Month.FEBRUARY, 16, 3, 30, 50),
				Conversion.convertCalanderToLocalDateTime(cal));
	}

	@Test
	public void dateToLocalDate() throws ParseException {
		String dateValue = "Fri, 20 sep, 2013 23:37:50";
		SimpleDateFormat sdf = new SimpleDateFormat("E,dd MMM, yyyy HH:mm:ss");
		Date date = sdf.parse(dateValue);
		assertEquals(LocalDate.of(2013, Month.SEPTEMBER, 20), Conversion.convertDateToLocalDate(date));
		;

	}

	@Test
	public void timeToLocalTime() throws ParseException {
		String timeValue = "Fri, 20 sep, 2013 23:37:50";
		SimpleDateFormat sdf = new SimpleDateFormat("E,dd MMM, yyyy HH:mm:ss");
		Date time = sdf.parse(timeValue);
		assertEquals(LocalTime.of(23, 37, 50), Conversion.convertTimeToLocalTime(time));
		;

	}

	@Test
	public void localDateToDate() throws ParseException {
		LocalDate dateV = LocalDate.of(2013, Month.SEPTEMBER, 20);
		String dateValue = "Fri, 20 sep, 2013 23:37:50";
		SimpleDateFormat sdf = new SimpleDateFormat("E,dd MMM, yyyy");
		Date date = sdf.parse(dateValue);
		assertEquals(date, Conversion.convertLocalDateToDate(dateV));

	}
	
	@Test
	public void DateToOffsetDate()
	{
		Calendar cal = Calendar.getInstance();
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(1, 30);
		OffsetDateTime dateTime1=OffsetDateTime.of(LocalDateTime.of(2019, 01, 12, 05, 45),
				ZoneOffset.ofHoursMinutes(6, 30));
		
		
	}

	@Test
	public void offsetDateTimeToInstant() {
		OffsetDateTime offsetDateTime = OffsetDateTime.of(2014, 12, 03, 10, 15, 30, 0, ZoneOffset.ofHours(+6));
		assertEquals(Instant.parse("2014-12-03T04:15:30.00Z"), Conversion.convertOffsetDateToInstant(offsetDateTime));

	}

	@Test
	public void offsetDateTimeToLocalDate() {
		OffsetDateTime offsetDateTime = OffsetDateTime.of(2014, 12, 03, 10, 15, 30, 0, ZoneOffset.ofHours(+6));
		assertEquals(LocalDate.of(2014, 12, 03), Conversion.convertOffsetDateToLocalDate(offsetDateTime));
	}

	@Test
	public void offsetDateTimeToLocalDateTime() {
		OffsetDateTime offsetDateTime = OffsetDateTime.of(2014, 12, 03, 10, 15, 30, 0, ZoneOffset.ofHours(+6));
		assertEquals(LocalDateTime.of(2014, 12, 3, 10, 15, 30),
				Conversion.convertOffsetDateToLocalDateTime(offsetDateTime));

	}

	@Test
	public void offsetDateTimeToLocalTime() {
		OffsetDateTime offsetDateTime = OffsetDateTime.of(2014, 12, 03, 10, 15, 30, 0, ZoneOffset.ofHours(+6));
		assertEquals(LocalTime.of(10, 15, 30), Conversion.convertOffsetDateToLocalTime(offsetDateTime));

	}

	@Test
	public void offsetDateTimeToOffsetTime() {
		OffsetDateTime offsetDateTime = OffsetDateTime.of(2014, 12, 03, 10, 15, 30, 0, ZoneOffset.ofHours(+6));

		assertEquals(OffsetTime.of(10, 15, 30, 0, ZoneOffset.ofHours(6)),
				Conversion.convertOffsetDateToOffsetTime(offsetDateTime));
//		OffsetDate date = LocalDate.of(2014, 12, 3)
//		System.out.println("instant = " + date);
	}

	@Test
	public void localDateTimeToOffsetDateTime() {
		LocalDateTime date = LocalDateTime.of(2014, 12, 3, 10, 15, 30);
		assertEquals(OffsetDateTime.of(2014, 12, 03, 10, 15, 30, 0, ZoneOffset.ofHours(+6)),
				Conversion.convertLocalDateTimeToOffsetDateTime(date));

	}

}
