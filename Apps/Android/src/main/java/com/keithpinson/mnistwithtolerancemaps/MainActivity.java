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
import android.widget.CompoundButton;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.octicons_typeface_library.Octicons;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar = null;
    private Snackbar snackbar = null;
    private Drawer drawer = null;
    private SwitchDrawerItem tolMapCheckbox = null;
    private SwitchDrawerItem altStylesCheckbox = null;

    private MnistTolMap mnistTolMap = null;
    private MnistAltStyles mnistAltStyles = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mnistTolMap = new MnistTolMap();
        mnistAltStyles = new MnistAltStyles();

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

        boolean usingTolMap = mnistTolMap.useTolMap(getApplicationContext());
        boolean usingAltStyles = mnistAltStyles.useAltStyles(getApplicationContext());

        tolMapCheckbox = new SwitchDrawerItem().withIdentifier(1).withName(R.string.drawer_item_tolerance_maps).withIcon(Octicons.Icon.oct_tools).withChecked(usingTolMap).withOnCheckedChangeListener(onCheckedChangeListener);

        altStylesCheckbox = new SwitchDrawerItem().withIdentifier(2).withName(R.string.drawer_item_alternate_styles).withIcon(Octicons.Icon.oct_tools).withChecked(usingAltStyles).withOnCheckedChangeListener(onCheckedChangeListener);
        altStylesCheckbox.withEnabled(usingTolMap); // Disable this option if Tolerance Maps disabled

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withActionBarDrawerToggle(true)
                .withToolbar(toolbar)
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
                .withSelectedItem(-1)
                .withTranslucentStatusBar(false)
                .withSavedInstance(savedInstanceState)
                .build();

//        drawer.setDrawerIndicatorEnabled(false);

        //
        // Run Button
        //
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (snackbar == null) {
                    snackbar = Snackbar.make( view, "Training...", Snackbar.LENGTH_LONG);
                    snackbar.setDuration(Snackbar.LENGTH_INDEFINITE);
                }

                if (snackbar.isShown()) {
                    snackbar.dismiss();
                }
                else {
                    snackbar.setAction("Action", null).show();
                }
            }
        });

        //
        // Content
        //
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable && mnistTolMap != null && mnistAltStyles != null) {
                int id = (int)(drawerItem.getIdentifier());

                switch( id ) {
                    case 1:
                        mnistTolMap.setTolMap(isChecked, getApplicationContext());

                        altStylesCheckbox.withEnabled(isChecked);
                        altStylesCheckbox.withSwitchEnabled(isChecked);

                        drawer.updateItem(altStylesCheckbox);

                    case 2:
                        mnistAltStyles.setAltStyles(isChecked, getApplicationContext());
                    default:
                }

                Log.i("material-drawer", "DrawerItem: " + id + " " + (isChecked ? "checked" : "unchecked") );
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { return false; }  // Not using options menu
}