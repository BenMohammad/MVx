package com.fukuni.mvx.screens.common.navdrawer;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.fukuni.mvx.R;
import com.fukuni.mvx.screens.common.views.BaseObservableViewMvc;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseNavDrawerViewMvc<ListenerType> extends BaseObservableViewMvc<ListenerType> {

    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView navView;

    public BaseNavDrawerViewMvc(LayoutInflater inflater, ViewGroup parent) {
        super.setRootview(inflater.inflate(R.layout.layout_drawer, parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        navView = findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(menuItem -> {
            if(menuItem.getItemId() == R.id.drawer_menu_questions_list) {
                onDrawerItemClicked(DrawerItems.QUESTIONS_LIST);
            }
            return false;
        });
    }

    protected void openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    protected abstract void onDrawerItemClicked(DrawerItems questionsList);

    @Override
    protected void setRootview(View rootview) {
        mFrameLayout.addView(rootview);
    }
}
