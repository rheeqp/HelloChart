package com.app.hellochart.chartitems.formatters;

import java.text.DecimalFormat;

/**
 * Created by segunfamisa on 2/27/15.
 */
public class ValueFormatter implements com.github.mikephil.charting.utils.ValueFormatter{


    private DecimalFormat mFormat;

    public ValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value) {
        return mFormat.format(value) + " $";
    }

}
