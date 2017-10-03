/**
 * Für einen Laufzeitvergleich werden die gleichen Daten in unterschiedlichen Datenstrukturen abgelegt.
 * Wir verwenden als erstes eine ArrayList und eine LinkedList.
 * @author Hr. Jakob 27.06.2016 angelegt
 * überprüft 2.9.2017 auf geänderte Namenskonventionen
 * geändert 12.9.2017 Zwei Methodenrümpfe als Vorlagen angelegt
 */
package vergleichSortieralgorithmen;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.collections.ObservableList;

public class WindradDaten
{
    private ArrayList<WindradDatum>  windradDatenAL = new ArrayList<WindradDatum>();
    private LinkedList<WindradDatum> windradDatenLL = new LinkedList<WindradDatum>();

    /**
     * Die Windraddaten werden einmal in eine Arraylist und einmal in eine LinkedList geschrieben
     */
    WindradDaten(ObservableList<WindradDatum> pWindradDaten)
    {
        windradDatenAL.addAll(pWindradDaten);
        windradDatenLL.addAll(pWindradDaten);
    }

   /**
    * Sortiert die Liste mit dem Bubblesortalgorithmus - Basis ist eine ArrayList
    * @param  pUnsortierteListe
    * @return SortierteListe
    */
   public ArrayList<WindradDatum> sortierenBubbleStyle(ArrayList<WindradDatum> pUnsortierteListe)
   {
	   WindradDatum lZwischenspeicher;
       ArrayList<WindradDatum> lSortierteListe = new ArrayList<WindradDatum>();
       lSortierteListe.addAll(pUnsortierteListe);
       //Fügen Sie hier Ihren Algorithmus ein

       for(int j=0; j<lSortierteListe.size(); j++)
    {
       for(int n=0; n<lSortierteListe.size()-1; n++)
    {
    	   if (lSortierteListe.get(n).getgeschwindigkeit() > lSortierteListe.get(n+1).getgeschwindigkeit())
    	   {
    		   lZwischenspeicher = lSortierteListe.get(n);
    		   lSortierteListe.set(n, lSortierteListe.get(n+1));
    		   lSortierteListe.set(n+1, lZwischenspeicher);
    	   }

    }

   }
	return lSortierteListe;
   }

   public ArrayList<WindradDatum> sortierenQuickStyle(ArrayList<WindradDatum> pListe)
   {
	   WindradDatum lVergleichselement;
	   ArrayList<WindradDatum> lRückgabeListe = new ArrayList<WindradDatum>();
	   ArrayList<WindradDatum> lGroßeListe = new ArrayList<WindradDatum>();
	   ArrayList<WindradDatum> lKleineListe = new ArrayList<WindradDatum>();
	   ArrayList<WindradDatum> lVergleichsListe = new ArrayList<WindradDatum>();
	   ArrayList<WindradDatum> lGroßeSortierteListe = new ArrayList<WindradDatum>();
	   ArrayList<WindradDatum> lKleineSortierteListe = new ArrayList<WindradDatum>();

	   if(pListe.size()> 1)
	   {
		   lVergleichselement = new WindradDatum(pListe.get(0).getzeitstempel(), pListe.get(0).getgeschwindigkeit());
	       //for(WindradDatum lWindradDatum: pListe)
		   for(int i=1; i<pListe.size();i++)
	         {
	             if (pListe.get(i).getgeschwindigkeit() < lVergleichselement.getgeschwindigkeit())
	                 {
		               lKleineListe.add(pListe.get(i));
	                 }
	             else
	             	{
	            	 lGroßeListe.add(pListe.get(i));
	             	}
	         }

	   lKleineSortierteListe=sortierenQuickStyle(lKleineListe);
	   lGroßeSortierteListe=sortierenQuickStyle(lGroßeListe);
	   lRückgabeListe.addAll(lKleineSortierteListe);
	   lRückgabeListe.add(lVergleichselement);
	   lRückgabeListe.addAll(lGroßeSortierteListe);
	   }
	   else
	   {
		   lRückgabeListe.addAll(pListe);
	   }
	return lRückgabeListe;
   }

   /**
    * Sortiert die Liste mit dem Bubblesortalgorithmus - Basis ist eine LinkedList
    * @param  pUnsortierteListe
    * @return SortierteListe
    */
   public LinkedList<WindradDatum> sortierenBubbleStyle(LinkedList<WindradDatum> pUnsortierteListe)
   {
	   WindradDatum lZwischenspeicher;
       LinkedList<WindradDatum> lSortierteListe = new LinkedList<WindradDatum>();
       lSortierteListe.addAll(pUnsortierteListe);
       //Fügen Sie hier Ihren Algorithmus ein

       for(int j=0; j<lSortierteListe.size(); j++)
       {
          for(int n=0; n<lSortierteListe.size()-1; n++)
       {
       	   if (lSortierteListe.get(n).getgeschwindigkeit() > lSortierteListe.get(n+1).getgeschwindigkeit())
       	   {
       		   lZwischenspeicher = lSortierteListe.get(n);
       		   lSortierteListe.set(n, lSortierteListe.get(n+1));
       		   lSortierteListe.set(n+1, lZwischenspeicher);
       	   }

       }

      }

       return lSortierteListe;
   }


   ArrayList<WindradDatum> sortierenMergeStyle(ArrayList<WindradDatum> pUnsortierteListe)
   {
	   ArrayList<WindradDatum> lLinkeListe = new ArrayList<WindradDatum>();
	   ArrayList<WindradDatum> lRechteListe = new ArrayList<WindradDatum>();
//	   ArrayList<WindradDatum> lGeteilteListe = new ArrayList<WindradDatum>();

	   if(pUnsortierteListe.size() <= 1)
	   {
		   return pUnsortierteListe;
	   }
	   else
	   {
		  lLinkeListe.addAll(pUnsortierteListe.subList(0, pUnsortierteListe.size()/2 -1));
		  lRechteListe.addAll(pUnsortierteListe.subList(pUnsortierteListe.size()/2 , 10));

		   lLinkeListe  = sortierenMergeStyle(lLinkeListe);
		   lRechteListe = sortierenMergeStyle(lRechteListe);

		   return mergenListen(lLinkeListe, lRechteListe);
	   }
   }

   ArrayList<WindradDatum> mergenListen(ArrayList<WindradDatum> lLinkeListe, ArrayList<WindradDatum> lRechteListe)
   {
	   ArrayList<WindradDatum> lSortiertereListe = new ArrayList<WindradDatum>();

	   while(!lLinkeListe.isEmpty() && !lRechteListe.isEmpty())
	   {
		   if(lLinkeListe.get(0).getGeschwindigkeit() <= lRechteListe.get(0).getGeschwindigkeit())
		   {
			   lSortiertereListe.add(lLinkeListe.get(0));
			   lLinkeListe.remove(0);
		   }
		   else
		   {
			   lSortiertereListe.add(lRechteListe.get(0));
			   lRechteListe.remove(0);
		   }
	   }
	   while(!lLinkeListe.isEmpty())
	   {
		   lSortiertereListe.add(lLinkeListe.get(0));
		   lLinkeListe.remove(0);
	   }

	   while(!lRechteListe.isEmpty())
	   {
		   lSortiertereListe.add(lRechteListe.get(0));
		   lRechteListe.remove(0);
	   }

	   return lSortiertereListe;
   }



// Getter Setter - generiert, deshalb werden hier die Namenskonventionen nicht eingehalten.
/**
 * @return the windradDatenAL
 */
public ArrayList<WindradDatum> getWindradDatenAL() {
    return windradDatenAL;
}

/**
 * @param pWindradDatenAL the windradDatenAL to set
 */
public void setWindradDatenAL(ArrayList<WindradDatum> pWindradDatenAL) {
    windradDatenAL = pWindradDatenAL;
}

/**
 * @return the windradDatenLL
 */
public LinkedList<WindradDatum> getWindradDatenLL() {
    return windradDatenLL;
}

/**
 * @param pWindradDatenLL the windradDatenLL to set
 */
public void setWindradDatenLL(LinkedList<WindradDatum> pWindradDatenLL) {
    windradDatenLL = pWindradDatenLL;
}




}
