package m2i.cours;

public class Main {
	public static void main(String[] args) {

		Personne p1 = new Personne("Alice", new JSONPersister());
		p1.save();
		
		Personne p2 = new Personne("Bernard", new XMLPersister());
		p2.save();

	}
}