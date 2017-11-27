package testframework;

import banking.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.text.*;

public class RunTest {

	public static void main(String[] args) {
		double error = 0;
		double succes= 0.0;
		double pourc=0.0;
		long startProg = System.currentTimeMillis();
		int cpt=1;


		for (String className : args) {
			Class<?> clazz = null;
			long startTime = System.currentTimeMillis();

			try {
				clazz = Class.forName(className);
				long endTime = System.currentTimeMillis();
				System.out.println("La Classe "+ className+ ": OK  "+(endTime-startTime)+" ms");
				succes++;

				for(Method method : clazz.getDeclaredMethods()) {


					try {
						clazz = Class.forName(className);
						System.out.println("La Methode "+method.getName()+": OK");

					} catch (ClassNotFoundException e) {
						System.out.println("La Methode "+method.getName()+": KO");

						error++;

					}
					succes++;
					cpt++;



				}
				System.out.println("\n");
				cpt=1;
			} catch (ClassNotFoundException e) {

				System.out.println("La Classe : "+ className +" KO");
				error++;

			}


		}

		long endProg = System.currentTimeMillis();

		pourc=(succes/(succes+error))*100;


		DecimalFormat df = new DecimalFormat("00.00");
		DecimalFormat di = new DecimalFormat("00");


		System.out.println("Test run: "+di.format(error+succes)+"    Error:" + di.format(error) + "    Succes:"+di.format(succes)+ "\nSucces rate "+df.format(pourc)+"%\nRun time:"+(endProg-startProg)+" ms");

	}
}
