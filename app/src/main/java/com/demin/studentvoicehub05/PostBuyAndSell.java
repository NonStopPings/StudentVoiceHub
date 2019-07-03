package com.demin.studentvoicehub05;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PostBuyAndSell extends AppCompatActivity {

    TextView mTitleTv,mDetailTv,mEmailTv,mPriceTv,mCampusTv;
    ImageView mImageIv;

    Bitmap bitmap;

    Button mSaveBtn,mShareBtn,mEmailBtn;

    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_buy_and_sell);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Item Detail");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mTitleTv = findViewById(R.id.titleTv);
        mEmailTv = findViewById(R.id.emailTv);
        mPriceTv = findViewById(R.id.priceTv);
        mCampusTv = findViewById(R.id.campusTv);
        mDetailTv = findViewById(R.id.descriptionTv);
        mImageIv = findViewById(R.id.imageView);
        mSaveBtn = findViewById(R.id.saveBtn);
        mShareBtn = findViewById(R.id.shareBtn);
        mEmailBtn = findViewById(R.id.emailBtn);

        String image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");
        String email = getIntent().getStringExtra("email");
        String price = getIntent().getStringExtra("price");
        String campus = getIntent().getStringExtra("campus");

        mTitleTv.setText(title);
        mDetailTv.setText(desc);
        mEmailTv.setText(email);
        mPriceTv.setText(price);
        mCampusTv.setText(campus);
        Picasso.get().load(image).into(mImageIv);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission,WRITE_EXTERNAL_STORAGE_CODE);
                    }else {
                        saveImage();
                    }
                }else {
                    saveImage();
                }
            }
        });
        mShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        });
        mEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fs.manukau.ac.nz/adfs/ls/?client-request-id=aaf8103b-598f-461a-b5eb-c41f78bde38e&username=&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=estsredirect%3d2%26estsrequest%3drQIIAY2RP2wSUQDGeRycLTEpUYfGpY1xsrnj3nv3v-nQ4zihHhHaAoWFHPcHjnI8hDsOMe4djHZw6ujIaGJiTBxMnBqHzl1djC7GqaMlLm76G758ybf9vgcUZKF6n_sDYpbJcJ4HGdtdtr8Y38pkt7NXi1fNu8a7H583Zh-_vjwDa4E1jI6tKLD8AWuTYAE2emE4mqi5HInCASHHLPE833aXY47EVu49ABcALJKSiEVFgryiYBEqGCMBsa5oSRb2XMZyZI_hkYcYRRYFxnVtBCFvOx1JukyuPd6Nwh5aBhn7c_dXctUj46A9IpPwjHoNdDvU9EmpWyho-5wZ8URoaOURNPgZkuNqT-_kY1Taz09NfoodKI9HlqS3HB0XmkeaVjPHfv1pLGjxpFwYdFt7nmEbT-ZyS9c4jTRKM1Nr9NqHefiwAuX5sM84ReNQelSf9jsVJTYl2a7NsdnHoVA5OIrqyGw1onasLaj_kvyWoq89BWR4TtFk5A595yIFvqducpS6spLJJtYTm4mrFHiTvj4juP2lw66n9ZMXz7rPP91LnKdzvCtWK6i3J_FCrVMmsaDDrUlxVivm_SYWDNkyhN1-dcs4qMQ7nApPaXBK099o8JMGJzcSH1b_9d1l5g7ioMJwIoPETYhUXlCx1PoN0"));
                startActivity(browserIntent);
            }
        });

    }

    private void shareImage() {
        try {
            bitmap = ((BitmapDrawable)mImageIv.getDrawable()).getBitmap();
            String s = mTitleTv.getText().toString() + "\n" + mDetailTv.getText().toString();

            File file = new File(getExternalCacheDir(), "sample.png");
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true,false);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_TEXT, s);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/png");
            startActivity(Intent.createChooser(intent,"Share via"));
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void saveImage() {
        bitmap = ((BitmapDrawable)mImageIv.getDrawable()).getBitmap();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());

        File path = Environment.getExternalStorageDirectory();

        File dir = new File(path + "/Firebase/");
        dir.mkdirs();
        String imageName = timeStamp + ".PNG";
        File file = new File(dir,imageName);
        OutputStream out;
        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100, out);
            out.flush();
            out.close();
            Toast.makeText(this,imageName + " saved to" + dir,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case WRITE_EXTERNAL_STORAGE_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED){
                    saveImage();
                }else {
                    Toast.makeText(this,"enable permission to save image",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
