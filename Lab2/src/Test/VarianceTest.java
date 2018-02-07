package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class VarianceTest {

	String CSVPath = "data.csv";
	
	@Test
	public void testVarianceLowerBound() {
		//assertTrue(true);
		
		System.out.println("\n\tTest: Variance");
		double moyenne = 638.9;
		IMethodeMath variance = new Calcul.Variance();
		CSVReader reader = new CSVReader();
		List<String> listData = reader.read(CSVPath);
		double var = variance.calculer(listData, moyenne);
		
		String result =String.valueOf(var);
		
		
		if(result.startsWith("391417.8777"))
		{
			System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 391417.8778");
			
		}
		else
		{
			fail(result + " ne correspond pas a la valeur attendu 391,417.8778");
		}
	}
	
	@Test
	public void testVarianceUpperBound() {
		//assertTrue(true);
		
		System.out.println("\n\tTest: Variance");
		double moyenne = 638.9;
		IMethodeMath variance = new Calcul.Variance();
		CSVReader reader = new CSVReader();
		List<String> listData = reader.read(CSVPath);
		double var = variance.calculer(listData, moyenne);
		
		String result =String.valueOf(var);
		
		
		if(result.startsWith("391417.8777"))
		{
			System.out.println("Succes: La valeur " + result + " correspond a la valeur attendu: 391417.8778");
			
		}
		else
		{
			fail(result + " ne correspond pas a la valeur attendu 391,417.8778");
		}
	}
	
	

}
