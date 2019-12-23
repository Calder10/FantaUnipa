import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException  {
		
		ConcreteFantallenatoreBuilder a = new ConcreteFantallenatoreBuilder();
		Director d = new Director(a);
		d.createFantallenatore();
		Fantallenatore f= d.getFantallenatore();
		System.out.println(f.toString());
		Registrazione r = new Registrazione();
		r.salvaUtente(f);
		
		ConcreteFantallenatoreVirtualBuilder b = new ConcreteFantallenatoreVirtualBuilder();
		Director e = new Director(b);
		e.createFantallenatore();
		Fantallenatore f1 = e.getFantallenatore();
		System.out.println(f1.toString());
		r.salvaUtente(f1);
		/*
		Registrazione r = new Registrazione();
		boolean ris = r.checkUsername("pippo1925");
		if(ris==true)
			System.out.println("Username non utilizzato");
		else
			System.out.println("Username già usato");
		
		boolean ris1 = r.checkPassword("compu11");
		if(ris1==true)
			System.out.println("Password conforme");
		else
			System.out.println("Password non conforme");
		*/
		
	}

}
