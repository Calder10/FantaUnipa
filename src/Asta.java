import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Asta implements SubjectAsta {

	private Giocatore giocatore;
	private HashMap<String, Integer> puntataCorrente;
	private ArrayList<ConcreteObserverAsta> obs;
	private int tipo;

	public Asta(Giocatore giocatore, int tipo) throws ClassNotFoundException, IOException {
		this.giocatore = giocatore;
		this.tipo = tipo;
		this.loadFantallenatori(tipo);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public HashMap<String, Integer> getPuntataCorrente() {
		return puntataCorrente;
	}

	public void setPuntataCorrente(HashMap<String, Integer> puntataCorrente) {
		this.puntataCorrente = puntataCorrente;
	}

	public ArrayList<ConcreteObserverAsta> getObs() {
		return obs;
	}

	public void setObs(ArrayList<ConcreteObserverAsta> obs) {
		this.obs = obs;
	}

	@Override
	public void loadFantallenatori(int tipo) throws IOException, ClassNotFoundException {
		obs = new ArrayList<ConcreteObserverAsta>();
		this.puntataCorrente = new HashMap<>();
		File f = new File("src/Squadre");
		File[] files;

		switch (tipo) {
		case 0:
			if (f.isDirectory()) {
				files = f.listFiles();

				for (File x : files) {
					FileInputStream fis = new FileInputStream(x);
					ObjectInputStream ois = new ObjectInputStream(fis);
					ConcreteObserverAsta o = new ConcreteObserverAsta();
					Squadra aus = (Squadra) ois.readObject();
					if (aus.getPortieri().size() != 3) {
						o.setSquadra(aus);
						obs.add(o);
						String s = aus.getFantallenatore().getUsername();
						this.puntataCorrente.put(s, 0);
						ois.close();
						fis.close();
					}
				}
			}
			break;

		case 1:
			if (f.isDirectory()) {
				files = f.listFiles();

				for (File x : files) {
					FileInputStream fis = new FileInputStream(x);
					ObjectInputStream ois = new ObjectInputStream(fis);
					ConcreteObserverAsta o = new ConcreteObserverAsta();
					Squadra aus = (Squadra) ois.readObject();
					if (aus.getDifensori().size() != 8) {
						o.setSquadra(aus);
						obs.add(o);
						String s = aus.getFantallenatore().getUsername();
						this.puntataCorrente.put(s, 0);
						ois.close();
						fis.close();
					}
				}
			}
			break;
		case 2:
			if (f.isDirectory()) {
				files = f.listFiles();

				for (File x : files) {
					FileInputStream fis = new FileInputStream(x);
					ObjectInputStream ois = new ObjectInputStream(fis);
					ConcreteObserverAsta o = new ConcreteObserverAsta();
					Squadra aus = (Squadra) ois.readObject();
					if (aus.getCentrocampisti().size() != 8) {
						o.setSquadra(aus);
						obs.add(o);
						String s = aus.getFantallenatore().getUsername();
						this.puntataCorrente.put(s, 0);
						ois.close();
						fis.close();

					}
				}
			}
			break;
		case 3:
			if (f.isDirectory()) {
				files = f.listFiles();

				for (File x : files) {
					FileInputStream fis = new FileInputStream(x);
					ObjectInputStream ois = new ObjectInputStream(fis);
					ConcreteObserverAsta o = new ConcreteObserverAsta();
					Squadra aus = (Squadra) ois.readObject();
					if (aus.getAttaccanti().size() != 6) {
						o.setSquadra(aus);
						obs.add(o);
						String s = aus.getFantallenatore().getUsername();
						this.puntataCorrente.put(s, 0);
						ois.close();
						fis.close();

					}
				}
			}
			break;

		default:
			System.out.println("Scelta non consentita !");
		}

	}

	@Override
	public void notifyAllObserver(String username, int puntata) {
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if (usr.equalsIgnoreCase(username) == false) {
				Integer oldValue = this.puntataCorrente.get(username);
				this.puntataCorrente.replace(username, oldValue, puntata);
			}
			o.setPuntata(this.puntataCorrente);
		}
	}

	public String stampaPuntata(String username) {
		Set<String> keys = this.puntataCorrente.keySet();
		if (keys.contains(username)) {
			String valore = puntataCorrente.get(username).toString();
			return username + ": " + valore + "\n\n";
		} else {
			return username + " ha rinunciato !\n\n";
		}
	}

	public void puntateVirtuali(String username, JTextArea textArea, JButton btnNewButtonRilancia) {
		textArea.setVisible(true);
		btnNewButtonRilancia.setVisible(true);
		ArrayList<ConcreteObserverAsta> delete = new ArrayList<>();
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if (username.equalsIgnoreCase(usr) == false) {
				int ris = o.puntaVirtuale(usr, this.tipo);
				if (ris == 0) {
					delete.add(o);
					this.notifyAllObserver(usr, ris);
					textArea.append(this.stampaPuntata(usr));
				} else {
					this.notifyAllObserver(usr, ris);
					textArea.append(this.stampaPuntata(usr));
				}
			}
		}
		for (ConcreteObserverAsta o : delete) {
			this.obs.remove(o);
		}
	}

	public void puntateVirtuali(String username) {
		ArrayList<ConcreteObserverAsta> delete = new ArrayList<>();
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if (username.equalsIgnoreCase(usr) == false) {
				int ris = o.puntaVirtuale(usr, this.tipo);
				if (ris == 0) {
					delete.add(o);
					this.notifyAllObserver(usr, ris);
				} else {
					this.notifyAllObserver(usr, ris);
				}
			}
		}
		for (ConcreteObserverAsta o : delete) {
			this.obs.remove(o);
		}
	}

	public void simulaAsta(ConcreteObserverAsta o, AstaGUI astaGUI, AstaGiocatoreGUI astaGiocatoreGUI, String username,
			JTextField textField, JTextArea textArea, JButton btnNewButtonRinuncia) {
		int puntata = Integer.parseInt(astaGiocatoreGUI.textField.getText());
		try {
			boolean ris = o.punta(username, puntata);
			if (ris == true) {
				HashMap<String, Integer> aus = this.getPuntataCorrente();
				Integer oldValue = aus.get(username);
				aus.replace(username, oldValue, puntata);
				this.setPuntataCorrente(aus);
				this.notifyAllObserver(username, puntata);
				this.puntateVirtuali(username, textArea, btnNewButtonRinuncia);
				int dim = this.getPuntataCorrente().size();
				if (dim == 1) {
					String key = "";
					int value = 0;
					Set<String> keys = this.getPuntataCorrente().keySet();
					for (String s : keys) {
						key = s;
						value = this.getPuntataCorrente().get(s);
					}

					ArrayList<ConcreteObserverAsta> oss = this.getObs();
					Squadra s;
					for (ConcreteObserverAsta o1 : oss) {
						if (key.equalsIgnoreCase(o1.getSquadra().getFantallenatore().getUsername())) {
							s = o1.getSquadra();
							int newValue = o1.getSquadra().getFantallenatore().getFantaCrediti() - value;
							o1.getSquadra().getFantallenatore().setFantaCrediti(newValue);
							o1.getSquadra().addGiocatore(this.getGiocatore(), this.tipo);
							s.updateSquadra();
							String fantacrediti= String.valueOf(newValue).toString();
							this.updateFantacreditiCsv(username, fantacrediti);
							UtilityListaGiocatori.giocatoreAcquistato(this.tipo, this.giocatore.getNomeGiocatore());
							JOptionPane.showMessageDialog(astaGiocatoreGUI.textField,
									"Ti sei aggiudicato: " + this.giocatore.getNomeGiocatore());
							astaGiocatoreGUI.dispose();
							AstaGUI nextFrame1;
							switch (this.tipo) {
							case 0:
								if (s.getPortieri().size() == 3) {
									JOptionPane.showMessageDialog(astaGiocatoreGUI, "Asta portieri completata !");
									this.completaAstaSquadreVirtuali(this.tipo);
									astaGUI.dispose();
									nextFrame1 = (AstaGUI) new AstaDifensoriGUI(username);
									nextFrame1.setVisible(true);
									nextFrame1.toFront();

								}
								break;

							case 1:
								if (s.getDifensori().size() == 8) {
									JOptionPane.showMessageDialog(astaGiocatoreGUI, "Asta difensori completata !");
									this.completaAstaSquadreVirtuali(this.tipo);
									astaGUI.dispose();
									nextFrame1 = (AstaGUI) new AstaCentrocampistiGUI(username);
									nextFrame1.setVisible(true);
									nextFrame1.toFront();
								}
								break;
							case 2:
								if (s.getCentrocampisti().size() == 8) {
									JOptionPane.showMessageDialog(astaGiocatoreGUI, "Asta centrocampisti completata !");
									this.completaAstaSquadreVirtuali(this.tipo);
									astaGUI.dispose();
									nextFrame1 = (AstaGUI) new AstaAttaccantiGUI(username);
									nextFrame1.setVisible(true);
									nextFrame1.toFront();
								}
								break;

							case 3:
								if (s.getAttaccanti().size() == 6) {
									JOptionPane.showMessageDialog(astaGiocatoreGUI, "Asta attaccanti completata !");
									this.completaAstaSquadreVirtuali(this.tipo);
									astaGUI.dispose();
									HomeGUI nextFrame2 = new HomeGUI(username);
									Torneo t = Torneo.getTorneo();
									t.saveTorneo();
									nextFrame2.setVisible(true);
									nextFrame2.toFront();
								}
								break;
							}
						}
					}

				}
			} else {
				JOptionPane.showMessageDialog(astaGiocatoreGUI.textField, "Puntata non consentita!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eseguiAsta(AstaGUI astaGUI, AstaGiocatoreGUI astaGiocatoreGUI, JTextField textField, String username,
			JTextArea textArea, JButton btnNewButtonRinuncia) {
		ConcreteObserverAsta o = null;
		for (ConcreteObserverAsta ob : obs) {
			if (ob.getSquadra().getFantallenatore().getUsername().equalsIgnoreCase(username)) {
				o = ob;
			}
		}
		switch (this.tipo) {
		case 0:
			if (o.getSquadra().getPortieri().size() < 3) {
				this.simulaAsta(o, astaGUI, astaGiocatoreGUI, username, textField, textArea, btnNewButtonRinuncia);
			} else {
				this.getObs().remove(o);
			}
			break;
		case 1:
			if (o.getSquadra().getDifensori().size() < 8) {
				this.simulaAsta(o, astaGUI, astaGiocatoreGUI, username, textField, textArea, btnNewButtonRinuncia);
			} else {
				this.getObs().remove(o);
			}
			break;

		case 2:
			if (o.getSquadra().getCentrocampisti().size() < 8) {
				this.simulaAsta(o, astaGUI, astaGiocatoreGUI, username, textField, textArea, btnNewButtonRinuncia);
			} else {
				this.getObs().remove(o);
			}
			break;

		case 3:
			if (o.getSquadra().getPortieri().size() < 6) {
				this.simulaAsta(o, astaGUI, astaGiocatoreGUI, username, textField, textArea, btnNewButtonRinuncia);
			} else {
				this.getObs().remove(o);
			}
			break;

		default:
			System.out.println("Scelta non consentita");

		}

	}

	public void simulaRinuncia(String username, AstaGiocatoreGUI astaGiocatoreGUI) throws IOException {
		this.getPuntataCorrente().remove(username);
		ConcreteObserverAsta o = null;
		for (ConcreteObserverAsta ob : obs) {
			if (ob.getSquadra().getFantallenatore().getUsername().equalsIgnoreCase(username)) {
				o = ob;
			}
		}
		this.getObs().remove(o);
		this.notifyAllObserver(username, 0);
		while (true) {
			if (this.getObs().size() == 0) {
				String messaggio = "Hanno rinunciato tutti !";
				JOptionPane.showMessageDialog(astaGiocatoreGUI, messaggio);
				astaGiocatoreGUI.dispose();
				break;
			}
			if (this.getObs().size() == 1) {
				ConcreteObserverAsta o1 = this.getObs().get(0);
				username = o1.getSquadra().getFantallenatore().getUsername();
				int value = this.puntataCorrente.get(username);
				Squadra s;
				s = o1.getSquadra();
				int newValue = o1.getSquadra().getFantallenatore().getFantaCrediti() - value;
				o1.getSquadra().getFantallenatore().setFantaCrediti(newValue);
				o1.getSquadra().addGiocatore(this.getGiocatore(), this.tipo);
				s.updateSquadra();
				String fantacrediti= String.valueOf(newValue).toString();
				this.updateFantacreditiCsv(username, fantacrediti);
				UtilityListaGiocatori.giocatoreAcquistato(this.getTipo(), this.giocatore.getNomeGiocatore());
				String messaggio = o1.getSquadra().getFantallenatore().getUsername() + " si è aggudicato "
						+ this.giocatore.getNomeGiocatore();
				JOptionPane.showMessageDialog(astaGiocatoreGUI, messaggio);
				astaGiocatoreGUI.dispose();
				break;

			} else {
				o = this.obs.get(0);
				username = o.getSquadra().getFantallenatore().getUsername();
				int puntata = o.puntaVirtuale(username, this.tipo);
				if (puntata == 0)
					this.obs.remove(o);
				HashMap<String, Integer> aus = this.getPuntataCorrente();
				Integer oldValue = aus.get(username);
				aus.replace(username, oldValue, puntata);
				this.setPuntataCorrente(aus);
				this.notifyAllObserver(username, puntata);
				if (this.obs.size() == 1) {
					ConcreteObserverAsta o1 = this.getObs().get(0);
					username = o1.getSquadra().getFantallenatore().getUsername();
					int value = o1.getPuntata().get(username);
					Squadra s;
					s = o1.getSquadra();
					int newValue = o1.getSquadra().getFantallenatore().getFantaCrediti() - value;
					o1.getSquadra().getFantallenatore().setFantaCrediti(newValue);
					o1.getSquadra().addGiocatore(this.getGiocatore(), this.tipo);
					s.updateSquadra();
					String fantacrediti= String.valueOf(newValue).toString();
					this.updateFantacreditiCsv(username, fantacrediti);
					UtilityListaGiocatori.giocatoreAcquistato(this.getTipo(), this.giocatore.getNomeGiocatore());
					String messaggio = o1.getSquadra().getFantallenatore().getUsername() + " si è aggudicato "
							+ this.giocatore.getNomeGiocatore();
					JOptionPane.showMessageDialog(astaGiocatoreGUI, messaggio);
					astaGiocatoreGUI.dispose();
					break;
				} else {
					this.puntateVirtuali(username);
				}
			}
		}

	}

	public void completaAstaSquadreVirtuali(int tipo) throws IOException, ClassNotFoundException {
		while (true) {
			int puntata;
			Giocatore g = null;
			String nomeGiocatore = UtilityListaGiocatori.randomPlayer(tipo);
			switch (tipo) {
			case 0:
				g = new Portiere(nomeGiocatore);
				break;
			case 1:
				g = new Difensore(nomeGiocatore);
				break;
			case 2:
				g = new Centrocampista(nomeGiocatore);
				break;
			case 3:
				g = new Attaccante(nomeGiocatore);
				break;
			default:
				System.out.println("Scelta non consentita ");
			}

			Asta a = new Asta(g, tipo);
			if (a.getObs().size() == 0) {
				break;
			}
			ConcreteObserverAsta o = a.getObs().get(0);
			String username = o.getSquadra().getFantallenatore().getUsername();
			if (a.getObs().size() == 1) {
				ArrayList<ConcreteObserverAsta> oss = a.getObs();
				Squadra s;
				for (ConcreteObserverAsta o1 : oss) {
					s = o1.getSquadra();
					int newValue = o1.getSquadra().getFantallenatore().getFantaCrediti() - 1;
					o1.getSquadra().getFantallenatore().setFantaCrediti(newValue);
					o1.getSquadra().addGiocatore(a.getGiocatore(), a.getTipo());
					s.updateSquadra();
					String fantacrediti= String.valueOf(newValue).toString();
					a.updateFantacreditiCsv(o1.getSquadra().getFantallenatore().getUsername(), fantacrediti);
					UtilityListaGiocatori.giocatoreAcquistato(a.getTipo(), a.giocatore.getNomeGiocatore());
					a.getObs().remove(o1);
					break;
				}
			} else {
				while (true) {
					puntata = o.puntaVirtuale(username, a.getTipo());
					a.getPuntataCorrente().put(username, puntata);
					a.notifyAllObserver(username, puntata);
					a.puntateVirtuali(username);
					int dim = a.getPuntataCorrente().size();
					if (dim == 1) {
						String key = "";
						int value = 0;
						Set<String> keys = a.getPuntataCorrente().keySet();
						for (String s : keys) {
							key = s;
							value = a.getPuntataCorrente().get(s);
						}
						ArrayList<ConcreteObserverAsta> oss = a.getObs();
						Squadra s;
						for (ConcreteObserverAsta o1 : oss) {
							if (key.equalsIgnoreCase(o1.getSquadra().getFantallenatore().getUsername())) {
								s = o1.getSquadra();
								int newValue = o1.getSquadra().getFantallenatore().getFantaCrediti() - value;
								o1.getSquadra().getFantallenatore().setFantaCrediti(newValue);
								o1.getSquadra().addGiocatore(a.getGiocatore(), a.getTipo());
								s.updateSquadra();
								UtilityListaGiocatori.giocatoreAcquistato(a.getTipo(), a.giocatore.getNomeGiocatore());
								break;
							}
						}
						break;
					}
				}
			}
			
			
		}
	}
	public static void updateFantacreditiCsv(String username, String fantacrediti) throws IOException {
		
		File f = new File("dati.csv");
		FileReader fr = new FileReader(f);
		String path1 = "dati1.csv";
		BufferedReader br = new BufferedReader(fr);
		File f1 = new File(path1);
		FileWriter fw = new FileWriter(f1, true);
		String line = br.readLine();
		fw.append(line);
		fw.append("\n");
		while ((line = br.readLine()) != null) {
			String[] fields = line.split(",");
			if (fields[2].equalsIgnoreCase(username)) {
				fw.append(fields[0]);
				fw.append(",");
				fw.append(fields[1]);
				fw.append(",");
				fw.append(fields[2]);
				fw.append(",");
				fw.append(fields[3]);
				fw.append(",");
				fw.append(fields[4]);
				fw.append(",");
				fw.append(fantacrediti);
				fw.append("\n");
			} else {
				fw.append(line);
				fw.append("\n");
			}
		}
		br.close();
		fw.close();
		fr.close();
		f1.renameTo(f);
		
	}
}
