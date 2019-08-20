package com.example.gung;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class DetailActivity extends FragmentActivity {

    public static final String EXTRA_IMAGE_URL = "detailImageUrl";
    public static final String NAME_PALACE = "name_palace";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.image);
        TextView name_palace = findViewById(R.id.name_palace);
        Button description = findViewById(R.id.description);
        Button guide = findViewById(R.id.guide);
        Button story = findViewById(R.id.story);

        //사진이랑 궁궐이름 가져오기
        String imageUrl = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        String names = getIntent().getStringExtra(NAME_PALACE);
        ImageLoader.getInstance().displayImage(imageUrl, imageView);
        name_palace.setText(names);


        if(names.equals("경복궁")){
            description.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
        }


    }

}
