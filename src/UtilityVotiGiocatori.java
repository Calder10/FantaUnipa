import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class UtilityVotiGiocatori {

	private static String pathVotiGiornata1 = "src/Voti/votiPrimaGiornata.csv";
	private static String pathVotiGiornata2 = "src/Voti/votiSecondaGiornata.csv";
	private static String pathVotiGiornata3 = "src/Voti/votiTerzaGiornata.csv";
	private static String pathVotiGiornata4 = "src/Voti/votiQuartaGiornata.csv";
	private static String pathVotiGiornata5 = "src/Voti/votiQuintaGiornata.csv";

	public static double effettuaCambio(String tipo, ArrayList<String[]> giocatori, int numeroGiornata) {
		double voto = 0.0;
		List<String> punteggiRiserva = new ArrayList<>();
		switch (tipo) {
		case "P":
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(11)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				voto = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
			}
			break;
		case "D":
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(12)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				voto = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
			}
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(13)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				voto = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
			}
			break;
		case "C":
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(14)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				voto = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
			}
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(15)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				voto = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
			}
			break;
		case "A":
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(16)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				voto = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
			}
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(17)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				voto = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
			}
			break;
		default:
			System.out.println("Scelta non consnetita !");
		}
		return voto;
	}

	public static HashMap<String, Double> assegnaVoti(ArrayList<String[]> giocatori, int numeroGiornata) {
		HashMap<String, Double> voti = new HashMap<>();
		List<String> punteggi = new ArrayList<>();
		int i =1;
		double voto = 0.0;
		switch (numeroGiornata) {
		case 1:
			for (String[] s : giocatori) {
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				if(punteggi.size()==12) {
					if (punteggi.get(11).equalsIgnoreCase("*")) {
						voto = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata);
						if(voto==0) {
							voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								
	
						}
					}
				}
				voti.put(s[0], voto);
			}
			break;

		case 2:
			for (String s[] : giocatori) {
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				if(punteggi.size()==12) {
					if (punteggi.get(11).equalsIgnoreCase("*")) {
						voto = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata);
						if(voto==0) {
							voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								
	
						}
					}
				}
				voti.put(s[0], voto);
			}
			break;
		case 3:
			for (String s[] : giocatori) {
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				if(punteggi.size()==12) {
					if (punteggi.get(11).equalsIgnoreCase("*")) {
						voto = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata);
						if(voto==0) {
							voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								
	
						}
					}
				}
				voti.put(s[0], voto);
			}
			break;
		case 4:
			for (String s[] : giocatori) {
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				if(punteggi.size()==12) {
					if (punteggi.get(11).equalsIgnoreCase("*")) {
						voto = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata);
						if(voto==0) {
							voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								
	
						}
					}
				}
				voti.put(s[0], voto);
			}
			break;
		case 5:
			for (String s[] : giocatori) {
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				if(punteggi.size()==11) {
					if (punteggi.get(12).equalsIgnoreCase("*")) {
						voto = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata);
						if(voto==0) {
							voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								
	
						}
					}
				}
				voti.put(s[0], voto);
			}
			break;
		default:
			System.out.println("Scelta non consentita !");
		}
		return voti;

	}

	public static ArrayList<String> creaPanoramicaVoti(ArrayList<String[]> giocatori, int giornata) {
		ArrayList<String> panoramica = new ArrayList<String>();
		List<String> aus = new ArrayList<>();
		for (String s[] : giocatori) {
			aus = UtilityVotiGiocatori.estraiPunteggi(s[0], giornata);
			panoramica.add(aus.toString());
		}

		return panoramica;
	}

	public static List<String> estraiPunteggi(String giocatore, int giornata) {
		String path = "";
		List<String> ris = new ArrayList<>();
		switch (giornata) {
		case 1:
			path = pathVotiGiornata1;
			break;
		case 2:
			path = pathVotiGiornata2;
			break;

		case 3:
			path = pathVotiGiornata3;
			break;

		case 4:
			path = pathVotiGiornata4;
			break;

		case 5:
			path = pathVotiGiornata5;
			break;

		default:
			System.out.println("Scelta non consentita !");
		}
		List<List<String>> values = null;
		try (Stream<String> stream = Files.lines(Paths.get(path))) {

			values = stream.skip(1).filter(line -> line.contains(giocatore)).map(line -> Arrays.asList(line.split(",")))
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
		if (values.size() == 1)
			ris = values.get(0);
		else {
			ris.add(giocatore);
			ris.add("6");
			for (int i = 0; i <= 8; i++) {
				ris.add("0");
			}
			ris.add("*");
		}
		return ris;
	}

	public static double calcolaVoto(List<String> punteggi) {
		double voto = 0.0;
		if (punteggi.size() != 0) {

			voto = Double.parseDouble(punteggi.get(1));

			int gf = Integer.parseInt(punteggi.get(2));
			voto = voto + (3 * gf);

			int gs = Integer.parseInt(punteggi.get(3));
			voto = voto - (1 * gs);

			int rp = Integer.parseInt(punteggi.get(4));
			voto = voto + (3 * rp);

			int rs = Integer.parseInt(punteggi.get(5));
			voto = voto - (2 * rs);

			int rf = Integer.parseInt(punteggi.get(6));
			voto = voto + (2 * rf);

			int au = Integer.parseInt(punteggi.get(7));
			voto = voto - (3 * au);

			int amm = Integer.parseInt(punteggi.get(8));
			voto = voto - (0.5 * amm);

			int esp = Integer.parseInt(punteggi.get(9));
			voto = voto - (1 * esp);

			int ass = Integer.parseInt(punteggi.get(10));
			voto = voto + (1 * ass);
		}

		return voto;
	}

}
