
package practica5_kata.view;


import practica5_kata.model.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {

    public static List<String> read() throws SQLException, ClassNotFoundException{
        
        Class.forName("org.sqlite.JDBC");
        List<String> list = new ArrayList<>();
        
        //creamos la conexión con la BD y creamos un statement
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db");
                Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery("SELECT email FROM people");
            while (set.next()) {
                Mail email = new Mail(set.getString("email"));
                if(MailParser.isMail(email.getMail())) {
                    list.add(email.getDomain());
                }
            }
        }
        return list;
    }    
}
