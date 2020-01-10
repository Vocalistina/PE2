package wintersportAppTest;

import be.pxl.je.wintersport.Land;
import be.pxl.je.wintersport.Meerdagenpas;
import be.pxl.je.wintersport.Skigebied;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class MeerdagenpasGetPrijsTest {
	private Meerdagenpas meerdagenpasKind;
	private Meerdagenpas meerdagenpasVolwassene;

	@Before
	public void init() {
		Skigebied skigebied = new Skigebied("Test", Land.FRANKRIJK);
		meerdagenpasKind = new Meerdagenpas(skigebied, LocalDate.now(), 4, true);
		meerdagenpasVolwassene = new Meerdagenpas(skigebied, LocalDate.now(), 3, false);
	}

	@Test
	public void meerdagenpasVolwasseneBasisPrijsPerDag() {
		assertEquals(Land.FRANKRIJK.getBasisprijs() * 3, meerdagenpasVolwassene.getPrijs(), 0.0);
	}

	@Test
	public void meerdagenpasKindMetKorting() {
		assertEquals(0.75 * Land.FRANKRIJK.getBasisprijs() * 4, meerdagenpasKind.getPrijs(), 0.0);
	}
}
