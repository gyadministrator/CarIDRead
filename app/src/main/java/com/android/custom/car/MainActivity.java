package com.android.custom.car;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.custom.carlib.util.CarNoReadUtil;
import com.wildma.pictureselector.FileUtils;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

public class MainActivity extends AppCompatActivity {
    private Button btnSelect;
    private ImageView ivIcon;
    private static final String TAG = "MainActivity";
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnSelect = findViewById(R.id.btn_select);
        ivIcon = findViewById(R.id.iv_icon);
        tvResult = findViewById(R.id.tv_result);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select();
            }
        });
    }

    private void select() {
        PictureSelector.create(this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(true, 200, 200, 1, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                PictureBean pictureBean = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
                if (pictureBean != null) {
                    goRead(pictureBean);
                    if (pictureBean.isCut()) {
                        ivIcon.setImageBitmap(BitmapFactory.decodeFile(pictureBean.getPath()));
                    } else {
                        ivIcon.setImageURI(pictureBean.getUri());
                    }
                }
            }
        }
    }

    private void goRead(PictureBean pictureBean) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                CarNoReadUtil.read("", new CarNoReadUtil.OnCarReadListener() {
                    @Override
                    public void success(String result) {
                        tvResult.setText(result);
                    }

                    @Override
                    public void error(String msg) {
                        tvResult.setText(msg);
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FileUtils.deleteAllCacheImage(this);
    }
}
