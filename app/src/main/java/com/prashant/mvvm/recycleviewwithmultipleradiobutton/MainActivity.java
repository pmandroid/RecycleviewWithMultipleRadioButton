package com.prashant.mvvm.recycleviewwithmultipleradiobutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView packageRecyclerView;
    private Button bt_get_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        packageRecyclerView = (RecyclerView) findViewById(R.id.package_lst);
        bt_get_data = (Button) findViewById(R.id.bt_get_data);

        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        packageRecyclerView.setLayoutManager(recyclerLayoutManager);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(packageRecyclerView.getContext(),
                        recyclerLayoutManager.getOrientation());
        packageRecyclerView.addItemDecoration(dividerItemDecoration);

        final PackageRecyclerViewAdapter recyclerViewAdapter = new
                PackageRecyclerViewAdapter(getPackages(), this);
        packageRecyclerView.setAdapter(recyclerViewAdapter);

        bt_get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<PackageModel> packageList = recyclerViewAdapter.getPackageList();
                for (int i = 0; i < packageList.size(); i++) {
                    Log.e("id = ", " " + packageList.get(i).getName());
                    Log.e("Yes = ", " " + packageList.get(i).getYes());
                    Log.e("No = ", " " + packageList.get(i).getNo());
                }
            }
        });

    }

    private List<PackageModel> getPackages() {

        List<PackageModel> modelList = new ArrayList<PackageModel>();

        modelList.add(new PackageModel("R U A Virus 1?", 1));
        modelList.add(new PackageModel("R U A Virus 2?", 2));
        modelList.add(new PackageModel("R U A Virus 3?", 3));
        modelList.add(new PackageModel("R U A Virus 4?", 4));
        modelList.add(new PackageModel("R U A Virus 5?", 5));

        return modelList;
    }
}
