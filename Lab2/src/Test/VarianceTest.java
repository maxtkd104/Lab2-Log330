package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class VarianceTest {

	String csvLowerBound = "CSV_TEST/LowerBound.csv";
	String csvUpperBound = "CSV_TEST/UpperBound.csv";
	String csvInvalide = "CSV_TEST/Invalide.csv";
	
	@Test
	public void testVarianceLowerBound() {
		//assertTrue(true);
		
		System.out.println("\n\tTest: Variance LowerBound");
		double moyenne = 253.9;
		IMethodeMath variance = new Calcul.Variance();
		CSVReader reader = new CSVReader();
		List<String> listData = reader.read(csvLowerBound);
		double var = variance.calculer(listData, moyenne);
		
		String result =String.valueOf(var);
		
		
		if(result.startsWith("63057.877"))
		{
			System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 63057.877");
			
		}
		else
		{
			System.out.println("Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: 63057.877");
			fail(result + " ne correspond pas a la valeur attendu 63057.877");
		}
	}
	
	@Test
	public void testVarianceUpperBound() {
		//assertTrue(true);
		
		System.out.println("\n\tTest: Variance UpperBound");
		double moyenne = 1580.5;
		IMethodeMath variance = new Calcul.Variance();
		CSVReader reader = new CSVReader();
		List<String> listData = reader.read(csvUpperBound);
		double var = variance.calculer(listData, moyenne);
		
		String result =String.valueOf(var);
		
		
		if(result.startsWith("667524.722"))
		{
			System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 667524.722");
			
		}
		else
		{
			System.out.println("Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: 667524.722");
			fail(result + " ne correspond pas a la valeur attendu 667524.722");
		}
	}
	
	@Test
	public void testVarianceInvalideValue() {
		//assertTrue(true);
		
		System.out.println("\n\tTest: Variance Invalide");
		double moyenne = 1580.5;
		IMethodeMath variance = new Calcul.Variance();
		CSVReader reader = new CSVReader();
		
		double var = 0.0;
		try
		{
			List<String> listData = reader.read(csvInvalide);
			var = variance.calculer(listData, moyenne);
		}
		catch(Exception ex)
		{
			System.out.println("Erreur: " +ex.getMessage());
			fail("Erreur: " +ex.getMessage());
			return;
		}
		
		
		
		String result =String.valueOf(var);
		
		
		if(result.startsWith("0.0"))
		{
			System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 0.0");
			
		}
		else
		{
			System.out.println("Erreur: La valeur " + result + " ne correspond pas a la valeur attendu: 0.0");
			fail(result + " ne correspond pas a la valeur attendu 0.0");
		}
	}

}
