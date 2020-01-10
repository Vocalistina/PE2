package wintersportAppTest;

import be.pxl.je.wintersport.Dagpas;
import be.pxl.je.wintersport.Land;
import be.pxl.je.wintersport.Skigebied;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DagpasIsGeldigTest {
	private Dagpas dagpas;
	private LocalDate dag;
	private LocalTime startuur;

	@Before
	public void init() {
		Skigebied skigebied = new Skigebied("Test", Land.FRANKRIJK);
		dag = LocalDate.now();
		startuur = LocalTime.of(8, 30);
		dagpas = new Dagpas(skigebied, LocalDateTime.of(dag, startuur), false);
	}

	@Test
	public void dagpasIsNietGeldigVoorStartuur() {
		assertFalse(dagpas.isGeldig(LocalDateTime.of(dag, startuur.minusMinutes(1))));
	}

	@Test
	public void dagpasIsGeldigOpStartuur() {
		assertTrue(dagpas.isGeldig(LocalDateTime.of(dag, startuur)));
	}

	@Test
	public void dagpasIsGeldigOpZelfdeDagNaStartuur() {
		assertTrue(dagpas.isGeldig(LocalDateTime.of(dag, startuur.plusMinutes(135))));;
	}

	@Test
	public void dagpasIsNietGeldigOpAndereDag() {
		assertFalse(dagpas.isGeldig(LocalDateTime.of(dag.plusDays(1), startuur)));
		assertFalse(dagpas.isGeldig(LocalDateTime.of(dag.minusDays(1), startuur)));
	}
}
