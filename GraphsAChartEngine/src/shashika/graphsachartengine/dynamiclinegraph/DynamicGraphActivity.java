package shashika.achartengine.dynamiclinegraph;

import org.achartengine.GraphicalView;

import android.app.Activity;
import android.os.Bundle;

public class DynamicGraphActivity extends Activity{

	private DrawGraph drawGraph = new DrawGraph();
	private static Thread thread;
	private static GraphicalView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		thread = new Thread(){
			
			public void run(){
				for(int i =0; i <= 20 ; i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					Point p = RandomData.getDataFromReciever(i);
					drawGraph.addNewPoints(p);
					view.repaint();
				}
			}
		};
		thread.start();
	}

	@Override
	protected void onStart() {
		super.onStart();
		view = drawGraph.getView(this);
		setContentView(view);
	}
	
	
}
