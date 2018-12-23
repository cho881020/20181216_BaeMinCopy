package kr.tjeit.a20181216_baemincopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;

public class NaverMapActivity extends NMapActivity {

    private NMapView mMapView;
    private String CLIENT_ID = "GtNKdR4yqAFn6qdL8uPY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView = new NMapView(NaverMapActivity.this);
        setContentView(mMapView);

        mMapView.setClientId(CLIENT_ID);
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();

    }

}







