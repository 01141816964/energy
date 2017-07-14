package com.example.omar.energy.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import com.example.omar.energy.R;



public class ChartActivity extends AppCompatActivity {

    String deviceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        drawChart();
        deviceName=getIntent().getExtras().getString("DeviceName");
    }

    private String[] mMonth =  new String[]{
            "a","b","c","d","e","f","g","h","i","j","k","l"
    };

    private void drawChart(){
        int[] x = {1,2,3,4,5,6,7,8};
        int[] y = {10,2,12,8,15,5,12,6};
        XYSeries series = new XYSeries("chart");
        for(int i=0; i<x.length;i++){
            series.add(x[i],y[i]);
        }

        XYMultipleSeriesDataset datas = new XYMultipleSeriesDataset();
        datas.addSeries(series);

        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setColor(Color.RED);
        //   renderer.setPointStyle(PointStyle.DIAMOND);
        renderer.setFillPoints(true);
        renderer.setLineWidth(10);
        renderer.setChartValuesSpacing(2);
        renderer.setDisplayChartValues(true);
        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setPointStrokeWidth(50);

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        mRenderer.addSeriesRenderer(renderer);

           /*mRenderer.setXLabels(0);
            for(int i=0;i<x.length;i++){
                mRenderer.addXTextLabel(i+1, mMonth[i]);
            }*/
        //mRenderer.addSeriesRenderer(renderer);

        // We want to avoid black border
// transparent margins
        mRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));
// Disable Pan on two axis
        mRenderer.setPanEnabled(false, false);
        mRenderer.setYAxisMax(35);
        mRenderer.setYAxisMin(0);
        mRenderer.setShowGrid(true); // we show the grid
        mRenderer.setBarSpacing(0.5);
        mRenderer.setBarWidth(50);

        mRenderer.setChartTitle(getIntent().getExtras().getString("DeviceName")+" Power Consuption");
        mRenderer.setXTitle("Days");
        mRenderer.setYTitle("KWH");

        mRenderer.setChartTitleTextSize(50);
        mRenderer.setLabelsTextSize(30);
        mRenderer.setAxisTitleTextSize(40);

        mRenderer.setZoomEnabled(false);
        mRenderer.setInScroll(false);

        mRenderer.setMargins(new int[]{30, 30, 30, 30});



        LinearLayout chartContainer = (LinearLayout)findViewById(R.id.chartlay);
/*
            GraphicalView chart = ChartFactory.getBarChartView(getBaseContext(),datas,mRenderer, BarChart.Type.DEFAULT);
*/

        GraphicalView chart = ChartFactory.getLineChartView(getBaseContext(),datas,mRenderer);

        chartContainer.addView(chart,0);
    }



}
