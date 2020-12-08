
package practica5_kata.view;

import practica5_kata.model.Histogram;
import java.util.List;

public class MailHistogramBuilder {

    public static Histogram<String> build(List<String> mailList) {
        Histogram<String> histogram = new Histogram();
        for(String mail : mailList) {
            histogram.increment(mail);
        }
        return histogram;
    }
    
}
