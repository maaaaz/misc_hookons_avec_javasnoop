package securecommunications;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message {
	public String content;
	public String title;
	
	public	Message(String input) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();	
		String now = dateFormat.format(cal.getTime()).toString();
		title = "YOLOSWAG";
		content = "<h1>" + title + " @ " + now + "</h1> : <h2>" + input + "</h2>";
	}
}