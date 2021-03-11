import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularMnogo {
	public static void main(String args[]) throws Exception {

		Pattern patternRange = Pattern.compile("^([-]*[0-9]*[.,]?[0-9])...([-]*[0-9]*[.,]?[0-9])(?:.*\\s([-]*[0-9]*[.,]?[0-9]))?");
		Pattern patternChar = Pattern.compile("(\\d+)\\.\\.\\.(\\d+)");
		Pattern patternBool = Pattern.compile("(\\d)\\s\\(([f|t][\\w]*)\\)");
		Pattern patternEnumeration = Pattern.compile("(\\-?\\d+):\\s?(.*)");

		Pattern location = Pattern.compile("(\\d+\\.\\d+) (\\d+\\.\\d+)");

		Double n = 4.5;
		Double min = 0.0;
		Double max = 7.5;
		Double step = 0.5;
		if (n >= min && n <= max && (n - min) % step == 0.0){
			System.out.println("norm");
		} else {
			System.out.println("ne norm");
		}


		String cell = "4...45077 ns, step 1 ns";
		String cell2 ="Bit 0:4.75 kbit/s:1:N; Bit 1:5.15 kbit/s:0:N; Bit 2:5.90 kbit/s:1:N; Bit 3:6.70 kbit/s:0:N; \n" +
				"Bit 4:7.40 kbit/s:1:N";
		String cell3 = "0:(GMT-11) Etc/GMT+11;\n" +
				"2:(GMT-11) Pacific/Apia;\n" +
				"3:(GMT-11) Pacific/Midway;\n" +
				"4:(GMT-11) Pacific/Niue;\n" +
				"5:(GMT-11) Pacific/Pago_Pago;\n" +
				"6:(GMT-11) Pacific/Samoa;\n" +
				"7:(GMT-11) US/Samoa;\n" +
				"8:(GMT-10) America/Adak;";

		String cell45 = "41.9863586 23.9491158,41.983055 23.9363861,41.979721 23.9163857,41.9783324 23.894165,41.9747162 23.8713875,41.9736098 23.851944,41.9738845 23.810276,41.9763869 23.7891655,41.9841613 23.7683296";

		//Enumeration
		List<String> enumerationNumbers  = new ArrayList<>();
		List<String> enumerationValues  = new ArrayList<>();
		Map<String, String> maps = new HashMap<>();
		//Range with step
		Double rangeStart;
		Double rangeEnd;
		Double rangeStep;
		//Characters
		String charStart;
		String charEnd;
		//Bool
		List<String> boolNumbers  = new ArrayList<>();
		List<String> boolValues  = new ArrayList<>();

		Matcher matcherRange = patternRange.matcher(cell2);
		Matcher matcherChar= patternChar.matcher(cell2);
		Matcher matcherEnumeration = patternEnumeration.matcher(cell2);
		Matcher matcherBool = patternBool.matcher(cell2);
		Matcher matcherLocal = location.matcher(cell45);



//		maps.put(matcherLocal.group(1), matcherLocal.group(2));
		if (matcherLocal.lookingAt()) {
			do {
				maps.put(matcherLocal.group(1), matcherLocal.group(2));
			} while (matcherLocal.find());



			for (Map.Entry<String, String> set : maps.entrySet()){
				System.out.println(set.getKey() + " "+ set.getValue());
			}
			System.out.println(matcherLocal.group(2));
		}

//		BufferedReader br = new BufferedReader(new FileReader("text.txt"));
//		String everything;
//		try {
//			StringBuilder sb = new StringBuilder();
//			String line = br.readLine();
//
//			while (line != null) {
//				sb.append(line);
//				sb.append(System.lineSeparator());
//				line = br.readLine();
//			}
//			 everything = sb.toString();
//			//System.out.println(everything);
//		} finally {
//			br.close();
//		}
//
//		List<String> allMatches = new ArrayList<String>();
//		Matcher m = Pattern.compile("(\\d+\\.\\d+) (\\d+\\.\\d+)")
//				.matcher(cell45);
//		while (m.find()) {
//			maps.put(m.group(1), m.group(2));
//		}
//
//		for (Map.Entry<String, String> set : maps.entrySet()){
//				System.out.println(set.getKey() + " "+ set.getValue());
//			}






		if(matcherEnumeration.lookingAt()){

		do {
			enumerationNumbers.add(matcherEnumeration.group(1));
			enumerationValues.add(matcherEnumeration.group(2));
		}while (matcherEnumeration.find());
			for (String s : enumerationNumbers){
				System.out.println(s);
			}
			for (String s : enumerationValues){
				System.out.println(s);
			}
		}else if(matcherRange.lookingAt()){
			rangeStart = Double.valueOf(matcherRange.group(1));
			rangeEnd = Double.valueOf(matcherRange.group(2));
			rangeStep = Double.valueOf(matcherRange.group(3));
			System.out.println(rangeStart +" "+rangeEnd +" "+rangeStep);

		} else if(matcherChar.lookingAt()){
			charStart = matcherChar.group(1);
			charEnd = matcherChar.group(2);
			System.out.println(charStart +" "+charEnd);

		}else if(matcherBool.lookingAt()){
			do {
				boolNumbers.add(matcherBool.group(1));
				boolValues.add(matcherBool.group(2));
			}while (matcherBool.find());


		}




	}




}
