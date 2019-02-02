package com.example.farhan.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;

import com.example.farhan.scheduler.Adapter.TaskAdapter;

import java.util.ArrayList;

public class SearchTask extends AppCompatActivity {

    Toolbar toolbar;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Task> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_task);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.rvSearchResult);
        adapter = new TaskAdapter(data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchTask.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    public void addData(){
        data = new ArrayList<>();
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_search,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchForm).getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Task");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.searchForm:

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
