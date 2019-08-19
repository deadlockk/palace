package com.example.gung;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class DetailActivity extends FragmentActivity {

    public static final String EXTRA_IMAGE_URL = "detailImageUrl";
    public static final String IMAGE_TRANSITION_NAME = "transitionImage";
    public static final String GPS_NAME = "gps";
    public static final String ADDRESS_PALACE = "address_palace";
    public static final String NAME_PALACE = "name_palace";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.image);
        View gps = findViewById(R.id.gps);
        TextView address_palace = findViewById(R.id.address_palace);
        TextView name_palace = findViewById(R.id.name_palace);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        String imageUrl = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        ImageLoader.getInstance().displayImage(imageUrl, imageView);

        ViewCompat.setTransitionName(imageView, IMAGE_TRANSITION_NAME);
        ViewCompat.setTransitionName(gps, GPS_NAME);
        ViewCompat.setTransitionName(address_palace, ADDRESS_PALACE);
        ViewCompat.setTransitionName(name_palace, NAME_PALACE);

    }

}
