package android.com.curldemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitrai on 3/5/16.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{

    private LayoutInflater inflater = null;
    private List<Fragment> fragments = new ArrayList<>();

    public static int pos = 0;

    private List<Fragment> myFragments;
    private List<String> categories;
    private Context context;

    public MyPagerAdapter(Context c, FragmentManager fragmentManager, List<Fragment> myFrags, List<String> cats) {
        super(fragmentManager);
        myFragments = myFrags;
        this.categories = cats;
        this.context = c;
    }

    @Override
    public Fragment getItem(int position) {

        return myFragments.get(position);

    }

    @Override
    public int getCount() {

        return myFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        setPos(position);
        return categories.get(position);
    }

    public static int getPos() {
        return pos;
    }

    public void add(Class<Fragment> c, String title, Bundle b) {
        myFragments.add(Fragment.instantiate(context,c.getName(),b));
        categories.add(title);
    }

    public static void setPos(int pos) {
        MyPagerAdapter.pos = pos;
    }
}
