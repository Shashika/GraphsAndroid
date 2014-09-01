package com.shashika.graphsachartengine;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class DrawGraph {

	public Intent getIntent(Context context){
		
		int[] x = {1,2,3,4,5,6,7,8,9,10};
		int[] y = {40,65,11,25,69,45,65,24,65,10};
		
		TimeSeries series = new TimeSeries("Line1");
		
		for(int co = 0; co< x.length; co++){
			series.add(x[co], y[co]);
		}

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series);
		
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		renderer.setColor(Color.RED);
		renderer.setPointStyle(PointStyle.CIRCLE);
		renderer.setFillPoints(true);
		
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		mRenderer.addSeriesRenderer(renderer);
		mRenderer.setChartTitle("Data Analysis");
		mRenderer.setYTitle("Magnitude");
		mRenderer.setXTitle("Time");
		
		Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer,"Line Graph");
		return intent;
	}
}
