package com.example.lenovo.tanamanobat;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SakitActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    ListView listsakit;
    ArrayAdapter<CharSequence> arrayAdapter;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sakit);

        listsakit = (ListView)findViewById(R.id.listSakit);
        arrayAdapter = new ArrayAdapter<CharSequence>(this, R.layout.list_sakit, R.id.textViewSakit, countryList);
        listsakit.setAdapter(arrayAdapter);
        listsakit.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //String message="kamu memilih "+((TextView)view).getText();
        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("position",arrayAdapter.getItem(position));
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_penyakit, menu);
        MenuItem search = menu.findItem(R.id.searchPenyakit);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }
    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}
