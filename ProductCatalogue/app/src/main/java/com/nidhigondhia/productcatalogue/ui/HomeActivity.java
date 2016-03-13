package com.nidhigondhia.productcatalogue.ui;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.nidhigondhia.productcatalogue.R;
import com.nidhigondhia.productcatalogue.adapter.BannerAdapter;
import com.nidhigondhia.productcatalogue.adapter.ProductsCursorAdapter;
import com.nidhigondhia.productcatalogue.database.DBHelper;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private DBHelper dbhelper;
    private RecyclerView mRecyclerViewProduct;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private final int COLUMN_SPAN_COUNT = 2;
    private ProductsCursorAdapter adapter;
    private static final String TAG = "TAG";
    private ViewPager mViewPager;
    private BannerAdapter mBannerAdapter;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;
    private Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.view_pager_image);

        mRecyclerViewProduct = (RecyclerView) findViewById(R.id.myRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, COLUMN_SPAN_COUNT);
        mRecyclerViewProduct.setLayoutManager(layoutManager);


        dbhelper = new DBHelper(HomeActivity.this);
        dbhelper.getWritableDatabase();
        if(dbhelper.isEmpty())
            dbhelper.insertFirstTime();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // setting product data
        adapter = new ProductsCursorAdapter(HomeActivity.this);
        loadLocale();
        mRecyclerViewProduct.setAdapter(adapter);

        // setting image slider
        mBannerAdapter = new BannerAdapter(HomeActivity.this, dbhelper.getFeaturedImages());
        mViewPager.setAdapter(mBannerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        String langPref = "Lang";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        final String language = prefs.getString(langPref, "en_IN");
        getMenuInflater().inflate(R.menu.menu_home, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.setItems(dbhelper.searchProduct(language,newText));
                    return true;
                }
                @Override
                public boolean onQueryTextSubmit(String query) {
                    adapter.setItems(dbhelper.searchProduct(language,query));
                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        return true;
    }

    /**
     * change the menu item titles and data according to the language selected
     * @param lang
     */
    private void changeLang(String lang)
    {
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        updateTitle();
        adapter.setItems(dbhelper.getProductsLanguageWise(lang));
    }

    /**
     * Save the langauge local to shared prefs
     * @param lang language locale to save
     */
    private void saveLocale(String lang)
    {
        String langPref = "Lang";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }

    /**
     * load the current system local and saved local
     */
    private void loadLocale()
    {
        Locale current = getResources().getConfiguration().locale;
        String langPref = "Lang";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "en_IN");

        if(current.toString().equals(language)) {
           changeLang(language);
       }else{
           if(current.toString().contains("en"))
                changeLang("en_IN");
           else if(current.toString().contains("hi"))
               changeLang("hi_IN");
           else
               changeLang("en_IN");
       }
    }

    /**
     * update the texts according to language selected
     */
    public void updateTitle(){
        invalidateOptionsMenu();
        getSupportActionBar().setTitle(R.string.app_name);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_language_english).setTitle(R.string.action_language_english);
        menu.findItem(R.id.action_language_hindi).setTitle(R.string.action_language_hindi);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case R.id.action_language_english:
                changeLang("en_IN");
                break;
            case R.id.action_language_hindi:
                changeLang("hi_IN");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
