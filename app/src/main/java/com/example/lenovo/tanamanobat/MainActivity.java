package com.example.lenovo.tanamanobat;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerAdapter myAdapter;

    ArrayList<PoJo> listtanaman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String a = String.valueOf(R.string.video);



        listtanaman = new ArrayList<>();
        listtanaman.add(new  PoJo("tes",a,"deskripsi",R.drawable.grain));
        listtanaman.add(new PoJo("Makanan","Kimmak","Pusing",R.mipmap.ic_launcher));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycler);
        myAdapter = new RecyclerAdapter(this,listtanaman);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        //myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (myAdapter != null) myAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}
