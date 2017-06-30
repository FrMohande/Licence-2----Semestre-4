import java.io.*;
import drawing.*;
public class TstPlat {

	
 public static void main(String[] args) {
	 String s=System.console().readLine("taille (5 minimum) : ");
	 DrawPlateau tp= new DrawPlateau(Integer.parseInt(s));
	 tp.dessine("5,4,3,2,1","7,4,3,1","8,6,4");
	 s=System.console().readLine("appuyer sur entree");
	 tp.dessine("4,3,2,1","","");
	 long tmp=System.currentTimeMillis();
	 while (System.currentTimeMillis()-tmp<5000){/* attente : duree en millisecondes*/};
	 s=System.console().readLine("appuyer sur entree");
	 System.exit(0);
}

}
