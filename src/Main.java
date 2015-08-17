import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// get html
		URL url = new URL("http://www.arenamate.net/arena-rbg-title-cutoffs");
		InputStream is = url.openStream();
		int ptr = 0;
		StringBuffer buffer = new StringBuffer();
		while ((ptr = is.read()) != -1) {
		    buffer.append((char)ptr);
		}
		String html = buffer.toString();
		
		// get data
	    Document document = Jsoup.parse(html);
	    Elements divs = document.select("table");
	    /*
	     * 1 - has all titles
	     */
	    
	    String noteworthyText = divs.get(0).html();
	    
	    // extract data into list
	    
	    List <String> rating = extract("<strong>", "</strong>", noteworthyText);
	    List <String> players = extract("<td>", "</td>", noteworthyText);
	    
	    // put it together
	    int r1 = Integer.parseInt(rating.get(0));
	    int glad = Integer.parseInt(rating.get(1));
	    int duelist = Integer.parseInt(rating.get(2));
	    int rival = Integer.parseInt(rating.get(3));
	    int challenger = Integer.parseInt(rating.get(4));
	    
	    int r1_count = Integer.parseInt(players.get(1));
	    int glad_count = Integer.parseInt(players.get(3));
	    int duelist_count = Integer.parseInt(players.get(5));
	    int rival_count = Integer.parseInt(players.get(7));
	    int challenger_count = Integer.parseInt(players.get(9));
	    
	    
	    String data = "\n##### ";
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    data += dateFormat.format(date);
	    data += " #####";
	    data += "\nrank 1     \t" + r1 + "\t" + r1_count;
	    data += "\ngladiator  \t" + glad + "\t" + glad_count;
	    data += "\nduelist    \t" + duelist + "\t" + duelist_count;
	    data += "\nrival      \t" + rival + "\t" + rival_count;
	    data += "\nchallenger \t" + challenger + "\t" + challenger_count;
	    
	    write(data);
	}
	
	private static List<String> extract(String pattern1, String pattern2, String text){
		List<String> list = new ArrayList<String>();
		 Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
		    Matcher m = p.matcher(text);
		    while (m.find()) {
		      System.out.println(m.group(1));
		      list.add(m.group(1));
		    }
		    return list;
	}
	
	private static void write(String content) throws IOException{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("data", true)));
		out.println(content);
		out.close();
	}
}
