package Calcul;
import java.text.DecimalFormat;
import java.util.List;

/**
 *  Cette classe permet de calculer la Variance a partir d'une liste
 *  
 *  Elle utilise la variable input afin de recevoir la moyenne precedement calculer
 * 
 */
public class Variance implements IMethodeMath {

	private double Variance;
	@Override
	public double calculer(List<String> listDonner, double inputValue) {
		double Distance = 0.0;
		int arraySize = Integer.parseInt(listDonner.get(0));
		try
		{
		

			/* VARIANCE */
			
			for(int i = 1; i <= arraySize;i++)
			{
				double value = (Integer.parseInt(listDonner.get(i)) - inputValue);
				
				Distance += value *value;
			}
		}
		catch(Exception e)
		{
			System.out.println("Erreur Variance: " +e.getMessage() + ", on retourne 0.0");
			return 0.0;
		}
		
		Variance = (1.0/(arraySize-1))*Distance;

		return Variance;
	}
	public double get() {
		return Variance;
	}

}