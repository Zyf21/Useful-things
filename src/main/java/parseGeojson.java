import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class parseGeojson {

	public static void main(String[] args) throws ParseException {

		List<String> list = new ArrayList<>();
		list.add("4");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("4");
		list.add("3");
		list.add("4");
		list.add("4");
		for (String site : list){
		//	System.out.println(site);
		}

		List<String> newList = list.stream()
				//.filter(l->l.equals("3"))
				.filter(l->l.equals("5") )
				.collect(Collectors.toList());
		for (String site : newList){
			System.out.println(site);
		}


		Long longDate = 1595734013000L;

//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//
//		Date date  = dateFormat.parse(longDate.toString());
//
//		System.out.println("Date : "+date);
//
//		SimpleDateFormat dateFormatNew = new SimpleDateFormat("dd/MM/yyyy");
//
//		String formattedDate = dateFormatNew.format(date);
//
//		System.out.println("Formatted date : "+formattedDate);

		Date date = new Date(longDate);
		Format format = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(format.format(date));

	}


}
