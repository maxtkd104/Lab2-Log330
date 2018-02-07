package Calcul;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	/**
	 * Lis un fichier CSV ligne par ligne et retourne les donnees sous forme de tableu de int
	 * 
	 * @param filePath
	 * @return tableau des donnees a tester
	 */
	public List<String> read(String filePath)
	{
		
		List<String> data = new ArrayList<String>();
		
		File file = new File(filePath);

        try{
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String dataText = inputStream.next();
                data.add(dataText);
                //System.out.println(dataText);

            }
            inputStream.close();


        }catch (FileNotFoundException e){

            e.printStackTrace();
        }
		
		
		
		return data;
	}
	
}
