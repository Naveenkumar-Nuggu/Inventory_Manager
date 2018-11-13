package com.example.s531373.inventorymanager;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.s531373.inventorymanager.data.StockItem;

import com.example.s531373.inventorymanager.data.InventoryDbHelper;


public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getCanonicalName();
    InventoryDbHelper dbHelper;
    StockCursorAdapter adapter;
    int lastVisibleItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new InventoryDbHelper(this);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        final ListView listView = (ListView) findViewById(R.id.list_view);
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

        Cursor cursor = dbHelper.readStock();

        adapter = new StockCursorAdapter(this, cursor);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == 0) return;
                final int currentFirstVisibleItem = view.getFirstVisiblePosition();
                if (currentFirstVisibleItem > lastVisibleItem) {
                    fab.show();
                } else if (currentFirstVisibleItem < lastVisibleItem) {
                    fab.hide();
                }
                lastVisibleItem = currentFirstVisibleItem;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.readStock());
    }

    public void clickOnViewItem(long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemId", id);
        startActivity(intent);
    }

    public void clickOnSale(long id, int quantity) {
        dbHelper.sellOneItem(id, quantity);
        adapter.swapCursor(dbHelper.readStock());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_dummy_data:
                // add dummy data for testing
                addDummyData();
                adapter.swapCursor(dbHelper.readStock());
        }
        return super.onOptionsItemSelected(item);
    }

    private void addDummyData() {
        StockItem dove = new StockItem(
                "dove",
                "10 $",
                45,
                "Pavan K",
                "+1 660 504 0876",
                "nnvv@gmail.com",

                "android.resource://com.example.s531373.inventorymanager/drawable/dove");
        dbHelper.insertItem(dove);

        StockItem notebooks = new StockItem(
                "Notebooks",
                "20 $",
                24,
                "Yash raj",
                "+1 650 804 9876",
                "yrj@gmail.com",

                "android.resource://com.example.s531373.inventorymanager/drawable/notebooks");
        dbHelper.insertItem(notebooks);

        StockItem tide = new StockItem(
                "tide",
                "11 $",
                74,
                "Pratik N",
                "+1 234 094 7632",
                "pran@gmail.com",

                "android.resource://com.example.s531373.inventorymanager/drawable/tide");
        dbHelper.insertItem(tide);

//        StockItem cola = new StockItem(
//                "Cola",
//                "13 $",
//                44,
//                "Midhun Reddy",
//                "+1 234 094 7978",
//                "mreddy@sweet.com",
//
//                "android.resource://com.example.s531373.inventorymanager/drawable/cola");
//        dbHelper.insertItem(cola);
//
//        StockItem fruitSalad = new StockItem(
//                "Fruit salad",
//                "6 $",
//                34,
//                "Sai Reddy",
//                "+1 324 904 7978",
//                "reddys@sweet.com",
//
//                "android.resource://com.example.s531373.inventorymanager/drawable/fruit_salad");
//        dbHelper.insertItem(fruitSalad);
//
//        StockItem smurfs = new StockItem(
//                "Smurfs",
//                "12 $",
//                26,
//                "Sachin Shetty",
//                "+1 524 904 7978",
//                "sshetty@sweet.com",
//
//                "android.resource://com.example.s531373.inventorymanager/drawable/smurfs");
//        dbHelper.insertItem(smurfs);
//
//        StockItem fresquito = new StockItem(
//                "Fresquito",
//                "9 $",
//                54,
//                "Krishna Kumar",
//                "+1 543 660 6789",
//                "kkumar@dulce.com",
//
//                "android.resource://com.example.s531373.inventorymanager/drawable/fresquito");
//        dbHelper.insertItem(fresquito);
//
//        StockItem hotChillies = new StockItem(
//                "Hot chillies",
//                "13 $",
//                12,
//                "Robert James",
//                "+1 456 660 7845",
//                "rjames@dulce.com",
//
//                "android.resource://com.example.s531373.inventorymanager/drawable/hot_chillies");
//        dbHelper.insertItem(hotChillies);
//
//        StockItem lolipopStrawberry = new StockItem(
//                "Lolipop strawberry",
//                "12 $",
//                62,
//                "Charles Harry",
//                "+1 345 234 5678",
//                "charry@dulce.com",
//
//                "android.resource://com.example.s531373.inventorymanager/drawable/lolipop");
//        dbHelper.insertItem(lolipopStrawberry);
//
//        StockItem heartGummy = new StockItem(
//                "Heart gummy jellies",
//                "13 $",
//                22,
//                "Terry Matt",
//                "+1 567 743 2367",
//                "mterry@dulce.com",
//
//                "android.resource://com.example.s531373.inventorymanager/drawable/heart_gummy");
//        dbHelper.insertItem(heartGummy);
//    }
//}
    }
}



