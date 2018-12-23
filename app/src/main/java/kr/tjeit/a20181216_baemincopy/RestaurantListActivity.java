package kr.tjeit.a20181216_baemincopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RestaurantListActivity extends BaseActivity {

    String foodKind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        foodKind = getIntent().getStringExtra("음식종류");


        setTitle(String.format("%s 배달 가능 식당 목록", foodKind));

    }

    @Override
    public void bindViews() {

    }
}
