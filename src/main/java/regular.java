import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regular {
    public static void main(String[] args) {
 //       Pattern pattern = Pattern.compile("\\b[\\d]+\\b");
        //(\d+)...(\d+).*\s(\d)  три точки
        //(\d+):\s*((?<=\:\s).*) список
        //([0-9]*[.,]?[0-9])...([0-9]*[.,]?[0-9]).*\s([0-9]*[.,]?[0-9]) три точки с десятичными
        //([-]*[0-9]*[.,]?[0-9])...([-]*[0-9]*[.,]?[0-9]).* диапазон без шага
        // (\d+):\s*((?<=\:\s).*)\((.*)\) направления  иг север
        //(\d)\s\(([\w]*)\) тру и фолс
        //(\d+):\s*((?<=\:\s).*)\((.*)\) да нет в скобочках
        //(\d+):\s[<>]*\s?([0-9]*[.]?[0-9])[%]*\s?[-]?\s?([0-9]*[.]?[0-9])?(?=%) проценты непроценты

        String inputString = "1...255, step 1";
        String source = "0: Certificate extension \n" +
                "1: Configuration parameter \n" +
                "2: Extension and parameter \n" +
                "3: LDAP Server Only";

        String s1 = "0: < 0.2% \n" +
                "1: 0.2% - 0.4% \n" +
                "2: 0.4% - 0.8% \n" +
                "3: 0.8% - 1.6% \n" +
                "4: 1.6% - 3.2% \n" +
                "5: 3.2% - 6.4% \n" +
                "6: 6.4% - 12.8% \n" +
                "7: > 12.8% ";
        String s2 ="0: Not allowed (N) \n" +
                "1: Allowed (Y)";


        String pat = "(\\-?\\d+):\\s?(\\w.*)";

        Pattern pattern = Pattern.compile(pat);
        Matcher  matcher = pattern.matcher(s2);


        if(matcher.find()){
            System.out.println("horoso");
        }else {
            System.out.println("ploho");
        }











    }

}
