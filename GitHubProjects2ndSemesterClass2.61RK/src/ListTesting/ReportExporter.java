package ListTesting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportExporter {

    public static void exportToCSV(String filePath, List<String[]> data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}