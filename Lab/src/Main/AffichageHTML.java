package Main;
import java.util.List;

public class AffichageHTML {

	/**
	 * Html de la correlation pour l'affichage
	 * 
	 * @param correlation
	 * @param valeurNominal
	 * @return
	 */
	public String afficher(List<String> data, int rowCount) {

		String ret = "";

		if (rowCount == 1) {
			String textLabelData = "";
			textLabelData = "<html><br/>Valeurs du fichier CSV:";

			for (int i = 1; i < data.size(); i++) {
				textLabelData += "<br/>" + data.get(i);
			}

			textLabelData += "<br/><br/></html>";

			ret = textLabelData;
		}
		
		if (rowCount == 2)
		{
			String textLabelData = "";
			textLabelData = "<html><br/>Valeurs du fichier CSV:";

			for (int i = 1; i < data.size(); i++) {
				 String[] parts = data.get(i).split(";");
				
				textLabelData += "<br/>" + parts[0] + " - " + parts[1];
			}

			textLabelData += "<br/><br/></html>";

			ret = textLabelData;
		}

		return ret;
	}
}
