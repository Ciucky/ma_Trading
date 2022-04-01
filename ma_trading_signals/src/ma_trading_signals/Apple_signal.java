package ma_trading_signals;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

public class Apple_signal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> apple = new ArrayList<List<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("HistoricalQuotes.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        apple.add(Arrays.asList(values));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(apple.get(1).get(1));
	}

}
