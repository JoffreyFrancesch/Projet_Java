package testframework;

import banking.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.text.*;

public class RunTest {

	public static void main(String[] args) {
		double erreur = 0;
		double reussite= 0.0;
		double pourcentage=0.0;
		long startProg = System.currentTimeMillis();
		int cpt=1;


		for (String className : args) {
			Class<?> clazz = null;
			long startTime = System.currentTimeMillis();

			try {
				clazz = Class.forName(className);
				long endTime = System.currentTimeMillis();
				System.out.println("Classe : "+ className+ ": OK  "+(endTime-startTime)+" ms");
				reussite++;

				for(Method method : clazz.getDeclaredMethods()) {


					try {
						clazz = Class.forName(className);
						System.out.println("	Methode : "+method.getName()+": OK");

					} catch (ClassNotFoundException e) {
						System.out.println("	Methode : "+method.getName()+": KO");

						erreur++;

					}
					reussite++;
					cpt++;



				}
				System.out.println("\n");
				cpt=1;
			} catch (ClassNotFoundException e) {

				System.out.println("Classe : "+ className +" KO");
				erreur++;

			}


		}

		long endProg = System.currentTimeMillis();

		pourcentage=(reussite/(reussite+erreur))*100;


		DecimalFormat df = new DecimalFormat("00.00");
		DecimalFormat di = new DecimalFormat("00");


		System.out.println("Test run : "+di.format(erreur+reussite)+"    Erreur : " + di.format(erreur) + "    Reussite : "+di.format(reussite)+ "\nTaux de reussite "+df.format(pourcentage)+"%\nRun time:"+(endProg-startProg)+" ms");

	}
}
