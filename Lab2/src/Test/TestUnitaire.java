package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Calcul.*;

public class TestUnitaire {

	List<String> listData = Arrays.asList("10", "186", "699", "132", "272", "291", "331", "199", "1890", "788", "1601");
	
	
	
	
	
	@Test
	public void testMoyenne() {
		System.out.println("\n\tTest: Moyenne");
		IMethodeMath moyenne = new Moyenne();
		double moy = moyenne.calculer(listData, 0.0);
		
		String result =String.valueOf(moy);
		
		if(result.startsWith("638.9"))
		{
			System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 638.9");
		}
		else
		{
			fail(result + " ne correspond pas a la valeur attendu 638.9");
		}
			
	}
	
	@Test
	public void testEcartType() {
		System.out.println("\n\tTest: Ecart-Type");
		double variance = 391417.8777777777;
		IMethodeMath ecartType = new EcartType();

		double ecart = ecartType.calculer(listData, variance);
		
		String result =String.valueOf(ecart);
		
		
		if(result.startsWith("625.63"))
		{
			System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 625.63");
		}
		else
		{
			fail(result + " ne correspond pas a la valeur attendu 625.63");
		}
			
	}
	
	@Test
	public void testLireCSV() {
		System.out.println("\n\tTest: Lire Fichier CSV");
		CSVReader csv = new CSVReader();
		
		List<String> result = csv.read("./src/test/data.csv");
		
		if(result.equals(listData))
		{
			System.out.println("Succes: La valeur " + result.toString() + " correspond a la valeur attendu: \n" + listData.toString());
		}
		else
		{
			fail(result + " ne correspond pas a la valeur attendu 625.63");
		}
			
	}
	

}
