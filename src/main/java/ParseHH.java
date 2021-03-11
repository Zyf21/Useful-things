import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseHH {
	public static void main(String[] args) throws IOException, ParseException {

		long startTime = System.currentTimeMillis();
		List<String> vacantiesIds = new ArrayList<>();
		List<String> vacantiesNames= new ArrayList<>();
		//List<String> scils= new ArrayList<>();
		Map<String, List<String>> mapa = new HashMap<>();
		final Content getResult = Request.Get("https://api.hh.ru/vacancies?text=java&area=16&search_field=name&per_page=100")
				.execute().returnContent();
//		System.out.println(getResult.asString());
		//per_page=100

		Object obj = new JSONParser().parse(getResult.asString());

		JSONObject jo = (JSONObject) obj;
		JSONArray phoneNumbersArr = (JSONArray) jo.get("items");
		Long pages = (Long) jo.get("pages");
		System.out.println("6666666666666666666666666666666666666666"+pages);
		for(int i =1; i<=pages; i++){
			final Content getResultPage = Request.Get("https://api.hh.ru/vacancies?text=java&area=16&search_field=name&per_page=100&page=" + i)
					.execute().returnContent();
			Object objPage = new JSONParser().parse(getResultPage.asString());
			JSONObject joPage = (JSONObject) objPage;
			JSONArray phoneNumbersArrPage = (JSONArray) joPage.get("items");
			phoneNumbersArr.addAll(phoneNumbersArrPage);

		}


		for (Object jsonArray : phoneNumbersArr){
			JSONObject test = (JSONObject) jsonArray;
			JSONObject structure = (JSONObject) test.get("area");
			vacantiesIds.add(test.get("id").toString());
			//System.out.println("Id " + test.get("id") + ", phone: " + test.get("name") +" " + structure.get("name"));
		}
		int t = 1;
		for (String s : vacantiesIds){
			System.out.println(s);
			final Content getResultId = Request.Get("https://api.hh.ru/vacancies/" + s)
					.execute().returnContent();
//			System.out.println(getResult.asString());
			Object objid = new JSONParser().parse(getResultId.asString());
			JSONObject joid = (JSONObject) objid;

			String name = (String) joid.get("name");
			vacantiesNames.add(name + t);

			List<String> scils= new ArrayList<>();
			JSONArray Arr = (JSONArray) joid.get("key_skills");

			for (Object jsonArray : Arr){
				JSONObject test = (JSONObject) jsonArray;

				scils.add(test.get("name").toString());
				//System.out.println(test.get("name"));

				//vacantiesIds.add(test.get("id").toString());
				//System.out.println("Id " + test.get("id") + ", phone: " + test.get("name") +" " + structure.get("name"));
			}
			mapa.put(name+t,scils);
			t++;


		}
		int i = 1;
		for (Map.Entry<String, List<String>> name :mapa.entrySet()){
			System.out.println(i + " "+ name.getKey() + "  " + name.getValue());
			i++;
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime)/1000 +" секунд  Всего вакансий:" +vacantiesIds.size() );
		System.out.println(pages);

}

//		Iterator phonesItr = phoneNumbersArr.iterator();
//		System.out.println("phoneNumbers:");
//// Выводим в цикле данные массива
//		while (phonesItr.hasNext()) {
//			JSONObject test = (JSONObject) phonesItr.next();
//			System.out.println("Id " + test.get("id") + ", phone: " + test.get("name"));
//		}
	}

