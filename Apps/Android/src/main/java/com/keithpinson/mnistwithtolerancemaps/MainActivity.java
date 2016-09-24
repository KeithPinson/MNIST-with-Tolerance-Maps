package com.keithpinson.mnistwithtolerancemaps;

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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar = null;
    private Drawer drawer = null;
    private PrimaryDrawerItem tolMapCheckbox = null;
    private PrimaryDrawerItem altStylesCheckbox = null;


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
/*
        drawer = new DrawerBuilder().
                    withActivity(this).
                    withActionBarDrawerToggle(true).
                    withToolbar(toolbar).
                    build();
*/
        tolMapCheckbox = new PrimaryDrawerItem().withName(R.string.drawer_item_tolerance_maps).withIcon(FontAwesome.Icon.faw_check_square_o);
        altStylesCheckbox = new PrimaryDrawerItem().withName(R.string.drawer_item_alternate_styles).withIcon(FontAwesome.Icon.faw_check_square_o);

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withActionBarDrawerToggle(true)
                .withToolbar(toolbar)
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

//        drawer.setDrawerIndicatorEnabled(false);

        //
        // Run Button
        //
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //
        // Content
        //
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { return false; }  // Not using options menu
}