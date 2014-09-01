package shashika.achartengine.dynamiclinegraph;

import java.util.Random;

public class RandomData {
	
	public static Point getDataFromReciever(int x){
		
		return new Point(x, genarateRandomData());
	}
	
	private static int genarateRandomData(){
		
		Random random = new Random();
		return random.nextInt(100);   //genarate random integers between 0 to 100
	}
}
