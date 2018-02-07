package Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import Calcul.*;

public class Variance {

	String CSVPath = "./src/test/data.csv";
	
	@Test
	public void testVariance() {
		System.out.println("\n\tTest: Variance");
		double moyenne = 638.9000000000001;
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
