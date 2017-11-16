package com.example.ratha.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ratha on 11/15/2017.
 */

public class PopularFragment extends Fragment {

    public static final String ARG_PAGE="ARG_PAGE";
    public List list;
    private int mPage;
    public static PopularFragment newInstance(int page){
        Bundle args=new Bundle();
        args.putInt(ARG_PAGE,page);
        PopularFragment fragment=new PopularFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage=getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.popular_fragment_layout,container,false);

        /*TextView tvText= viewGroup.findViewById(R.id.tvText);
        tvText.setText("Fragment #"+mPage);*/

        return viewGroup;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView=view.findViewById(R.id.listView);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

    }

    public void setData(List list) {
        this.list=list;
        Log.e("list",list.size()+"");
    }
}
