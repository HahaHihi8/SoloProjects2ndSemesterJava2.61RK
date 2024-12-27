package PortProbe;

import javafx.scene.control.Button;

public class PortProbeController {

    private final PortProbeModel model;
    private final PortProbeView view;

    public PortProbeController(PortProbeModel model, PortProbeView view) {
        this.model = model;
        this.view = view;

        // Aktion für den allgemeinen Probe-Button
        view.probeButton.setOnAction(e -> {
            String ip = view.ipField.getText();
            String portText = view.portField.getText();
            try {
                int port = Integer.parseInt(portText);
                String result = model.probe(ip, port);
                view.resultLabel.setText(result);
            } catch (NumberFormatException ex) {
                view.resultLabel.setText("Invalid port number. Please enter a numeric value.");
            }
        });

        // Aktionen für die spezifischen Port-Buttons
        view.commonPorts.forEach((description, port) -> {
            for (var node : view.layout.getChildren()) {
                if (node instanceof Button button && button.getText().contains(description)) {
                    button.setOnAction(e -> {
                        // Setze die Werte in die Textfelder und prüfe den Port
                        view.ipField.setText("127.0.0.1"); // Beispiel-IP (kann angepasst werden)
                        view.portField.setText(String.valueOf(port));

                        String ip = view.ipField.getText();
                        String portText = view.portField.getText();
                        try {
                            int parsedPort = Integer.parseInt(portText);
                            String result = model.probe(ip, parsedPort);
                            view.resultLabel.setText(result);
                        } catch (NumberFormatException ex) {
                            view.resultLabel.setText("Invalid port number. Please enter a numeric value.");
                        }
                    });
                }
            }
        });
    }
}
