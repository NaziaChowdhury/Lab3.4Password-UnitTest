
import com.sun.jdi.connect.Connector;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class Password {
	// creating a passwordlist to store all the valid passwords
	static ArrayList<String> passwordList = new ArrayList<>();

	// this method checks if the password contains at least a number except 6
	public static boolean containsNum(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '6') {
				return false;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3'
					|| s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '7' || s.charAt(i) == '8'
					|| s.charAt(i) == '9')
				return true;

		}
		return false;
	}

	// this method checks if the password contains any prime number without 6
	public static boolean containsPrimeNum(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '6') {
				return false;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '5' || s.charAt(i) == '7')
				return true;

		}
		return false;
	}

	// this method checks if the password contains at least 2 vowels in upper case
	public static boolean containsVowels(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O'
					|| s.charAt(i) == 'U' || s.charAt(i) == 'Y')
				count++;
		}
		if (count >= 2)
			return true;
		return false;
	}

	// this method checks if today is tuesday then "Taco" substring is present in
	// the paasword or not
	public static boolean day(String s) {
		// creating an object of calender class
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		// getting the current day in integar form
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		// tuesday is 3 in integar
		if (dayOfWeek == 3) {
			if (s.contains("Taco"))
				return true;
			else
				return false;
		}
		return true;
	}

	// this method checks if the current itme is between midnight and 1 am or not
	public static boolean time(String s) {
		// getting the current time
		String ss = LocalTime.now().toString();
		// getting the hour
		String[] arr = ss.split(":");
		// converting hour to string
		int t = Integer.parseInt(arr[0]);
		if (t >= 12 && t <= 1) {
			if (s.equals("Red Rum") || s.equals("Spooky"))
				return true;
		}
		return false;
	}

	public static boolean addPassword(String s) {
		boolean ans = true;

		if (passwordList.contains(s)) {
			ans = false;
		}
		if (!(s.length() > 7 && s.length() < 12)) {
			ans = false;
		}

		if (!containsNum(s)) {
			ans = false;
		}
		if (s.contains(" ")) {
			ans = false;
		}

		if (!containsVowels(s)) {
			ans = false;
		}
		if (s.equals("admin") && !passwordList.contains("admin")) {
			passwordList.add(s);
			return true;
		}
		if (s.equals("admin") && passwordList.contains("admin")) {
			return false;
		}
		if (s.equals("mod") && !passwordList.contains("mod")) {
			passwordList.add(s);
			return true;
		}
		if (s.equals("mod") && passwordList.contains("mod")) {

			return false;
		}
		if (!containsPrimeNum(s)) {
			ans = false;
		}
		if (!day(s))
			ans = false;
		if (time(s)) {
			return true;
		}

		if (ans == true) {

			passwordList.add(s);
			// System.out.println(passwordList);

		}

		// System.out.println(ans);
		return ans;

	}

	public static void main(String[] args) {

	}
}
