package com.xyj.strokeaid.activity.chestpain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.distutil.DistListUtil;

public class ChestPainEmptyActivity extends AppCompatActivity {
    DistListUtil util = new DistListUtil(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_pain_empty);
        util.initGenderMap(R.array.chest_pain_operation_gender_diversity_more);
    }
}