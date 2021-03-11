import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {


	public static void main(String[] args) throws IOException {

		List<String> list = new ArrayList<>();
		list.add("Минск");
		list.add("Москва");
		list.add("Киев");
		list.add("Варшава");
		list.add("Минск");

		List<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(6);




		//Set<String> set=l
	list.stream().map(s ->{
			if (s.contains("ва")
			) {
				s = s.concat(" чума");

			}return s;

			//}).collect(Collectors.toList());
			}).forEach(p -> System.out.println(p));

	list.stream().collect(Collectors.toSet());

	list.stream()
			.filter(el ->el.length() >5)
			.forEach(System.out::println);
		List<String> rr= list.stream()
				.map(String::toUpperCase)
				.peek((e) -> System.out.print("," + e))
				.collect(Collectors.toList());
		System.out.println(rr);


		List<Integer> lis22 = new ArrayList<>();
		lis22.add(1);
		lis22.add(3);
		lis22.add(1);
		lis22.add(1);
		lis22.add(1);

		lis22.stream()
				.filter(s->s>2)
				.map(s->s+1)
				.forEach(p->System.out.println(p));


//		String a = "string a";
//		String n = "string a";
//		String b = new String("string a");
//		String c = b.intern();
//		String w = a.intern();
//
//		System.out.println(a == b);
//		System.out.println(b == c);
//		System.out.println(a == c);
//		System.out.println(w == a);
//		System.out.println(n == a);
//		System.out.println(a.equals(c));

//		Integer log =list2.stream().max(Integer::compareTo).get();
//		System.out.println(log);

//		String s1 = new String("ABC");
//		String s2 = new String("ABC");
//		String s3 = "ABC";
//		String s4 = "ABC";
//		System.out.println(s1==s2);
//		System.out.println(s3==s4);
//		System.out.println(s1.equals(s2));
//
//		s1=s2;
//		System.out.println(s1==s2);
//		if("someString" == "someString") {
//			System.out.println("true");
//		}
//		System.out.println(s1.compareTo(s2));
//		System.out.println("C".compareTo("A"));
//		System.out.println("wer".compareTo("weu"));

//		String firstStr = "first ";
//		String secondStr = firstStr + "second ";
//		firstStr.concat("third ");
//		secondStr.concat(firstStr);
//		firstStr += "fouth ";
//		System.out.println(firstStr + " " + secondStr);
//
//		String f1 = "3333";
//		String s2 = f1.concat("44444");
//		System.out.println(s2);
//
//		String output = "Some text";
//		int count = 100;
//		for(int i =0; i<count; i++) {
//			output += i;
//		}
//		System.out.println(output);

		//File tmpDir = new File("zipFiles/ret/");
		//File[] files= new File("/pdfFiles/").listFiles();
		//File[] files= new File("/home/dmtech/IdeaProjects/Useful-things/pdfFiles/www/").listFiles();

		String path = "/home/dmtech/IdeaProjects/Useful-things/pdfFiles/www";
		//File[] files= new File("/files").listFiles();
		File[] files= new File(path).listFiles();
//		System.out.println(Objects.isNull(files));
//		System.out.println(files.equals(null));
//
//		System.out.println("что то есть "+!Objects.isNull(files));
//		System.out.println(checkForFiles(path));
//		System.out.println(checkForFiles2(path));
		System.out.println(checkForFiles(path));


	}

//	public static boolean checkForFiles(String path) {
//		Path FilePath = Paths.get(path);
//		return Objects.requireNonNull(FilePath.toFile().listFiles()).length == 0;
//	}
//
//	public static boolean checkForFiles2(String path) {
//		File file = new File(path);
//		return file.length() == 0;
//	}

//	public static boolean isDirectoryEmpty(String path) {
//		File directory = new File(path);
//		String[] files = directory.list();
//		return files.length == 0;
//	}



	public static boolean checkForFiles(String path) {
		File directory = new File(path);
		String[] files = directory.list();
		return files.length == 0;
	}


}


