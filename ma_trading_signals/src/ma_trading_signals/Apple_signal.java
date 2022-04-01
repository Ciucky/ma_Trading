package ma_trading_signals;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 
import java.util.HashMap;

public class Apple_signal {

	public static void main(String[] args) {
		int c = 0;
		// TODO Auto-generated method stub
		HashMap<String, List<List<String>>> apple = new HashMap<String, List<List<String>>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("HistoricalQuotesEdited.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
				List<String> arr = new ArrayList<String>();
		    	for(int i = 1; i <= 5; i++) {
		        arr.add(values[i]);
		    	}		
		    	//System.out.println(arr);
		        //array.add(Arrays.asList(arr));
		        
		        apple.put(values[0], Arrays.asList(arr));
		        
		        /*
		        if(c < 3) {
				//System.out.println(values[0]);
		        System.out.println();
			    System.out.println(c);
			    System.out.println();
			    System.out.print("values = ");
			    for(int i = 0; i< values.length; i++) {
			    System.out.print(values[i]);
			    }
			    System.out.println();
		        System.out.println("arr= " + arr);
		        System.out.println();
		        System.out.println("apple =" + apple);
		        }
		        c = c+1;
		    	//Arrays.fill( values, null );
		    	values = new String[values.length];
		    	*/

		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(apple.get("02/28/2020"));
	}

}
