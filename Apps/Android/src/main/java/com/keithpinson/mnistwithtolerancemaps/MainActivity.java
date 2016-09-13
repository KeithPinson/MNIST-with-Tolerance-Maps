package com.keithpinson.mnistwithtolerancemaps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;

/*
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

import com.mikepenz.materialdrawer.model.ToggleDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.ToggleDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.octicons_typeface_library.Octicons;
*/

import static java.lang.Math.toIntExact;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;


/*
    private Drawer drawer = null;
    private PrimaryDrawerItem tolMapCheckbox = null;
    private PrimaryDrawerItem altStylesCheckbox = null;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        // Title
        //
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();

            if( actionBar != null ) {
                actionBar.setTitle(R.string.app_name);
            }
        }



        //
        // Tabs
        //


        //
        // Menu
        //
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawerLayout != null) {

            drawerLayout.addDrawerListener(drawerToggle);

            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);

                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);

                }
            };
        }




/*
//        tolMapCheckbox = new PrimaryDrawerItem().withName(R.string.drawer_item_tolerance_maps).withIcon(FontAwesome.Icon.faw_check_square_o).withChecked(true).withOnCheckedChangeListener(onCheckedChangeListener);
//        altStylesCheckbox = new PrimaryDrawerItem().withName(R.string.drawer_item_alternate_styles).withIcon(FontAwesome.Icon.faw_check_square_o).withChecked(true).withOnCheckedChangeListener(onCheckedChangeListener);
        tolMapCheckbox = new PrimaryDrawerItem().withName(R.string.drawer_item_tolerance_maps).withIcon(FontAwesome.Icon.faw_check_square_o);
        altStylesCheckbox = new PrimaryDrawerItem().withName(R.string.drawer_item_alternate_styles).withIcon(FontAwesome.Icon.faw_check_square_o);

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withFullscreen(true)
                .addDrawerItems(
                        new SectionDrawerItem().withName(R.string.drawer_item_options_header),
                        tolMapCheckbox,
                        altStylesCheckbox,
                        //add some more items to get a scrolling list
                        new SectionDrawerItem().withName(R.string.drawer_item_method_header),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_method_cnn).withIcon(FontAwesome.Icon.faw_eyedropper),
                        new SectionDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question_circle_o),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_envelope_o),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_about).withIcon(FontAwesome.Icon.faw_eye)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        long id = drawerItem.getIdentifier();
                        switch ((int)id) {  // An unfortunate cast, toIntExact() is supported in API 24
                            default:
                                return true;
                        }
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

/*
        View trainButton = findViewById(R.id.button_train);
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTrainClicked();
            }
        });

        View testButton = findViewById(R.id.button_test);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTestClicked();
            }
        });

        resultText = (TextView)findViewById(R.id.text_result);
*/
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

/*
    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable) {
                Log.i("MNIST", "DrawerItem: " + ((Nameable) drawerItem).getName() + " - toggleChecked: " + isChecked);
            } else {
                Log.i("MNIST", "toggleChecked: " + isChecked);
            }
        }
    };
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

/*
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
*/

    private void onTrainClicked() {
        int digit = 0;

//        resultText.setText("Training: MNIST #" + digit);
    }

    private void onTestClicked() {
        int digit = 0;

//        resultText.setText("Testing: MNIST #" + digit);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }



}
