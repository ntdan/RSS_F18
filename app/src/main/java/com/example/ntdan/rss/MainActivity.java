package com.example.ntdan.rss;

import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView grd;
    RssAdapeter adp;
    PhanTichRSS phanTichRSS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grd = (GridView)findViewById(R.id.gridView);
        phanTichRSS = new PhanTichRSS(grd, adp, MainActivity.this);
        phanTichRSS.execute(Seeting.rssChanel);
    }
}
