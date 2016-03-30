package mydemo.forezp.com.mydemo.contentProvider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.trilink.androidlib.base.BaseActivity;

/**
 * Created by b508a on 2016/3/30.
 */
public class ContentActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        insertRecord("MyUser");
        displayRecords();
    }

    private void insertRecord(String userName) {
        ContentValues values = new ContentValues();
        values.put(MyUser.User.USER_NAME, userName);
        getContentResolver().insert(MyUser.User.CONTENT_URI, values);
    }

    private void displayRecords() {
        String columns[] = new String[] { MyUser.User._ID, MyUser.User.USER_NAME };
        Uri myUri = MyUser.User.CONTENT_URI;
        Cursor cur = managedQuery(myUri, columns,null, null, null );
        if (cur.moveToFirst()) {
            String id = null;
            String userName = null;
            do {
                id = cur.getString(cur.getColumnIndex(MyUser.User._ID));
                userName = cur.getString(cur.getColumnIndex(MyUser.User.USER_NAME));
                Toast.makeText(this, id + "" + userName, Toast.LENGTH_LONG).show();
            } while (cur.moveToNext());
        }
    }
}
