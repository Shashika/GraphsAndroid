package shashika.achartengine.dynamiclinegraph;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;

public class DrawGraph {

	private GraphicalView view;
	private TimeSeries dataSet = new TimeSeries("Dynamic Line Graph");
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private XYSeriesRenderer renderer = new XYSeriesRenderer();
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	
	public DrawGraph(){
		mDataset.addSeries(dataSet);
		
		renderer.setColor(Color.BLUE);
		renderer.setPointStyle(PointStyle.SQUARE);
		renderer.setFillPoints(true);
		
		/*Enable Zoom*/
		mRenderer.setZoomButtonsVisible(true);
		mRenderer.setYTitle("Magnitude");
		mRenderer.setXTitle("Time");
		
		/*add single renderer to multiple renderer*/
		mRenderer.addSeriesRenderer(renderer);
	}
	
	public GraphicalView getView(Context context){
		
		view = ChartFactory.getLineChartView(context, mDataset, mRenderer);
		return view;
	}
	
	public void addNewPoints(Point p){
		dataSet.add(p.getX(), p.getY());
	}
	
}
