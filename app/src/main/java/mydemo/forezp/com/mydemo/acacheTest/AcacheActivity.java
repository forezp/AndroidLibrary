package mydemo.forezp.com.mydemo.acacheTest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.trilink.androidlib.base.BaseActivity;
import com.trilink.androidlib.cache.Acache;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mydemo.forezp.com.mydemo.Note;
import mydemo.forezp.com.mydemo.R;

/**Acache
 * Created by b508a on 2016/2/2.
 */
public class AcacheActivity extends BaseActivity {

    @Bind(R.id.btn_add_string)
    Button btnAddString;
    @Bind(R.id.btn_add_modle)
    Button btnAddModle;
    @Bind(R.id.btn_show_string)
    Button btnShowString;
    @Bind(R.id.btn_show_model)
    Button btnShowModel;
    @Bind(R.id.tv_show)
    TextView tvShow;

    private Acache acache;
    @OnClick (R.id.btn_add_string)
    void addString(){
        acache.put("hi","hello world");
    }



    @OnClick (R.id.btn_add_modle)
    void addmodel(){
        Note note=new Note();
        note.setComment("this model");
        note.setText("generateBygreenDao");
        acache.put("model", note);
    }
    @OnClick(R.id.btn_show_string)
    void showString(){
        tvShow.setText(acache.getAsString("hi"));
    }
    @OnClick(R.id.btn_show_model)

    void showmodel(){
        Note note= (Note) acache.getAsObject("model");

        tvShow.setText(note.getText()+"~"+note.getComment()+"!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acache_test);
        ButterKnife.bind(this);
        acache=Acache.get(this);
    }
}
