package ListTesting;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import ListTesting.ListTestingModel.LIST_TYPES;
import ListTesting.ListTestingModel.WHERE_CHOICES;

public class ListTestingController {
    private ListTestingModel model;
    private ListTestingView view;
    private List<String[]> reportData = new ArrayList<>(); // Zum Speichern der Ergebnisse

    private final DecimalFormat timeFormatter = new DecimalFormat("0.000");

    public ListTestingController(ListTestingModel model, ListTestingView view) {
        this.model = model;
        this.view = view;

        view.btnGo.setOnAction(this::setUpTest);
        view.btnExport.setOnAction(e -> exportReport());
    }     
    
    private void setUpTest(ActionEvent e) {
        Integer amountOfData = view.cmbNumElements.getValue();
        LIST_TYPES listType = view.cmbListType.getValue();
        String operation = view.cmbOperation.getValue();

        float runTime;
        if (operation.equals("Add")) {
            runTime = model.runTest(amountOfData, listType, view.cmbWhere.getValue());
        } else { // Search
            runTime = model.searchTest(amountOfData, listType);
        }

        view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");

        // Ergebnis in Bericht speichern
        String whereChoice = model.isWhereChoicesApplicable(listType) ? view.cmbWhere.getValue().name() : "N/A";
        reportData.add(new String[]{
            listType.name(), 
            operation, 
            amountOfData.toString(), 
            timeFormatter.format(runTime), 
            whereChoice
        });

        // Speicherbereinigung (optional)
        System.gc();
    }

    // Methode zum Exportieren des Berichts
    public void exportReport() {
        try {
            // Füge Header hinzu, wenn Daten vorhanden sind
            if (!reportData.isEmpty()) {
                List<String[]> dataWithHeader = new ArrayList<>();
                dataWithHeader.add(new String[]{"List Type", "Operation", "Data Amount", "Time (s)", "Adding where"});
                dataWithHeader.addAll(reportData);

                // Exportiere Daten
                ReportExporter.exportToCSV("report.csv", dataWithHeader);
                System.out.println("Report exported successfully to report.csv");
            } else {
                System.out.println("No data to export.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
