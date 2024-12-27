package PortProbe;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;

public class PortProbeView {

    public TextField ipField = new TextField();
    public TextField portField = new TextField();
    public Button probeButton = new Button("Probe Port");
    public Label resultLabel = new Label();
    public VBox layout = new VBox(10);

    public HashMap<String, Integer> commonPorts = new HashMap<>();

    public PortProbeView() {
        // Define common ports and their usages
        commonPorts.put("FTP Data", 20);
        commonPorts.put("FTP Control", 21);
        commonPorts.put("SSH", 22);
        commonPorts.put("Telnet", 23);
        commonPorts.put("SMTP", 25);
        commonPorts.put("DNS", 53);
        commonPorts.put("HTTP", 80);
        commonPorts.put("POP3", 110);
        commonPorts.put("NNTP", 119);
        commonPorts.put("NTP", 123);
        commonPorts.put("IMAP", 143);
        commonPorts.put("SNMP", 161);
        commonPorts.put("IRC", 194);
        commonPorts.put("HTTPS", 443);

        initializeCommonPortButtons();

        // Add general probe button and fields
        layout.getChildren().addAll(
            new Label("IP Address:"), ipField,
            new Label("Port Number:"), portField,
            probeButton,
            resultLabel
        );
    }

    public void initializeCommonPortButtons() {
        commonPorts.forEach((description, port) -> {
            Button portButton = new Button(description + " (Port " + port + ")");
            layout.getChildren().add(portButton);
        });
    }

    public void start(Stage stage) {
        Scene scene = new Scene(layout, 500, 600); 
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("PortProbe.css").toExternalForm());
        stage.setTitle("Port Probe");
        stage.setMinWidth(500);
        stage.setMinHeight(850);
        stage.show();
    }
}
