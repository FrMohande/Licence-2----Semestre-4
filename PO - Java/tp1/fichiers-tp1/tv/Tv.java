/**
 * (Documentation should be in english...) une petite classe de manipulation :
 * televiseur
 * 
 * @author JC
 * @version 1.0
 */

public class Tv {

	// LES ATTRIBUTS = definition de l'etat de la classe

	/**
	 * statut de la tele, <t>true</t> pour allume, <t>false</t> sinon
	 */
	private boolean on;
	/**
	 * le numero de la chaine courante
	 */
	private int channel;
	/**
	 * niveau de volume courant. entre 0 et <i>sonMax</i>
	 */
	private int soundVolume;
	/** niveau de son maximum possible */
	private int maxSound;

	// LE CONSTRUCTEUR : pour construire les instances

	/**
	 * Builds a Tv.
	 */
	public Tv() {
		this.on = false;
		this.channel = 5;
		this.soundVolume = 3;
		this.maxSound = 10;
	}

	// LES METHODES : le comportement de la classe

	/**
	 * allume la tele
	 */
	public void on() {
		this.on = true;
	}

	/**
	 * eteint la tele
	 */
	public void off() {
		this.on = false;
	}

	/**
	 * change la chaine de la tele si la tele est allumee
	 * 
	 * @param channelNum
	 *            la nouvelle chaine (>0)
	 */
	public void changeChannel(int channelNum) {
		if (this.on && channelNum > 0) {
			this.channel = channelNum;
		}
	}

	/**
	 * indique la chaine courante
	 * 
	 * @return la chaine courante
	 */
	public int currentChannel() {
		return this.channel;
	}

	/**
	 * monte le son si la tele est allumee
	 */
	public void volumeUp() {
		if (this.on && this.soundVolume < this.maxSound) {
			this.soundVolume = this.soundVolume + 1; // ou this.soundVolume++
		}
	}

	/**
	 * baisse le son si la tele est allumee
	 */
	public void volumeDown() {
		if (this.on && this.soundVolume > 0) {
			this.soundVolume--; // equivaut a this.soundVolume =
								// this.soundVolume - 1,
		}
	}

	/**
	 * affiche un etat de la tele
	 */
	public void displayState() {
		System.out.print("tv");
		if (this.on) {
			System.out.println(" is on");
		} else {
			System.out.println(" is off");
		}
		System.out.println("channel : " + this.channel + " - sound volume : " + this.soundVolume);
	}
}
