package com.example.vinoth.mystarwarapi;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.vinoth.mystarwarapi.adapter.DividerItemDecoration;
import com.example.vinoth.mystarwarapi.adapter.SWAdapter;
import com.example.vinoth.mystarwarapi.model.AllStarShip;
import com.example.vinoth.mystarwarapi.model.StarShip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<StarShip> vehicleArrayList;
    private int dataPage=1;
    private Dialog progressDialog;
    private int page=1;
    private ApiInterface apinterfase;
    private RecyclerView recyclerView;
    private SWAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         apinterfase = Apiclient.getClient().create(ApiInterface.class);
         recyclerView=(RecyclerView)findViewById(R.id.recyclerviewmain);
         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        vehicleArrayList=new ArrayList<StarShip>();
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("downloading data");
        progressDialog.show();
        download(page);




    }
    public void download(final int page) {
        apinterfase.getAllStarship(String.valueOf(page)).enqueue(new Callback<AllStarShip>() {
            @Override
            public void onResponse(Call<AllStarShip> call, Response<AllStarShip> response) {
                boolean nextPage = response.body().getNext() != null;
                vehicleArrayList.addAll( response.body().getResults());
                if(nextPage){
                    dataPage++;
                    download(dataPage);
                }else{

                    sortingByCost();
                }
            }

            @Override
            public void onFailure(Call<AllStarShip> call, Throwable t) {

            }
        });
    }

    private void sortingByCost() {
        Comparator<StarShip> ascendingByCost = new Comparator<StarShip>() {

            @Override
            public int compare(StarShip v1, StarShip v2) {

                if (v1.getCost_in_credits().equals("unknown")){
                    v1.setCost_in_credits("0");
                }
                if (v2.getCost_in_credits().equals("unknown")){
                    v2.setCost_in_credits("0");
                }

                double v1Cost = Double.parseDouble(v1.getCost_in_credits());
                double v2Cost = Double.parseDouble(v2.getCost_in_credits());

                if (v1Cost > v2Cost) {
                    return -1;
                } else
                    return 1;
            }
        };

        Collections.sort(vehicleArrayList, ascendingByCost);
        setAdapter();

    }
    public void setAdapter(){
        Toast.makeText(this, "Total size:"+vehicleArrayList.size(), Toast.LENGTH_SHORT).show();
        List<StarShip> fistArrayList = vehicleArrayList.subList(0, 15);
         progressDialog.dismiss();
         adapter = new SWAdapter(this, fistArrayList);
         adapter.notifyDataSetChanged();
         Toast.makeText(this, "new size:"+fistArrayList.size(), Toast.LENGTH_SHORT).show();
         recyclerView.setAdapter(adapter);
    }
}
