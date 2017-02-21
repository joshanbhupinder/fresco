package projects.com.kamboj.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import projects.com.kamboj.R;
import projects.com.kamboj.model.StudentModel;

/**
 * Created by android on 3/2/17.
 */

public class FrescoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StudentModel> mList;
    private Context mContext;

    public FrescoAdapter(Context context, List<StudentModel> studentModels) {
        this.mContext = context;
        this.mList = studentModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.fresco, parent, false);

        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.e("mList", ":" + mList.size());
        final StudentModel studentModel = mList.get(position);
        if (studentModel != null) {
            ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
            viewHolderClass.txtname.setText(studentModel.getName());
            Uri imageUri = Uri.parse(studentModel.getName());
            // Uri imageUri = Uri.parse("https://i.imgur.com/tGbaZCY.jpg");
            viewHolderClass.img.setImageURI(imageUri);

            Bitmap bm = decodeSampledBitmapFromUri(studentModel.getName(), 220, 220);

            viewHolderClass.img.setImageBitmap(bm);

        }
    }

    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float) height / (float) reqHeight);
            } else {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }
        }

        return inSampleSize;
    }


    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {

        Bitmap bm = null;
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolderClass extends RecyclerView.ViewHolder {


        @Bind(R.id.txtname)
        TextView txtname;


        @Bind(R.id.imageview)
        SimpleDraweeView img;

        private ViewHolderClass(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
