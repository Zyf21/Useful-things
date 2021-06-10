import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kembrige {
    public static void main(String[] args) throws IOException, ParseException {
        //getUrl();
       // getDoc();
        //cred();
        //setLatLon();
        reg();

    }
    public static void setLatLon() throws IOException {
        String x = "    var markers = [\n" +
                "    \n" +
                "             {\n" +
                "                \"title\": 'Location of Lat/Lng, please login to view results',\n" +
                "                \"lat\": '52.562500',\n" +
                "                \"lng\": '-0.176203',\n" +
                "                \"description\": '<br> Within 7000 metres of \"Lat/Lng\" we have identified  490 records: <br>- 221 Masts and Telecom Structures <br>- 269 LPA Planning applications <br>To view the results please click the link above to login or set up a free 30 day trial',\n" +
                "                \"URL\": '../0/login/login.aspx',\n" +
                "                \"TypeName\": '',\n" +
                "                \"Marker\": 'siteshareL.png'\n" +
                "            }\n" +
                "    \n" +
                "    ];";
//        Matcher m = Pattern.compile("\\[(.*?)\\]", Pattern.MULTILINE).matcher(x);
//        while (m.find()) {
//            System.out.println(m.group(1));
//        }

        Pattern pattern = Pattern.compile("\\[(.*?)\\]",  Pattern.MULTILINE + Pattern.DOTALL);
        Matcher matcher = pattern.matcher(x);

// Find all matches
        String match = null;
        String match2 = null;
        while (matcher.find()) {
            // Get the matching string
             match = matcher.group(1);
             match2 = matcher.group();
        }
        System.out.println(match);
        System.out.println(match2);

    }

    public static void reg(){

        String input = "             {\n" +
                "                \"title\": 'Orange CAM7064:Orange Site(26.50m)',\n" +
                "                \"lat\": '52.561396',\n" +
                "                \"lng\": '-0.143790',\n" +
                "                \"description\": 'Peterborough, (2.201000 km from Lat/Lng)<br><a href=\"37_map_mobile_mast.aspx?Table=15&AdTyID=43&Lng=-0.143790&Lat=52.561396&z=16\">Click to centre on this location</a>',\n" +
                "                \"URL\": '../portal/mast.aspx?AdID=76626',\n" +
                "                \"TypeName\": 'Address',\n" +
                "                \"Marker\": 'Orange.png'\n" +
                "            }\n" +
                "    \n" +
                "        ,\n" +
                "    \n" +
                "             {\n" +
                "                \"title\": 'Wind Farm Coldham:Coldham',\n" +
                "                \"lat\": '52.574700',\n" +
                "                \"lng\": '-0.145833',\n" +
                "                \"description\": ' (2.466000 km from Lat/Lng)<br><a href=\"37_map_mobile_mast.aspx?Table=15&AdTyID=43&Lng=-0.145833&Lat=52.574700&z=16\">Click to centre on this location</a>',\n" +
                "                \"URL\": '../portal/mast.aspx?AdID=290697',\n" +
                "                \"TypeName\": 'Address',\n" +
                "                \"Marker\": 'windfarm.png'\n" +
                "            }";
        List<String> ids =new ArrayList<String>();
        Pattern pattern = Pattern.compile("AdID=(\\d*)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            ids.add(matcher.group(1));
           // System.out.println(matcher.group(1));
        }
        System.out.println(ids);
    }



    public static void  getUrl() throws IOException {
        final Content getPage = Request.Get("https://www.mastdata.com/portal/map_mobile_mast.aspx?Table=15&AdTyID=43&Lng=-0.176203&Lat=52.5625&z=16&PT=Easting:%20Northing:")
                .execute().returnContent();
        System.out.println(getPage.toString());

    }

    public static void getDoc() throws IOException, ParseException {
        Document doc = Jsoup.connect("https://www.mastdata.com/portal/map_mobile_mast.aspx?Table=15&AdTyID=43&Lng=-0.176203&Lat=52.5625&z=16&PT=Easting:%20Northing:").get();
        //Element form = doc.head();
        Elements form = doc.head().getElementsByTag("script");

        for (Element tag : form){
            if(tag.data().contains("markers")) {

                for (DataNode node : tag.dataNodes()) {
                   // System.out.println(node.getWholeData());
                    Pattern pattern = Pattern.compile("\\[(.*?)\\]",  Pattern.MULTILINE + Pattern.DOTALL);
                    Matcher matcher = pattern.matcher(node.getWholeData());

// Find all matches
                    String match = null;
                    String match2 = null;
                    while (matcher.find()) {
                        // Get the matching string
                        match = matcher.group(1);
                        match2 = matcher.group();
                    }
                   // System.out.println(match);
                   // System.out.println("{ \"test\":" + match2 + "}");
                    //String json1 = "{ test:" + match2 + "}";
                    String nexJson =  match2.replace("'","\"");
                    String json = "{ \"test\":"+ nexJson + "}";
                    System.out.println(json);
                    Scanner scanner = new Scanner(json);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        //System.out.println(line + " 44444");
                        if(line.startsWith("                \"URL\":")){
                            System.out.println(line);

                        }
                    }
                    scanner.close();

//                    Object firstPage = new JSONParser().parse(json);
//                    JSONObject firstPageJson = (JSONObject) firstPage;
//                    JSONArray locationsArray = (JSONArray) firstPageJson.get("test");
//
//                    List<String> vacantiesIds = new ArrayList<>();
//                    for (Object vacancy : locationsArray) {
//                        JSONObject vacancyJson = (JSONObject) vacancy;
//                        vacantiesIds.add(vacancyJson.get("URL").toString());
//                        System.out.println(vacancyJson.get("URL").toString());
//                    }
                }
        }

            }


    }


    public  static void cred() throws IOException {
        Connection.Response loginForm = Jsoup.connect("https://mastdata.com/account/login.aspx")
                .method(Connection.Method.GET)
                .execute();
        Document logindoc = loginForm.parse();
        Element element = logindoc.select("input[id=__VIEWSTATE]").first();
        String viewState = element.attr("value");
        element = logindoc.select("input[id=__EVENTVALIDATION]").first();
        String eventValidation = element.attr("value");
        element = logindoc.select("input[id=__VIEWSTATEGENERATOR]").first();
        String viewStateGeneration = element.attr("value");

        Connection.Response loginResponse = Jsoup.connect("https://mastdata.com/account/login.aspx")
                .data("txtUsername", "awtg")
                .data("txtPassword", "awtg1234")
                .data("SubmitButton", "LOG IN")
                .data("_VIEWSTATE", viewState)
                .data("_VIEWSTATEGENERATOR", viewStateGeneration)
                .data("_EVENTVALIDATION", eventValidation)
                .method(Connection.Method.POST)
                .execute();

        Map<String, String> loginCookies = loginResponse.cookies();
        System.out.println(loginCookies);

        Document doc = Jsoup.connect("https://www.mastdata.com/portal/map_mobile_mast.aspx?Table=15&AdTyID=43&Lng=-0.176203&Lat=52.5625&z=16&PT=Easting:%20Northing:")
                .cookies(loginCookies)
                .get();
        System.out.println(doc);
    }
}
