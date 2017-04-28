package example12.src.main.java.com.treehouse.reviews;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;

/**
 * Created by jorgeotero on 4/20/17.
 */
public class Main {
    public static void main(String[] args) {
        try {
            CSVPrinter printer = new CSVPrinter(System.out, CSVFormat.EXCEL);
            printer.printRecord("Jesus", "Maldonado", 5, "Great");
            printer.printRecord("Jorge", "Eliecer", "Otero", 4, "Very, Good");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
