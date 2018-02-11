/**
 * Cette calsse permet de determiner la valeur du lien nominal d'une correlation
 * @author Maxime
 *
 */
public class ValeurCorrelation {

	
	public String getNominalValue(double correlation)
	{
		String output = "";
		
		if(correlation >= 0.0  && correlation < 0.2)
			output = "Nulle a faible";
		if(correlation >= 0.2  && correlation < 0.4)
			output = "Faible a moyenne";
		if(correlation >= 0.4  && correlation < 0.7)
			output = "Moyenne a forte";
		if(correlation >= 0.7  && correlation < 0.9)
			output = "Forte a tres forte";
		if(correlation >= 0.9  && correlation <= 1)
			output = "Tres forte a parfaite";
		
		return output;
	}
}
