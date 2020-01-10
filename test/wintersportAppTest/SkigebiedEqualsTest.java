package wintersportAppTest;

import be.pxl.je.wintersport.Land;
import be.pxl.je.wintersport.Skigebied;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SkigebiedEqualsTest {

	@Test
	public void tweeSkigebiedenZijnGelijkIndienNaamEnLandGelijk() {
		Skigebied skigebied = new Skigebied("Les Deux Alpes", Land.FRANKRIJK);
		Skigebied skigebied2 = new Skigebied("Les Deux Alpes", Land.FRANKRIJK);
		assertEquals(skigebied, skigebied2);
	}

	@Test
	public void tweeSkigebiedenZijnVerschillendIndienNaamVerschillend() {
		Skigebied skigebied = new Skigebied("Les Deux Alpes", Land.FRANKRIJK);
		Skigebied skigebied2 = new Skigebied("Les Trois Alpes", Land.FRANKRIJK);
		assertNotEquals(skigebied, skigebied2);
	}

	@Test
	public void tweeSkigebiedenZijnVerschillendIndienLandVerschillend() {
		Skigebied skigebied = new Skigebied("Les Deux Alpes", Land.FRANKRIJK);
		Skigebied skigebied2 = new Skigebied("Les Deux Alpes", Land.OOSTENRIJK);
		assertNotEquals(skigebied, skigebied2);
	}
}
