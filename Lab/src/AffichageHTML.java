import java.util.List;

public class AffichageHTML {

	
	/**
	 * Html de la correlation pour l'affichage
	 * @param correlation
	 * @param valeurNominal
	 * @return
	 */
	public String correlationHTML(double correlation, String valeurNominal)
	{
		
		return  "<html>Correlation R:  " + String.valueOf(correlation) + 
				"<br>Correlation R<SUP>2</SUP>: " + String.valueOf(correlation * correlation) + 
				"<br>Valeur nominal du lien: " + valeurNominal + "</html>";
	}

	public String affichageCSV1ColoneL(List<String> data)
	{
		String textLabelData = "";
		textLabelData = "<html>Valeurs du fichier CSV:";

		for(int i = 1; i< data.size();i++)
		{
			textLabelData += "<br/>" + data.get(i);
		}
		
		textLabelData += "<br/><br/></html>";
	
		
		return  textLabelData;
	}
}
