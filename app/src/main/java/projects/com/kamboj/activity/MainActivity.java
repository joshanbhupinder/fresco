package projects.com.kamboj.activity;


import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import projects.com.kamboj.R;
import projects.com.kamboj.adapter.FrescoAdapter;
import projects.com.kamboj.adapter.PicasoAdapter;
import projects.com.kamboj.model.StudentModel;


public class MainActivity extends AppCompatActivity {


    List<StudentModel> studentModels = new ArrayList<>();

    @Bind(R.id.recyle)
    RecyclerView recyclerView;

    @Bind(R.id.galleryGridView)
    GridView gridView;


    @Bind(R.id.id)
    ImageView idd;

    @Bind(R.id.edit)
    EditText editText;

    private ArrayList<String> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        ButterKnife.bind(this);

//        ASSA assa=new ASSA(this,"750726",this);

        // assa.getKey();

        images = getAllShownImagesPath(MainActivity.this);
        for (int i = 0; i < images.size(); i++) {

            StudentModel studentModel = new StudentModel();
            //studentModel.setName("POSTION : "+i);
            studentModel.setName(images.get(i));
            studentModels.add(studentModel);
        }

        //
        // editText.requestFocus();
    }


    /**
     * Getting All Images Path.
     *
     * @param activity the activity
     * @return ArrayList with images Path
     */
    private ArrayList<String> getAllShownImagesPath(Activity activity) {
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);


        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);

            Log.e("absolutePathOfImage", ":" + absolutePathOfImage);
            //  idd.setImageBitmap(BitmapFactory.decodeFile("/storage/emulated/0/DCIM/Camera/IMG_20160713_102538213.jpg"));
            listOfAllImages.add(absolutePathOfImage);
        }
        return listOfAllImages;
    }


    @OnClick(R.id.btn_picasso)
    public void getImagesThroughPicasso() {
        PicasoAdapter studentAdapter = new PicasoAdapter(MainActivity.this, studentModels);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @OnClick(R.id.btn_volley)
    public void getImagesThroughVolley() {
    }

    @OnClick(R.id.btn_glide)
    public void getImagesThroughGlide() {
    }

    @OnClick(R.id.btn_universal_image_loader)
    public void getImagesThroughUniversalImageLoader() {
    }

    @OnClick(R.id.btn_fresco)
    public void getImagesThroughFresco() {
        FrescoAdapter studentAdapter = new FrescoAdapter(MainActivity.this, studentModels);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }


}
