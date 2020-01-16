import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Classe per la gestione dei file contenenti i voti dei giocatori
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class UtilityVotiGiocatori {

	private static String pathVotiGiornata1 = "src/Voti/votiPrimaGiornata.csv";
	private static String pathVotiGiornata2 = "src/Voti/votiSecondaGiornata.csv";
	private static String pathVotiGiornata3 = "src/Voti/votiTerzaGiornata.csv";
	private static String pathVotiGiornata4 = "src/Voti/votiQuartaGiornata.csv";
	private static String pathVotiGiornata5 = "src/Voti/votiQuintaGiornata.csv";

	/** Metodo che controlla se può essere effettuato un cambio, ed in caso affermativo lo effettua
	 * @param tipo stringa che rappresenta il tipo del giocatore 
	 * @param giocatori ArrayList dove sono contenuti i nomi dei giocatori titolari e delle riserve 
	 * @param numeroGiornata che si sta giocando 
	 * @param cambi ArrayList che contiene dei flag che indicano se un determinato giocatore è già subentrato o meno 
	 * @return HashMap contenente il nome e il voto del giocatore sostiuito
	 */
	public static HashMap<String,Double> effettuaCambio(String tipo, ArrayList<String[]> giocatori, int numeroGiornata,boolean[] cambi) {
		HashMap<String,Double> voto = new HashMap<>();
		double aus=0.0;
		String key="";
		boolean flag = false;
		List<String> punteggiRiserva = new ArrayList<>();
		switch (tipo) {
		case "P":
			punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(11)[0], numeroGiornata);
			if (punteggiRiserva.size()==11) {
				aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
				key=punteggiRiserva.get(0);
				voto.put(key, aus);
				cambi[0]=true;
			}
			break;
		case "D":
			if(cambi[1]==false){
				punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(12)[0], numeroGiornata);
				if (punteggiRiserva.size()==11) {
					aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
					if(aus==0) {
						punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(13)[0], numeroGiornata);
						if (punteggiRiserva.size()==11) {
							aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
							key=punteggiRiserva.get(0);
							voto.put(key, aus);
							cambi[2]=true;
						}
					}
					else {
						key=punteggiRiserva.get(0);
						voto.put(key, aus);
						flag=true;
						cambi[1]=true;
					}
				}
			}
			if(flag=false) {
				if(cambi[2]==false && cambi[1]==true) {
					punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(13)[0], numeroGiornata);
					if (punteggiRiserva.size()==11) {
						aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
						key=punteggiRiserva.get(0);
						voto.put(key, aus);
						cambi[2]=true;
					}
				}
			}
			break;
		case "C":
			if(cambi[3]==false) {
				punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(14)[0], numeroGiornata);
				if (punteggiRiserva.size()==11) {
					aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
					if(aus==0) {
						punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(15)[0], numeroGiornata);
						if (punteggiRiserva.size()==11) {
							aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
							key=punteggiRiserva.get(0);
							voto.put(key, aus);
							cambi[4]=true;
						}
						
					}
					else {
						key=punteggiRiserva.get(0);
						voto.put(key, aus);
						cambi[3]=true;
						flag=true;
					}
				}
			}
			if(flag=false) {
				if(cambi[4]==false && cambi[3]==true) {
					punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(15)[0], numeroGiornata);
					if (punteggiRiserva.size()==11) {
						aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
						key=punteggiRiserva.get(0);
						voto.put(key, aus);
						cambi[4]=true;
					}
				}
			}
			break;
		case "A":
			if(cambi[5]==false) {
				punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(16)[0], numeroGiornata);
				if (punteggiRiserva.size()==11) {
					aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
					if(aus==0) {
						punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(17)[0], numeroGiornata);
						if (punteggiRiserva.size()==11) {
							aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
							key=punteggiRiserva.get(0);
							voto.put(key, aus);
							cambi[6]=true;
						}
					}
					else {
						key=punteggiRiserva.get(0);
						voto.put(key, aus);
						cambi[5]=true;
						flag=true;
					}
					
				}
			}
			if(flag==false) {
				if(cambi[6]==false && cambi[5]==true) {
					punteggiRiserva = UtilityVotiGiocatori.estraiPunteggi(giocatori.get(17)[0], numeroGiornata);
					if (punteggiRiserva.size()==11) {
						aus = UtilityVotiGiocatori.calcolaVoto(punteggiRiserva);
						key=punteggiRiserva.get(0);
						voto.put(key, aus);
						cambi[6]=true;
					}
				}
			}
			break;
		default:
			System.out.println("Scelta non consnetita !");
		}
		return voto;
	}

	/** Metodo che assegna i voti ai giocatori
	 * @param giocatori a cui devono essere assegnati i voti 
	 * @param numeroGiornata numero della giornata per la quale si devono assegnare i voti 
	 * @return HashMap contenente i nomi e i voti dei giocatori 
	 */
	public static HashMap<String, Double> assegnaVoti(ArrayList<String[]> giocatori, int numeroGiornata) {
		HashMap<String, Double> voti = new HashMap<>();
		HashMap<String, Double> votiRiserva = new HashMap<>();
		List<String> punteggi = new ArrayList<>();
		int i = 0;
		double voto = 0.0;
		int numeroCambi = 0;
		boolean[] cambi = { false, false, false, false, false, false, false };
		switch (numeroGiornata) {
		case 0:
			for (String[] s : giocatori) {
				if (i == 11) {
					break;
				}
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
				if (numeroCambi == 3) {
					voti.put(s[0], voto);
				} else {
					if (punteggi.size() == 12) {
						if (punteggi.get(11).equalsIgnoreCase("*")) {
							votiRiserva = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata, cambi);
							if (votiRiserva.isEmpty() == true) {
								voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								voti.put(s[0], voto);
							} else {
								Set<String> keys = votiRiserva.keySet();
								for (String k : keys) {
									voti.put(k, votiRiserva.get(k));
								}
								votiRiserva.clear();
								numeroCambi++;
							}
						}
					} else {
						voti.put(s[0], voto);
					}
				}
				i++;
			}
			break;
		case 1:
			for (String[] s : giocatori) {
				if (i == 11) {
					break;
				}
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
				if (numeroCambi == 3) {
					voti.put(s[0], voto);

				} else {
					if (punteggi.size() == 12) {
						if (punteggi.get(11).equalsIgnoreCase("*")) {
							votiRiserva = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata, cambi);
							if (votiRiserva.isEmpty() == true) {
								voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								voti.put(s[0], voto);
							} else {
								Set<String> keys = votiRiserva.keySet();
								for (String k : keys) {
									voti.put(k, votiRiserva.get(k));
								}
								numeroCambi++;
							}
						}
					} else {
						voti.put(s[0], voto);
					}
				}
				i++;
			}
			break;
		case 2:
			for (String[] s : giocatori) {
				if (i == 11) {
					break;
				}
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
				if (numeroCambi == 3) {
					voti.put(s[0], voto);
				} else {
					if (punteggi.size() == 12) {
						if (punteggi.get(11).equalsIgnoreCase("*")) {
							votiRiserva = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata, cambi);
							if (votiRiserva.isEmpty() == true) {
								voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								voti.put(s[0], voto);
							} else {
								Set<String> keys = votiRiserva.keySet();
								for (String k : keys) {
									voti.put(k, votiRiserva.get(k));
								}
								numeroCambi++;
							}
						}
					} else {
						voti.put(s[0], voto);
					}
				}
				i++;
			}
			break;
		case 3:
			for (String[] s : giocatori) {
				if (i == 11) {
					break;
				}
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
				if (numeroCambi == 3) {
					voti.put(s[0], voto);
				} else {
					if (punteggi.size() == 12) {
						if (punteggi.get(11).equalsIgnoreCase("*")) {
							votiRiserva = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata, cambi);
							if (votiRiserva.isEmpty() == true) {
								voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								voti.put(s[0], voto);
							} else {
								Set<String> keys = votiRiserva.keySet();
								for (String k : keys) {
									voti.put(k, votiRiserva.get(k));
								}
								numeroCambi++;
							}
						}
					} else {
						voti.put(s[0], voto);
					}
				}
				i++;
			}
			break;
		case 4:
			for (String[] s : giocatori) {
				if (i == 11) {
					break;
				}
				punteggi = UtilityVotiGiocatori.estraiPunteggi(s[0], numeroGiornata);
				voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
				if (numeroCambi == 3) {
					voti.put(s[0], voto);
				} else {
					if (punteggi.size() == 12) {
						if (punteggi.get(11).equalsIgnoreCase("*")) {
							votiRiserva = UtilityVotiGiocatori.effettuaCambio(s[1], giocatori, numeroGiornata, cambi);
							if (votiRiserva.isEmpty() == true) {
								voto = UtilityVotiGiocatori.calcolaVoto(punteggi);
								voti.put(s[0], voto);
							} else {
								Set<String> keys = votiRiserva.keySet();
								for (String k : keys) {
									voti.put(k, votiRiserva.get(k));
								}
								numeroCambi++;
							}
						}
					} else {
						voti.put(s[0], voto);
					}
				}
				i++;
			}
			break;
		default:
			System.out.println("Scelta non consentita !");
		}
		return voti;

	}

	/** Metodo che crea una panoramica dei voti 
	 * @param giocatori da cui deve essere estratto il nome ed il voto
	 * @param giornata intero che rappresenta la giornata che si sta giocando 
	 * @return ArrayList di stringhe contenente il nome del giocatore e il voto
	 */
	public static ArrayList<String> creaPanoramicaVoti(ArrayList<String[]> giocatori, int giornata) {
		ArrayList<String> panoramica = new ArrayList<String>();
		List<String> aus = new ArrayList<>();
		for (String s[] : giocatori) {
			aus = UtilityVotiGiocatori.estraiPunteggi(s[0], giornata);
			panoramica.add(aus.toString());
		}

		return panoramica;
	}

	/** Metodo che estrae i punteggi ottenuti da un determinato giocatore in una determinata giornata
	 * @param giocatore nome del giocatore di cui devono essere estratti i punteggi
	 * @param giornata intero che rappresnta la giornata che si sta giocando 
	 * @return
	 */
	public static List<String> estraiPunteggi(String giocatore, int giornata) {
		String path = "";
		List<String> ris = new ArrayList<>();
		switch (giornata) {
		case 0:
			path = pathVotiGiornata1;
			break;
		case 1:
			path = pathVotiGiornata2;
			break;

		case 2:
			path = pathVotiGiornata3;
			break;

		case 3:
			path = pathVotiGiornata4;
			break;

		case 4:
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

	/** Metodo che in base ai punteggi passati in input calcola il voto finale del calciatore
	 * @param punteggi del calciatore
	 * @return voto
	 */
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
