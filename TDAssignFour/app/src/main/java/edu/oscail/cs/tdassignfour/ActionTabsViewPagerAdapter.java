package edu.oscail.cs.tdassignfour;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Sets the parameters for the action bar
 *
 * <p> This class handles all of the formatting details for the action bar such as: no. of tabs, tab
 * names and order of appearance.</p>
 *
 * <<p><b>Credit is attributed to Colette Kirwan of DCU for the code used in this class</b></p>
 *
 * @author Tim Delaney
 * @version 2.0
 * @since 2016-01-20
 * @see "TabFragPager" demo by Colette Kirwan availble on DCU's SDA github
 */
public class ActionTabsViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    public static final int EVENT = 0;
    public static final int GALLERY = 1;
    public static final int MATCH = 2;
    public static final int SETTINGS = 3;
    public static final String UI_TAB_EVENT = "EVENT";
    public static final String UI_TAB_GALLERY = "GALLERY";
    public static final String UI_TAB_MATCH = "MATCH";
    public static final String UI_TAB_SETTINGS = "SETTINGS";

    /**
     * Receives fragment manager and array data and sets the context for this fragment
     *
     * @param fm from FragmentManager
     * @param fragments from the arrayList
     */
    public ActionTabsViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    /**
     * Returns the fragment positions
     *
     * @param pos of the fragment represented by an int value
     * @return fragment with position set
     */
    public Fragment getItem(int pos){
        return fragments.get(pos);
    }

    /**
     * Returns the number of fragments in the Adapter when called
     *
     * @return int of the number of fragments
     */
    public int getCount(){
        return fragments.size();
    }

    /**
     * Returns the UI of tab by position
     * @param position as a int value for each tab
     * @return the page title of the tab
     */
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case EVENT:
                return UI_TAB_EVENT;
            case GALLERY:
                return UI_TAB_GALLERY;
            case MATCH:
                return UI_TAB_MATCH;
            case SETTINGS:
                return UI_TAB_SETTINGS;
            default:
                break;
        }
        return null;
    }
}
