package no.hib.dpf.editor.verification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultAnalysis {

	
	public static void analysis(String file, String[] result) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
		String line = null;
		boolean eof = false;
		Pattern p = Pattern.compile("\\. (\\d+)ms");
		int index = 0;
		int count = -1;
		while(!eof){
			for (int i = 0; i < 6; i++) {
				line = reader.readLine();
				if(line == null){
					eof = true;
					break;
				}
				if(i < 2 || i > 3) continue;
				Matcher match = p.matcher(line);
				if(match.find()){
					String a = match.group(1);
					if(count == -1){
						result[index] += ("&" + a + "&");
						count = Integer.parseInt(a);
					}
					else{
						result[index] += (a + "&" + (count + Integer.parseInt(a)));
						index++;
						count = -1;
					}
				}
			}
		
		}
		reader.close();
	}
	public static void main(String[] args) throws IOException{
		String[] result = new String[20];
 		for (int i = 0; i < 20; i++) {
			result[i] = "" + (i + 3);
		}
 		analysis("result1", result);
		analysis("result", result);
		for (int i = 0; i < 20; i++) {
			System.out.println(result[i] + "\\\\");
			System.out.println("\\hline");
		}
	}
}
