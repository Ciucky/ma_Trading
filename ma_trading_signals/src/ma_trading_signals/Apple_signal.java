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
		int key = 0;
		// TODO Auto-generated method stub
		HashMap<Integer, List<String>> apple = new HashMap<Integer, List<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("HistoricalQuotesEdited.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
				//List<String> arr = new ArrayList<String>();
		    	//for(int i = 1; i <= 5; i++) {
		        //arr.add(values[i]);
		    	//}		
		    	//System.out.println(arr);
		        //array.add(Arrays.asList(arr));
		        
		        apple.put(key, Arrays.asList(values));
		        key = key+1;
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
		int s = 0, e = 19;
		double sum = 0;
		while(e < apple.size()-1) {
			for(int i = s; i<=e; i++) {
				sum = sum + Double.parseDouble(apple.get(i).get(1));
			}
			e = e+1;
			s = s+1;
			sum = sum/20; //calculate 20 MA		
			List<String> temp = new ArrayList<String>();
			temp.addAll(apple.get(e));
			//System.out.println();
	        //System.out.println("temp =" + temp);
	        temp.add(Double.toString(sum));
	        //System.out.println();
	        //System.out.println("temp =" + temp);
	        apple.put(e, temp);
		}
		
		boolean oportunity = false;
		boolean mastart = false;
		int shares = 0;
		for (List<String> value : apple.values()) {
			if(value.get(0).equals("03/30/2010"))
				mastart = true;
			if(mastart == true) {
				if(oportunity == true && Double.parseDouble(value.get(3)) >= Double.parseDouble(value.get(6))) {
					System.out.println("Open price is above 20MA");
					System.out.println("Bought 1 share on " + value.get(0) + " at the price " + value.get(3) + "$");
					shares = shares + 1;
				}
				else
					oportunity = false;
				if(Double.parseDouble(value.get(1)) < Double.parseDouble(value.get(6))) {
					System.out.println("Price closed under 20MA on " + value.get(0));
					//System.out.println("Close " + value.get(1) + " MA " + value.get(6));
					oportunity = true;
				}
				if(oportunity == true && Double.parseDouble(value.get(1)) > Double.parseDouble(value.get(6))) {
					System.out.println("Price is just closed above 20MA. Buy on open if still above");
					//System.out.println("Bought 1 share on " + value.get(0) + " ");
					
				}
				if(Double.parseDouble(value.get(1)) > Double.parseDouble(value.get(6))) {
					
				}
			}
		}
		System.out.println(apple.get(20));
	}

}
