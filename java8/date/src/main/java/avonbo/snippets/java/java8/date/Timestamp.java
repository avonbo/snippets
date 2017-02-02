package avonbo.snippets.java.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Timestamp {

	public void getTimestamp(){
		final Clock clock = Clock.systemDefaultZone();
		final Instant localTime = clock.instant();
		// legacy
		final java.util.Date legacyDate = 	java.util.Date.from(localTime);
		System.out.println(legacyDate);

		final ZoneId berlinZone = ZoneId.of("Europe/Berlin");
		final ZoneId newYorkZone = ZoneId.of("America/New_York");
		final ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");

		final LocalTime nowBerlin = LocalTime.now(berlinZone);
		final LocalTime nowNewYork = LocalTime.now(newYorkZone);
		final LocalTime nowTokyo = LocalTime.now(tokyoZone);

		final long hoursBetweenBandNY = ChronoUnit.HOURS.between(nowBerlin, nowNewYork);
		System.out.println(hoursBetweenBandNY + " Hours between Berlin and New York");
		final long hoursBetweenBandT = ChronoUnit.HOURS.between(nowBerlin, nowTokyo);
		System.out.println(hoursBetweenBandT + " Hours between Berlin and Tokyo");

		System.out.println(localTime.atZone(newYorkZone));

		final LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		final Instant sylvesterTokio = sylvester
				.atZone(tokyoZone)
				.toInstant();

		System.out.println(sylvester + "" + sylvesterTokio);


	}


}
