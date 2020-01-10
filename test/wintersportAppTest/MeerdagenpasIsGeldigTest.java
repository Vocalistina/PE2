package wintersportAppTest;

import be.pxl.je.wintersport.Land;
import be.pxl.je.wintersport.Meerdagenpas;
import be.pxl.je.wintersport.Skigebied;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MeerdagenpasIsGeldigTest {
	private Meerdagenpas meerdagenpas;
	private LocalDate dag;

	@Before
	public void init() {
		Skigebied skigebied = new Skigebied("Test", Land.FRANKRIJK);
		dag = LocalDate.now();
		meerdagenpas = new Meerdagenpas(skigebied, dag, 3, false);
	}

	@Test
	public void dagpasIsNietGeldigVoorStartdag() {
		assertFalse(meerdagenpas.isGeldig(LocalDateTime.of(dag.minusDays(1), LocalTime.NOON)));
	}

	@Test
	public void dagpasIsGeldigVanafStartdagMiddernacht() {
		assertTrue(meerdagenpas.isGeldig(LocalDateTime.of(dag, LocalTime.MIDNIGHT)));
	}

	@Test
	public void dagpasIsGeldigTijdensPeriode() {
		assertTrue(meerdagenpas.isGeldig(LocalDateTime.of(dag.plusDays(2), LocalTime.NOON)));
		assertTrue(meerdagenpas.isGeldig(LocalDateTime.of(dag.plusDays(2), LocalTime.MAX)));
	}

	@Test
	public void meerdagenpasIsNietMeerGeldigNa3Dagen() {
		assertFalse(meerdagenpas.isGeldig(LocalDateTime.of(dag.plusDays(3), LocalTime.MIDNIGHT)));
	}
}
