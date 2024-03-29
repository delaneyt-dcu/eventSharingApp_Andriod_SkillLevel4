package edu.oscail.cs.tdassignfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 *  Displays an enlarged view of a thumbprint
 *
 *  <p> This class is launched by explicit intent when an image thumbprint is clicked within the
 *  GalleryFragment class and includes an actionbar containing a clickable back action arrow which
 *  will return the user to the GalleryFragment class.</p>
 *
 *  <p><b>References: </b>The origins of the code used in this class is accredited to Dr Adam Porter
 * ref project: UIGrdLayout.java)</p>
 *
 *  @author Tim Delaney
 *  @version 2.0
 *  @since 2016-01-20
 *  @see "UIGridLayout" demo by Adam Porter available at:
 *  @see <a href="http://developer.android.com/guide/topics/ui/layout/gridview.html"</a>
 */
public class ArtActivity extends AppCompatActivity {

    /**
     * Saves the state of the application in a bundle based on the value of the savedInstance State
     * and carries out button intent actions.
     *
     * @param savedInstanceState can be passed back to onCreate if the activity needs to be created
     *                           (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {


        //Debug Tag for use logging debug output to LogCat
        String TAG = "ArtActivity";

        // Calls the onCreate constructor of the AppCompatActivity superclass
        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(GalleryFragment.EXTRA_RES_ID, 0));

        // Passes the imageView as an argument into the setContentView method
        setContentView(imageView);

        // Tag marker for this activity
        Log.i(TAG, "The activity is visible and has been created.");

    }

    /**
     * Returns user to previous screen with up arrow set to act like a back arrow in this case
     * ie could not set GalleryFragment as parent in Manifest file
     *
     * @param item represent the menu item clicked, the up arrow in this case
     * @return boolean true if clicked to return user to previous screen
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}