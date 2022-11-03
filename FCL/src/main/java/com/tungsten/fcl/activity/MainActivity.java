package com.tungsten.fcl.activity;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.tabs.TabLayout;
import com.tungsten.fcl.R;
import com.tungsten.fcl.ui.UIManager;
import com.tungsten.fcllibrary.component.FCLActivity;
import com.tungsten.fcllibrary.component.theme.ThemeEngine;
import com.tungsten.fcllibrary.component.view.FCLDynamicIsland;
import com.tungsten.fcllibrary.component.view.FCLTitleView;
import com.tungsten.fcllibrary.component.view.FCLUILayout;

public class MainActivity extends FCLActivity implements TabLayout.OnTabSelectedListener {

    public ConstraintLayout background;
    private FCLDynamicIsland titleView;

    private UIManager uiManager;
    private FCLUILayout uiLayout;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = findViewById(R.id.background);
        background.setBackground(ThemeEngine.getInstance().getTheme().getBackground(this));

        titleView = findViewById(R.id.title);

        uiLayout = findViewById(R.id.ui_layout);
        uiManager = new UIManager(this, uiLayout);
        uiManager.init();

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(this);
        tabLayout.selectTab(tabLayout.getTabAt(3));
        ThemeEngine.getInstance().registerEvent(tabLayout, () -> {
            tabLayout.setBackgroundColor(ThemeEngine.getInstance().getTheme().getColor());
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                titleView.setTextWithAnim(getString(R.string.account));
                break;
            case 1:
                titleView.setTextWithAnim(getString(R.string.version));
                break;
            case 2:
                titleView.setTextWithAnim(getString(R.string.install));
                break;
            case 4:
                titleView.setTextWithAnim(getString(R.string.download));
                break;
            case 5:
                titleView.setTextWithAnim(getString(R.string.multiplayer));
                break;
            case 6:
                titleView.setTextWithAnim(getString(R.string.setting));
                break;
            default:
                titleView.setTextWithAnim(getString(R.string.app_name));
                uiManager.switchUI(uiManager.getMainUI());
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        // Ignore
    }
}