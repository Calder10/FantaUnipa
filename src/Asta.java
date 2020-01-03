import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public Asta(Giocatore giocatore, int tipo) throws ClassNotFoundException, IOException {
		this.giocatore = giocatore;
		this.loadFantallenatori(tipo);
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
					if (aus.getPortieri().size() != 8) {
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
					if (aus.getPortieri().size() != 8) {
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
					if (aus.getPortieri().size() != 6) {
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
			
		default: System.out.println("Scelta non consentita !");
		}

	}

	@Override
	public void notifyAllObserver(String username, int puntata) {
		System.out.println("notifyall");
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
		System.out.println("puntateVirtuali");
		textArea.setVisible(true);
		btnNewButtonRilancia.setVisible(true);
		ArrayList<ConcreteObserverAsta> delete = new ArrayList<>();
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if (username.equalsIgnoreCase(usr) == false) {
				int ris = o.puntaVirtuale(usr);
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
		System.out.println("puntateVirtuali");
		ArrayList<ConcreteObserverAsta> delete = new ArrayList<>();
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if (username.equalsIgnoreCase(usr) == false) {
				int ris = o.puntaVirtuale(usr);
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

	public void simulaAsta(AstaPortieriGUI astaPortieriGUI, AstaGiocatoreGUI astaGiocatoreGUI, JTextField textField,
			String username, JTextArea textArea, JButton btnNewButtonRinuncia) {
		System.out.println("Prova");
		ConcreteObserverAsta o = null;
		for (ConcreteObserverAsta ob : obs) {
			if (ob.getSquadra().getFantallenatore().getUsername().equalsIgnoreCase(username)) {
				o = ob;
			}
		}
		if (o.getSquadra().getPortieri().size() < 3) {
			int puntata = Integer.parseInt(textField.getText());
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
						System.out.println(this.getGiocatore().getNomeGiocatore() + " aggiudicato");
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
								o1.getSquadra().addPortiere((Portiere) this.getGiocatore());
								System.out.println(o1.getSquadra().getPortieri().toString());
								s.updateSquadra();
								UtilityListaGiocatori.giocatoreAcquistato(0, this.giocatore.getNomeGiocatore());
								JOptionPane.showMessageDialog(textField,
										"Ti sei aggiudicato: " + this.giocatore.getNomeGiocatore());
								astaGiocatoreGUI.dispose();
								if (s.getPortieri().size() == 3) {
									JOptionPane.showMessageDialog(astaGiocatoreGUI, "Asta portieri completata !");
									this.completaAstaSquadreVirtuali();
									LoginGUI nextFrame = new LoginGUI();
									nextFrame.setVisible(true);
									nextFrame.toFront();
									astaPortieriGUI.dispose();
								}
							}
						}

					}
				} else {
					JOptionPane.showMessageDialog(textField, "Puntata non consentita!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.getObs().remove(o);
		}
		System.out.println(o.getSquadra().getPortieri().toString());

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
		if(this.getObs().size()==0)
			System.out.println("Hanno rinunciato tutti !");
		if(this.getObs().size()==1)
			System.out.println("Ha vinto !");
		while (this.obs.size() != 1) {
			// controllo su quando rimane uno solo 
			o = this.obs.get(0);
			int puntata = o.puntaVirtuale(o.getSquadra().getFantallenatore().getUsername());
			HashMap<String, Integer> aus = this.getPuntataCorrente();
			Integer oldValue = aus.get(username);
			aus.replace(username, oldValue, puntata);
			this.setPuntataCorrente(aus);
			this.notifyAllObserver(username, puntata);
			this.puntateVirtuali(username);
			int dim = this.getPuntataCorrente().size();
			if (dim == 1) {
				String key = "";
				int value = 0;
				System.out.println(this.getGiocatore().getNomeGiocatore() + " aggiudicato");
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
						o1.getSquadra().addPortiere((Portiere) this.getGiocatore());
						System.out.println(o1.getSquadra().getFantallenatore().getUsername());
						System.out.println(o1.getSquadra().getPortieri().toString());
						s.updateSquadra();
						UtilityListaGiocatori.giocatoreAcquistato(0, this.giocatore.getNomeGiocatore());
						String messaggio = o1.getSquadra().getFantallenatore().getUsername() + " si è aggudicato "
								+ this.giocatore.getNomeGiocatore();
						JOptionPane.showMessageDialog(astaGiocatoreGUI, messaggio);
						astaGiocatoreGUI.dispose();
						break;
					}
					break;
				}

			}
		}

	}

	public void completaAstaSquadreVirtuali() throws IOException, ClassNotFoundException {
		while (true) {
			int puntata;
			String nomeGiocatore = UtilityListaGiocatori.randomPlayer(0);
			Giocatore g = new Portiere(nomeGiocatore);
			Asta a = new Asta(g, 0);
			if (a.getObs().size() == 0) {
				System.out.println("Asta Completata\n");
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
					o1.getSquadra().addPortiere((Portiere) a.getGiocatore());
					System.out.println(a.getGiocatore().getNomeGiocatore() + " aggiudicato");
					System.out.println(o1.getSquadra().getFantallenatore().getUsername());
					System.out.println(o1.getSquadra().getPortieri().toString());
					s.updateSquadra();
					UtilityListaGiocatori.giocatoreAcquistato(0, a.giocatore.getNomeGiocatore());
					a.getObs().remove(o1);
					break;
				}
			}
			else {
				while(true) {
					puntata=o.puntaVirtuale(username);
					a.getPuntataCorrente().put(username,puntata);
					a.notifyAllObserver(username, puntata);
					a.puntateVirtuali(username);
					int dim = a.getPuntataCorrente().size();
					if (dim == 1) {
						String key = "";
						int value = 0;
						System.out.println(a.getGiocatore().getNomeGiocatore() + " aggiudicato");
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
								o1.getSquadra().addPortiere((Portiere) a.getGiocatore());
								System.out.println(o1.getSquadra().getFantallenatore().getUsername());
								System.out.println(o1.getSquadra().getPortieri().toString());
								s.updateSquadra();
								UtilityListaGiocatori.giocatoreAcquistato(0, a.giocatore.getNomeGiocatore());
								break;
							}
						}
						break;
					}
				}
			}
		}
	}
}
