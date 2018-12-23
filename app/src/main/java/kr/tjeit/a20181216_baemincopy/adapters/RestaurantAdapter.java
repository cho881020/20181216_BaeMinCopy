package kr.tjeit.a20181216_baemincopy.adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import kr.tjeit.a20181216_baemincopy.R;
import kr.tjeit.a20181216_baemincopy.datas.Restaurant;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    Context mContext;
    List<Restaurant> mList;
    LayoutInflater inf; // XML -> JAVA에서 활용가능하게 그려주는 역할. 인플레이팅.

    public RestaurantAdapter(Context mContext, List<Restaurant> mList) {
        super(mContext, R.layout.restaurant_list_item, mList);

        this.mContext = mContext;
        this.mList = mList;
        this.inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.restaurant_list_item, null);
        }

        TextView nameTxt = row.findViewById(R.id.nameTxt);
        TextView addressTxt = row.findViewById(R.id.addressTxt);
        TextView openTimeTxt = row.findViewById(R.id.openTimeTxt);
        ImageView logoImgView = row.findViewById(R.id.logoImgView);
        Button callBtn = row.findViewById(R.id.callBtn);

        Restaurant data = mList.get(position);

        nameTxt.setText(data.getName());
        addressTxt.setText(data.getAddress());
        openTimeTxt.setText(data.getOpenTime());
        Glide.with(mContext).load(data.getLogoURL()).into(logoImgView);

//        버튼이 달려있다면 findViewById로 연결해서 setOnClick 작성

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                전화를 바로 걸기. 전화번호는 임시로 01012345678

                PermissionListener pl = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
//                        전화 거는 권한이 승인되었다면, 실제로 전화를 검.
                        Uri uri = Uri.parse("tel:01012345678");
                        Intent intent = new Intent(Intent.ACTION_CALL, uri);
                        mContext.startActivity(intent);
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(mContext, "전화를 걸기 위해선 권한 승인이 필요합니다.", Toast.LENGTH_SHORT).show();
                    }
                };

                TedPermission
                        .with(mContext)
                        .setPermissionListener(pl)
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .check();

            }
        });


        return row;
    }
}













