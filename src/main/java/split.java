import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class split {
    public static void main(String[] args) throws IOException, DocumentException {

        String test = "5.5 cord complication,ADVPARAMEDIC,EMRGMEDICALTECH,PARAMEDIC";

        String[] result = test.split("\\,");
        List<String> roles = new ArrayList();
        String name = result[0];
        for (int i = 1; i < result.length; i++) {
             roles.add(result[i]);
        }
        System.out.println(name);
        for (String i: roles){
            System.out.println(i);

        }

     //   Map.Entry<String, List<MedicRoles>> splitLine = new AbstractMap.SimpleEntry<String, List<MedicRoles>>(namePdfContent,rolesPdf );
    }
}
