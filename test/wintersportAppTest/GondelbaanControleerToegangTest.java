package wintersportAppTest;

import be.pxl.je.wintersport.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GondelbaanControleerToegangTest {
	private Skigebied skigebied;
	private Skigebied anderSkigebied;
	private Gondelbaan gondelbaan;
	private LocalDateTime datum;

	@Before
	public void init() {
		skigebied = new Skigebied("Wit skigebied", Land.ZWITSERLAND);
		anderSkigebied = new Skigebied("Groen skigebied", Land.ZWITSERLAND);
		gondelbaan = new Gondelbaan("Lange baan", skigebied);
		datum = LocalDateTime.of(2020, 1, 15, 14, 00);
	}

	@Test
	public void geenToegangIndienSkipasNietGeldigVoorSkigebied() {
		Skipas skipas = new Dagpas(anderSkigebied, datum, false);
		assertFalse(gondelbaan.controleerToegang(skipas, datum.plusMinutes(120)));
	}

	@Test
	public void geenToegangIndienSkipasNietGeldigOpDatum() {
		Skipas skipas = new Dagpas(skigebied, datum, false);
		assertFalse(gondelbaan.controleerToegang(skipas, datum.plusDays(2)));
	}

	@Test
	public void toegangIndienSkipasGeldigOpDatumEnVoorSkigebied() {
		Skipas skipas = new Dagpas(skigebied, datum, false);
		assertTrue(gondelbaan.controleerToegang(skipas, datum.plusMinutes(120)));
	}
}
