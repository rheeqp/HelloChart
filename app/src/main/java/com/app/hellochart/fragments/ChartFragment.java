package com.app.hellochart.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.hellochart.R;
import com.app.hellochart.chartitems.formatters.MyMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MarkerView;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.YLabels;

import java.util.ArrayList;


public class ChartFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private BarChart mBarChart;

    private String[] mLabels = new String[] { "Company A", "Company B", "Company C", "Company D", "Company E", "Company F" };

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static ChartFragment getInstance() {
        ChartFragment fragment = new ChartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ChartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBarChart = (BarChart) view.findViewById(R.id.chart);

        mBarChart.setDescription("Description");

        mBarChart.setMaxVisibleValueCount(50);
        mBarChart.setDrawGridBackground(false);
        mBarChart.setDrawBarShadow(false);
        MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.layout_marker_view);
        mBarChart.setMarkerView(mv);
        mBarChart.setDrawYValues(false);

        XLabels xAxis = mBarChart.getXLabels();
        xAxis.setPosition(XLabels.XLabelPosition.BOTTOM);

        ValueFormatter customValueFormatter = new com.app.hellochart.chartitems.formatters.ValueFormatter();

        YLabels yAxis = mBarChart.getYLabels();
        yAxis.setLabelCount(5);

        mBarChart.setData(generateBarData(1, 20000, 12));

    }

    public BarData generateBarData(int dataSet, int range, int count){
        ArrayList<BarDataSet> sets = new ArrayList<BarDataSet>();

        for(int i=0; i < dataSet; i++){
            ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

            for(int j=0; j<count; j++){
                BarEntry entry = new BarEntry((float)(Math.random() * range) + range / 4, j);
                entries.add(entry);
            }

            BarDataSet ds = new BarDataSet(entries, getLabel(i));

            ds.setColor(Color.RED);
            sets.add(ds);


        }

        BarData data = new BarData(getMonths(), sets);

        return data;
    }

    private ArrayList<String> getMonths() {

        ArrayList<String> m = new ArrayList<String>();
        m.add("Jan");
        m.add("Feb");
        m.add("Mar");
        m.add("Apr");
        m.add("May");
        m.add("Jun");
        m.add("Jul");
        m.add("Aug");
        m.add("Sep");
        m.add("Okt");
        m.add("Nov");
        m.add("Dec");

        return m;
    }


    private String getLabel(int i) {
        return mLabels[i];
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
