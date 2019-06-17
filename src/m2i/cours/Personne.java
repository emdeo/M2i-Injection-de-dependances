package m2i.cours;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement
public class Personne {

	@Expose
	private String _nom;
	@Expose(serialize = false)
	private IPersister _persister;

	/**
	 * Constructeur vide
	 */
	public Personne() {
		super();
	}

	/**
	 * Constructeur 2
	 * 
	 * @param nom
	 * @param p
	 */
	public Personne(String nom, IPersister p) {
		super();
		this._nom = nom;

		/*
		 * COUPLAGE FAIBLE : à chaque instanciation, je dois passer une interface en
		 * paramètre pour spécifier comment enregistrer l'objet
		 */
		this._persister = p;

		/*
		 * COUPLAGE FORT : je suis obligé de modifier la attributs et méthodes de
		 * JSONPersister chaque fois que je souhaite utiliser une autre forme de
		 * persister (XML...)
		 */
		// this._persister = new JSONPersister();
	}

	/**
	 * Sauvegarder l'objet au format JSON
	 */
	public void save() {
		this._persister.persist(this, this.getClass());
	}

	// Getters & setters

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

}
