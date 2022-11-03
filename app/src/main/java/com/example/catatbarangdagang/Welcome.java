package com.example.catatbarangdagang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Welcome extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        if (searchManager != null) {
            SearchView searchView = (SearchView) (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo (getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(Welcome.this, query,
                            Toast.LENGTH_SHORT).show();
                    searchView.clearFocus();
                    return true;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AkunFragment())
                    .addToBackStack(null)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.menu2) {
            Intent i = new Intent(this, StrukActivity.class);
            startActivity(i);
            return true;
        } else if (item.getItemId() == R.id.menu3) {
            Intent j = new Intent(this, PengaturanActivity.class);
            startActivity(j);
            return true;
        } else if (item.getItemId() ==R.id.menu4){
            Intent k = new Intent(this, TentangActivity.class);
            startActivity(k);
            return true;
        } else if (item.getItemId() ==R.id.menu5){
            Intent k = new Intent(this, Barang.class);
            startActivity(k);
            return true;
        } else {
            return true;
        }
    }
}