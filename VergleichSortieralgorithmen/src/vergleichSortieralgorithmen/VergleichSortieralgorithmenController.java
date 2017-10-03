/**
 * Controller f�r den Vergleich von drei unterschiedlichen Sortieralgorithmen auf zwei unterschiedlichen Listen.
 * @author Hr. Jakob 27.06.2016 angelegt
 * �berpr�ft 2.9.2017 auf ge�nderte Namenskonventionen
 */

package vergleichSortieralgorithmen;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.lang.Integer;

public class VergleichSortieralgorithmenController
{
    public VergleichSortieralgorithmen�bung aktuelleApplication;

    private static DBVerbindung         dbVerbindung = 		  new DBVerbindung();
    public ObservableList<WindradDatum> windradDatenOL = FXCollections.observableArrayList(
                                                              new WindradDatum (LocalDateTime.now().plusMinutes(20), 127),
                                                              new WindradDatum (LocalDateTime.now().minusMinutes(10), 123),
                                                              new WindradDatum (LocalDateTime.now(), 125),
                                                              new WindradDatum(LocalDateTime.now().plusMinutes(10), 124),
                                                              new WindradDatum(LocalDateTime.now().minusMinutes(20), 126),
                                                              new WindradDatum (LocalDateTime.now().plusMinutes(20), 128),
                                                              new WindradDatum (LocalDateTime.now().minusMinutes(10), 131),
                                                              new WindradDatum (LocalDateTime.now(), 132),
                                                              new WindradDatum(LocalDateTime.now().plusMinutes(10), 130),
                                                              new WindradDatum(LocalDateTime.now().minusMinutes(20), 129)
                                                                                        );
    private WindradDaten             windradDaten 			= new WindradDaten(windradDatenOL);
    private ArrayList<WindradDatum>  windradDatenALSortiert = new ArrayList<WindradDatum>();
    private LinkedList<WindradDatum> windradDatenLLSortiert = new LinkedList<WindradDatum>();



    @FXML
    public TextField tfAnzahlEintraege;

    @FXML
    private Label lbAnzahlEintraegeDB;

    @FXML
    private Label lbLaufzeitBubbleSortAL;

    @FXML
    private Label lbLaufzeitBubbleSortLL;

    @FXML
    private Label lbLaufzeitQuickSortAL;

    @FXML
    private Label lbLaufzeitQuickSortLL;

    @FXML
    private Label lbLaufzeitMergeSort;

    @FXML
    private Button btBubbleSort;

    @FXML
    private Button btQuickSort;

    @FXML
    private Button btMergeSort;

    @FXML
    private TableColumn<WindradDatum,LocalDateTime>	tcZeitstempel;

    @FXML
    private TableColumn<WindradDatum,Integer>	   	tcGeschwindigkeit;

    @FXML
    private TableView<WindradDatum> 				tvWindDaten;

    @FXML
    void sortierenBubbleStyle(ActionEvent event)
      {
         // Zeitstempel davor danach -> Duration-> Laufzeitfeld setzen, Tabelle f�llen

        Instant lEndZeitpunkt;
        Instant lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige n�chste Zeile aus und entfernen Sie die Kommentarzeichen an der darauf folgenden.
        // windradDatenALSortiert.sort(WindradDatum.geschwindigkeitKleinerAls);
           windradDatenALSortiert = windradDaten.sortierenBubbleStyle(windradDaten.getWindradDatenAL());

        lEndZeitpunkt = Instant.now();
        //Dauer in Anzeigefeld schreiben
        lbLaufzeitBubbleSortAL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).getNano()));

        //Laufzeitmessung mit Linked List
        lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige n�chste Zeile aus und entfernen Sie die Kommentarzeichen an der �bern�chsten.
        //windradDaten.getWindradDatenLL().sort(WindradDatum.geschwindigkeitKleinerAls);
        //windradDatenLLSortiert = windradDaten.sortierenBubbleStyle(windradDaten.getWindradDatenLL());

        lEndZeitpunkt = Instant.now();
        lbLaufzeitBubbleSortLL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).getNano()));
        windradDatenOL.clear();
        tvWindDaten.getItems().clear();
        windradDatenOL.addAll(windradDatenALSortiert);
        tvWindDaten.setItems(windradDatenOL);

      }
    @FXML
    void sortierenQuickStyle(ActionEvent event)
      {

    	// Zeitstempel davor danach -> Duration-> Laufzeitfeld setzen, Tabelle f�llen

        Instant lEndZeitpunkt;
        Instant lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige n�chste Zeile aus und entfernen Sie die Kommentarzeichen an der darauf folgenden.
        // windradDatenALSortiert.sort(WindradDatum.geschwindigkeitKleinerAls);
           windradDatenALSortiert = windradDaten.sortierenQuickStyle(windradDaten.getWindradDatenAL());

        lEndZeitpunkt = Instant.now();
        //Dauer in Anzeigefeld schreiben
        lbLaufzeitQuickSortAL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).getNano()));

        //Laufzeitmessung mit Linked List
        //lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige n�chste Zeile aus und entfernen Sie die Kommentarzeichen an der �bern�chsten.
        //windradDaten.getWindradDatenLL().sort(WindradDatum.geschwindigkeitKleinerAls);
        //windradDatenLLSortiert = windradDaten.sortierenBubbleStyle(windradDaten.getWindradDatenLL());

       // lEndZeitpunkt = Instant.now();
       // lbLaufzeitBubbleSortLL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).getNano()));
        windradDatenOL.clear();
        tvWindDaten.getItems().clear();
        windradDatenOL.addAll(windradDatenALSortiert);
        tvWindDaten.setItems(windradDatenOL);

      }


    @FXML
    void sortierenMergeStyle(ActionEvent event)

      {
        Instant lEndZeitpunkt;
        Instant lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige n�chste Zeile aus und entfernen Sie die Kommentarzeichen an der darauf folgenden.
        // windradDatenALSortiert.sort(WindradDatum.geschwindigkeitKleinerAls);
           windradDatenALSortiert = windradDaten.sortierenMergeStyle(windradDaten.getWindradDatenAL());

        lEndZeitpunkt = Instant.now();
        //Dauer in Anzeigefeld schreiben
        lbLaufzeitMergeSort.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).getNano()));

        //Laufzeitmessung mit Linked List
        //lStartZeitpunkt = Instant.now();
        // Wenn Sie Ihren Sortieralgorithmus in der Klasse WindradDaten fertig haben,
        // kommentieren Sie die bisherige n�chste Zeile aus und entfernen Sie die Kommentarzeichen an der �bern�chsten.
        //windradDaten.getWindradDatenLL().sort(WindradDatum.geschwindigkeitKleinerAls);
        //windradDatenLLSortiert = windradDaten.sortierenBubbleStyle(windradDaten.getWindradDatenLL());

       // lEndZeitpunkt = Instant.now();
       // lbLaufzeitBubbleSortLL.setText(String.valueOf(Duration.between( lStartZeitpunkt, lEndZeitpunkt ).getNano()));
        windradDatenOL.clear();
        tvWindDaten.getItems().clear();
        windradDatenOL.addAll(windradDatenALSortiert);
        tvWindDaten.setItems(windradDatenOL);
      }


    @FXML
    public void initialize()
      {

        LocalDateTime lLocalDateTime;
        ObservableList<TableColumn<WindradDatum,?>> lSpalten;
//    	if (dbVerbindung.verbinden("dbserver", "windkraftanlage", "dbuser", "benutzer")== false)
//		 {return;}
//      windradDatenOL = WindradDatum.auslesenDB(DBVerbindung.holenConnection());
        windradDatenALSortiert.addAll(windradDaten.getWindradDatenAL());

        lbAnzahlEintraegeDB.setText(String.valueOf( windradDatenOL.size()));

        tvWindDaten.setItems(windradDatenOL);

        tcZeitstempel.setCellValueFactory(new PropertyValueFactory<WindradDatum,LocalDateTime>("zeitstempel"));
        tcGeschwindigkeit.setCellValueFactory(new PropertyValueFactory<WindradDatum, Integer>("geschwindigkeit"));
      }

    public void setzenApplication(VergleichSortieralgorithmen�bung pApplication)
      {
        this.aktuelleApplication = pApplication;
      }

}