package PortProbe;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class PortProbeModel {

    // Methode zur Überprüfung eines Ports
    public String probe(String ip, int port) {
        try (Socket socket = new Socket()) {
            InetSocketAddress address = new InetSocketAddress(ip, port);
            // Timeout für die Verbindung setzen (3 Sekunden)
            socket.connect(address, 3000);
            return "Port " + port + " is OPEN.";
        } catch (SocketTimeoutException e) {
            // Verbindung hat den Timeout erreicht
            return "Port " + port + " is STEALTHED.";
        } catch (IOException e) {
            // Verbindung wurde aktiv verweigert oder andere Fehler
            if (e.getMessage().contains("Connection refused")) {
                return "Port " + port + " is CLOSED.";
            }
            return "Error: " + e.getMessage();
        }
    }
}