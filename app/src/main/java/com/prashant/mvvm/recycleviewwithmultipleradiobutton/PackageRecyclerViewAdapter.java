package com.prashant.mvvm.recycleviewwithmultipleradiobutton;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PackageRecyclerViewAdapter extends
        RecyclerView.Adapter<PackageRecyclerViewAdapter.ViewHolder> {

    private List<PackageModel> packageList;
    private Context context;

    private RadioGroup radioGroupLastChecked = null;




    public PackageRecyclerViewAdapter(List<PackageModel> packageListIn
            , Context ctx) {
        packageList = packageListIn;
        context = ctx;
    }

    @Override
    public PackageRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.package_item, parent, false);

        PackageRecyclerViewAdapter.ViewHolder viewHolder =
                new PackageRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PackageRecyclerViewAdapter.ViewHolder holder,
                                 int position) {
        final PackageModel packageModel = packageList.get(position);
        holder.packageName.setText(packageModel.getName());


        RadioButton rbYes = new RadioButton(PackageRecyclerViewAdapter.this.context);
        rbYes.setText("Yes");

        RadioButton rbNo = new RadioButton(PackageRecyclerViewAdapter.this.context);
        //    rbNo.setId(id++);
        rbNo.setText("No");

        holder.priceGroup.addView(rbYes);
        holder.priceGroup.addView(rbNo);

        holder.priceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {



                    RadioButton rbYes = (RadioButton) radioGroup.getChildAt(0);
                    RadioButton rbNo = (RadioButton) radioGroup.getChildAt(1);

                    if (rbYes.isChecked()) {
                        packageModel.setYes(true);
                    } else {
                        packageModel.setYes(false);
                    }

                    if (rbNo.isChecked()) {
                        packageModel.setNo(true);
                    } else {
                        packageModel.setNo(false);
                    }
                    Log.e("Name", packageModel.getName());
                    Log.e("Yes", packageModel.getYes() + "");
                    Log.e("No", packageModel.getNo() + "");

                    Toast.makeText(PackageRecyclerViewAdapter.this.context,
                            "Radio button clicked " + radioGroup.getCheckedRadioButtonId(),
                            Toast.LENGTH_SHORT).show();



            }
        });

    }

    @Override
    public int getItemCount() {
        return packageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView packageName;
        public RadioGroup priceGroup;

        public ViewHolder(View view) {
            super(view);
            packageName = (TextView) view.findViewById(R.id.package_name);
            priceGroup = (RadioGroup) view.findViewById(R.id.price_grp);


        }
    }
    public List<PackageModel> getPackageList() {
        return packageList;
    }
}
