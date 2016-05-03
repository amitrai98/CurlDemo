package android.com.curldemo;

import android.com.curldemo.fragements.fragment_four;
import android.com.curldemo.fragements.fragment_one;
import android.com.curldemo.fragements.fragment_three;
import android.com.curldemo.fragements.fragment_two;
import android.content.Context;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements fragment_one.OnFragmentInteractionListener, fragment_two.OnFragmentInteractionListener,
fragment_three.OnFragmentInteractionListener, fragment_four.OnFragmentInteractionListener{

    private LocationManager locationManager = null;
    private ViewPager view_pager = null;
    private List<Fragment> list_fragments = new ArrayList<>();
    private List<String> cats = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        this.setContentView(R.layout.main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * initalizing view elements.
     */
    private void init(){
        list_fragments.clear();
        list_fragments.add(new fragment_one());
        list_fragments.add(new fragment_two());
        list_fragments.add(new fragment_three());
        list_fragments.add(new fragment_four());

        cats.clear();
        cats.add("fragment_one");
        cats.add("two");
        cats.add("three");
        cats.add("four");

        view_pager = (ViewPager) findViewById(R.id.view_pager);
        view_pager.setAdapter(new MyPagerAdapter(this,getSupportFragmentManager(), list_fragments,cats));
    }



    private void initLocation(Context context){

        if (locationManager == null) {
            locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
