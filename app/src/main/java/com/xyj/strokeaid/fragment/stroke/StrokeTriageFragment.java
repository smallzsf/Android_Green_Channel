package com.xyj.strokeaid.fragment.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.EmergencyDoctorActivity;
import com.xyj.strokeaid.activity.stroke.TriageActivity;
import com.xyj.strokeaid.adapter.BaseRecycAdapter;
import com.xyj.strokeaid.adapter.StrokeTriageAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StrokeTriageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StrokeTriageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_content_act_main)
    RecyclerView rvContentActMain;
    @BindView(R.id.srl_fresh_act_main)
    SwipeRefreshLayout srlFreshActMain;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StrokeTriageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StrokeTriageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StrokeTriageFragment newInstance(String param1, String param2) {
        StrokeTriageFragment fragment = new StrokeTriageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.stroke_fragment_triage, container, false);
        ButterKnife.bind(this,inflate);
        init();
        return inflate;

    }

    private void init() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            strings.add("封装RecyclerView" + i);
        }
        rvContentActMain.setLayoutManager(new LinearLayoutManager(getContext()));
        StrokeTriageAdapter strokeTriageAdapter = new StrokeTriageAdapter(strings, getContext());
        rvContentActMain.setAdapter(strokeTriageAdapter);
        strokeTriageAdapter.setOnItemClickListener(new BaseRecycAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
                if(position==0){
                    startActivity(new Intent(getActivity(), TriageActivity.class));
                }else if(position==1){
                    startActivity(new Intent(getActivity(), EmergencyDoctorActivity.class));
                }
            }
        });

    }
}