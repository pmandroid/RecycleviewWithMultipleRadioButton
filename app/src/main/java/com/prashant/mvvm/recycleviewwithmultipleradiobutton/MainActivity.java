package com.prashant.mvvm.recycleviewwithmultipleradiobutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView packageRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        packageRecyclerView = (RecyclerView) findViewById(R.id.package_lst);

        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        packageRecyclerView.setLayoutManager(recyclerLayoutManager);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(packageRecyclerView.getContext(),
                        recyclerLayoutManager.getOrientation());
        packageRecyclerView.addItemDecoration(dividerItemDecoration);

        PackageRecyclerViewAdapter recyclerViewAdapter = new
                PackageRecyclerViewAdapter(getPackages(), this);
        packageRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<PackageModel> getPackages() {
        List<PackageModel> modelList = new ArrayList<PackageModel>();

        List<String> priceList = new ArrayList<String>();

        priceList.add("$155 Half Yearly");
        priceList.add("$277 Yearly");
        modelList.add(new PackageModel("Virus 1", 1));

        priceList = new ArrayList<String>();

        priceList.add("$225 Half Yearly");
        priceList.add("$410 Yearly");
        modelList.add(new PackageModel("Virus 2", 2));

        priceList = new ArrayList<String>();

        priceList.add("$288 Half Yearly");
        priceList.add("$545 Yearly");
        modelList.add(new PackageModel("Virus 3", 3));

        priceList = new ArrayList<String>();

        priceList.add("$115 Half Yearly");
        priceList.add("$200 Yearly");
        modelList.add(new PackageModel("Virus 4", 4));

        priceList = new ArrayList<String>();

        priceList.add("$690 Yearly");
        modelList.add(new PackageModel("Virus 5", 5));

        return modelList;
    }
}
