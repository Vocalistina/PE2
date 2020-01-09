package be.pxl.je.wintersport;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WintersportApp {

	public static void main(String[] args) {
		Skigebied deuxAlpes = new Skigebied("Les Deux Alpes", Land.FRANKRIJK);
		Skigebied mayerhofen = new Skigebied("Mayrhofen", Land.OOSTENRIJK);

		Gondelbaan penkenbahn = new Gondelbaan("Penkenbahn", new Skigebied("Mayrhofen", Land.OOSTENRIJK));

		Dagpas dagpas = new Dagpas(deuxAlpes, LocalDateTime.of(2020, 1, 28, 12, 15), true);
		Meerdagenpas meerdagenpas = new Meerdagenpas(mayerhofen, LocalDate.of(2020, 2, 27), 4, false);
		System.out.println(dagpas);
		System.out.println();
		System.out.println(meerdagenpas);
		System.out.println();

		System.out.println("Dagpas geldig: " + penkenbahn.controleerToegang(dagpas, LocalDateTime.of(2020, 1, 28, 14, 32)));
		System.out.println("Meerdagenpas geldig: " + penkenbahn.controleerToegang(meerdagenpas, LocalDateTime.of(2020, 2, 28, 15, 47)));
	}

}
