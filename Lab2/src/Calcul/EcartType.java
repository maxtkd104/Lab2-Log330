package Calcul;
import java.text.DecimalFormat;
import java.util.List;


/**
 *  Cette classe permet de calculer l'ecart-type a partir d'une liste
 *  
 *  Elle utilise la variable input afin de recevoir la variance precedement calculer
 * 
 */
public class EcartType implements IMethodeMath {

	private double EcartType;
	@Override
	public double calculer(List<String> listDonner, double inputValue) {
		
		try
		{
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);	
			if(inputValue != 0.0)
				EcartType = sqrt(inputValue);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			EcartType = 0.0;
		}
		
		return EcartType;
		
	}
	
	private double sqrt(double variance) {
		double t;
	 
		double squareRoot = variance / 2;
	 
		do {
			t = squareRoot;
			squareRoot = (t + (variance / t)) / 2;
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}
	
	public double get() {
		return EcartType;
	}

}

