
package practica5_kata;

import java.sql.*;
import practica5_kata.view.HistogramDisplay;
import practica5_kata.view.MailHistogramBuilder;
import practica5_kata.model.Histogram;
import java.util.List;
import practica5_kata.view.MailListReaderBD;

public class Practica5_kata {
    
    private static List<String> mailList;
    private static Histogram<String> mailHistogram;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        execute();
    }
    
    private static void execute() throws SQLException, ClassNotFoundException {
        input();
        process();
        output();
    }

    private static void input() throws SQLException, ClassNotFoundException {
        mailList = MailListReaderBD.read();
    }

    private static void process() {
        mailHistogram = MailHistogramBuilder.build(mailList);
    }

    private static void output() {
        new HistogramDisplay(mailHistogram).execute();
    }
}
    
    
