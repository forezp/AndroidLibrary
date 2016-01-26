package mydemo.forezp.com.mydemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by b508a on 2016/1/6.
 */
public class FrescoActivity extends Activity {

    private SimpleDraweeView user_avator;
    private  SimpleDraweeView sdv1;//
    private SimpleDraweeView sdv2;//
    private SimpleDraweeView sdv3;//gif
    private  SimpleDraweeView sdv4;//
    private  SimpleDraweeView sdv5;//
    private  SimpleDraweeView sdv6;//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fresco);
        user_avator = (SimpleDraweeView) findViewById(R.id.user_avator);
        Uri uri=Uri.parse("http://pica.nipic.com/2008-03-19/2008319183523380_2.jpg");
        //Uri uri=Uri.parse("http://artapp-dev-bucket.oss-cn-beijing.aliyuncs.com/exercise/a4.png");
        user_avator.setImageURI(uri);
        sdv1=(SimpleDraweeView)findViewById(R.id.sdv1);
        sdv1.setImageURI(Uri.parse("http://baike.soso.com/p/20090711/20090711101754-314944703.jpg"));
        sdv2=(SimpleDraweeView)findViewById(R.id.sdv2);
        sdv2.setImageURI(Uri.parse("http://img.taopic.com/uploads/allimg/130501/240451-13050106450911.jpg"));
        sdv3=(SimpleDraweeView)findViewById(R.id.sdv3);
        Uri uri1=Uri.parse("http://pic.joke01.com/uppic/13-05/30/30215236.gif");
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri1)


        .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request).setAutoPlayAnimations(true)
        .build();
        sdv3.setController(controller);

        sdv4=(SimpleDraweeView)findViewById(R.id.sdv4);
        sdv4.setImageURI(Uri.parse("http://baike.soso.com/p/20090711/20090711101754-314944703.jpg"));
        sdv5=(SimpleDraweeView)findViewById(R.id.sdv5);
        sdv5.setImageURI(Uri.parse("http://baike.soso.com/p/20090711/20090711101754-314944703.jpg"));
        sdv6=(SimpleDraweeView)findViewById(R.id.sdv6);
        sdv6.setImageURI(Uri.parse("http://baike.soso.com/p/20090711/20090711101754-314944703.jpg"));
    }
}
