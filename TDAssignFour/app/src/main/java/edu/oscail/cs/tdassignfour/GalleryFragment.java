package edu.oscail.cs.tdassignfour;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * Displays a grid view of clickable thumbprint images
 *
 * <p> This is a child activity of the MainActivity class and is launched by explicit intent with
 * the gallery action tab.
 *
 * It loads layout resources from the gallery_fragment.xml file which includes a gridView of
 * clickable image thumbprints which lunch the ArtActivity.</p>
 *
 * <p><b>References: </b>The origins of the code used in this class is accredited to Dr Adam Porter
 * ref project: UIGrdLayout.java)</p>
 *
 *  @author Tim Delaney
 *  @version 2.0
 *  @since 2016-01-20
 *  @see "UIGridLayout" demo by Adam Porter available at:
 *  @see <a href="http://developer.android.com/guide/topics/ui/layout/gridview.html"</a>
 */
public class GalleryFragment extends Fragment {

    // Debug Tag for use logging debug output to LogCat
    private final String TAG = "GalleryFragment";

    // Declares a protected string variable EXTRA_RES_ID and initiates its value as POS
    protected static final String EXTRA_RES_ID = "POS";

    // Creates an array of resource image files which is a private instance to this class
    private ArrayList<Integer> mThumbIdsCars = new ArrayList<>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6, R.drawable.image7, R.drawable.image8,
                    R.drawable.image9, R.drawable.image10, R.drawable.image11,
                    R.drawable.image12));

    /**
     * Returns a gridView of images inflated from the gallery_fragment.xml layout and starts
     * ArtActivity by intent using the ImageAdapter with the necessary Thumbprint Id.
     *
     * @param inflater references what to inflate on the screen
     * @param container references to a special view that can contain other views (ie children)
     * @param savedInstanceState is the argument passed back to onCreate if the activity needs to be
     *                           created (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     * @return rootView depending on user selection
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Tag marker for this method
        Log.i(TAG, "The view is visible and about to be created.");

        // references the resource file to inflate view
        View rootView = inflater.inflate(R.layout.gallery_fragment, container, false);
        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity(), mThumbIdsCars));

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ArtActivity
                Intent intent = new Intent(getActivity(), ArtActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int) id);

                // Start the ArtActivity
                startActivity(intent);

                // Tag marker for this activity
                Log.i(TAG, "The activity is visible has been started.");
            }
        });
        return rootView;
    }
}

