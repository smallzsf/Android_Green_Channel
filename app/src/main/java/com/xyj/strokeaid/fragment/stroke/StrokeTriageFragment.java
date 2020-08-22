package com.xyj.strokeaid.fragment.stroke;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.EcgExamnationMainActivity;
import com.xyj.strokeaid.activity.stroke.EmergencyDoctorActivity;
import com.xyj.strokeaid.activity.stroke.TriageActivity;
import com.xyj.strokeaid.activity.stroke.VitalSignsActivity;
import com.xyj.strokeaid.adapter.BaseRecycAdapter;
import com.xyj.strokeaid.adapter.StrokeTriageAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StrokeTriageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_content_act_main)
    RecyclerView rvContentActMain;
    @BindView(R.id.srl_fresh_act_main)
    SwipeRefreshLayout srlFreshActMain;

    private StrokeTriageAdapter strokeTriageAdapter;

    public StrokeTriageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.stroke_fragment_triage, container, false);
        ButterKnife.bind(this, inflate);
        init();
        return inflate;

    }

    private void init() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("患者到院时间");
        strings.add("来院方式");
        strings.add("发病时间");
        strings.add("急诊分诊时间");
        strings.add("急诊医生接诊时间");
        strings.add("卒中医生急诊时间");
        strings.add("FAST-ED评分");
        strings.add("发病前mRS评分");
        strings.add("生命体征");
        strings.add("快速血糖");
        strings.add("心电图检查");
        strings.add("采血时间");
        strings.add("血样送检时间");
        strings.add("血样送达检验科时间");
        strings.add("体重");
        strings.add("身高");
        rvContentActMain.setLayoutManager(new LinearLayoutManager(getContext()));
        strokeTriageAdapter = new StrokeTriageAdapter(R.layout.adapter_stroke_path_item, strings);
        rvContentActMain.setAdapter(strokeTriageAdapter);
        strokeTriageAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (position == 0 ||position == 1|| position == 2 || position == 9||position == 11 || position == 12 || position == 13 || position == 14 || position == 15) {
                    Intent intent = new Intent(getActivity(), TriageActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("arrayList", strings);
                    bundle.putInt("position", position);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 0);
                } else if (position == 3 || position == 4 || position == 5) {

                    Intent intent = new Intent(getActivity(), EmergencyDoctorActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("arrayList", strings);
                    bundle.putInt("position", position);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);

                } else if (position == 8) {

                    Intent intent = new Intent(getActivity(), VitalSignsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("arrayList", strings);
                    bundle.putInt("position", position);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 2);

                }else if (position == 10) {

                    Intent intent = new Intent(getActivity(), EcgExamnationMainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("arrayList", strings);
                    bundle.putInt("position", position);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 3);

                }
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == 0 && resultCode == 0) {

            String result = data.getExtras().getString("result");
            int position = data.getExtras().getInt("position");
            String weight = data.getExtras().getString("weight");
            Toast.makeText(getActivity(), "体重"+weight+"position"+position, Toast.LENGTH_SHORT).show();
            String tall = data.getExtras().getString("tall");

            TextView tv_is_done = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_is_done);
            if (position==14){
                TextView tv_operation_path_show = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_operation_path_show);
                tv_operation_path_show.setText(weight+"KG");

            }else if(position==15){
                TextView tv_operation_path_show = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_operation_path_show);
                tv_operation_path_show.setText(tall+"cm");

            }else{
                TextView tv_operation_path_show = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_operation_path_show);
                tv_operation_path_show.setText(result);
            }

            tv_is_done.setBackgroundResource(R.drawable.shape_green_round);

        }

        if (requestCode == 1 && resultCode == 1) {

            String result = data.getExtras().getString("result");
            int position = data.getExtras().getInt("position");

            Toast.makeText(getActivity(), result + "***" + position, Toast.LENGTH_SHORT).show();
            TextView tv_operation_path_show = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_operation_path_show);
            TextView tv_is_done = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_is_done);
            tv_operation_path_show.setText(result);
            tv_is_done.setBackgroundResource(R.drawable.shape_green_round);

        }

        if (requestCode == 3 && resultCode == 2) {

            String result = data.getExtras().getString("result");
            int position = data.getExtras().getInt("position");
            Toast.makeText(getActivity(), result + "***" + position, Toast.LENGTH_SHORT).show();
            TextView tv_operation_path_show = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_operation_path_show);
            TextView tv_is_done = rvContentActMain.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_is_done);
            tv_operation_path_show.setText(result);
          //  tv_is_done.setBackgroundResource(R.drawable.shape_green_round);
            GradientDrawable gradientDrawable= (GradientDrawable) tv_is_done.getBackground();
            gradientDrawable.setColor(ContextCompat.getColor(getActivity(),R.color.app_fff600));
        }

    }
}