import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ed {
	public static void main(String[] args) {
		List<String> emails = new ArrayList();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user#@domain.co.in");
		emails.add("user@domaincom");

//Invalid emails
		emails.add("user#domain.com");
		emails.add("@yahoo.com");
		emails.add("@yahoo.com");
		emails.add("username@yahoo.corporate");
		emails.add("username@yahoo..com");


		String regex = "^(.+)@(.+)$";
		String regex2 = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String regex3 = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";



//		Pattern pattern = Pattern.compile(regex2);
//
//		for (String email : emails) {
//			Matcher matcher = pattern.matcher(email);
//			System.out.println(email + " : " + matcher.matches());
//		}


		String text = "Central-E124";
		Pattern pattern2 = Pattern.compile("[^\\d\\.]+");
		Matcher matcher = pattern2.matcher(text);
		//String tew = text.replaceAll("[^\\d\\.]+","RRR");
		String tew = text.replaceAll("[a-zA-Z]+[-]","");
		System.out.println(tew);


	}
}

