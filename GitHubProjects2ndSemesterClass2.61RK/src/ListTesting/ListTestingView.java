package ListTesting;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ListTesting.ListTestingModel.LIST_TYPES;
import ListTesting.ListTestingModel.WHERE_CHOICES;

public class ListTestingView {
	private Stage stage;
	private ListTestingModel model;

	protected final Integer[] DATA_AMOUNTS = {10000,30000,100000,300000,1000000};

	private Label lblNumElements = new Label("Amount of data");
	protected ComboBox<Integer> cmbNumElements = new ComboBox<>();
	private Label lblListType = new Label("List type");
	protected ComboBox<LIST_TYPES> cmbListType = new ComboBox<>();
	private Label lblWhereToAdd = new Label("Add elements at");
	protected ComboBox<WHERE_CHOICES> cmbWhere = new ComboBox<>();
	protected Button btnGo = new Button("Run test");
	protected Label lblResult = new Label();
	private Label lblOperation = new Label("Operation");
	protected ComboBox<String> cmbOperation = new ComboBox<>();
	protected Button btnExport = new Button("Export Report");
	
	public ListTestingView(Stage stage, ListTestingModel model) {
		this.stage = stage;
		this.model = model;

		cmbNumElements.getItems().setAll(DATA_AMOUNTS);
		cmbNumElements.setValue(DATA_AMOUNTS[0]);
		
		cmbListType.getItems().setAll(LIST_TYPES.values());
		cmbListType.setValue(LIST_TYPES.ArrayList);
		
		cmbWhere.getItems().setAll(WHERE_CHOICES.values());
		cmbWhere.setValue(WHERE_CHOICES.Start);
		
		cmbOperation.getItems().setAll("Add", "Search"); 
		cmbOperation.setValue("Add");
		
		GridPane grid = new GridPane();
		grid.addRow(0, lblNumElements, cmbNumElements);
		grid.addRow(1, lblListType, cmbListType);
		grid.addRow(2, lblWhereToAdd, cmbWhere);
		grid.addRow(3, lblOperation, cmbOperation);
		
		VBox root = new VBox(grid, btnGo, btnExport, lblResult);
		root.getStyleClass().add("vbox");

        Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("styles.css").toExternalForm());        
        stage.setScene(scene);
        stage.setTitle("List testing");
	}

	public void start() {
		stage.show();
	}

}
