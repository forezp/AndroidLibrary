package mydemo.forezp.com.mydemo.contentProvider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by b508a on 2016/3/30.
 */
public class MyUser {

    public static final String AUTHORITY  = "mydemo.forezp.com.mydemo.contentProvider";

    // BaseColumn类中已经包含了 _id字段
    public static final class User implements BaseColumns {
        public static final Uri CONTENT_URI  = Uri.parse("content://mydemo.forezp.com.mydemo.contentProvider");
        // 表数据列
        public static final String  USER_NAME  = "USER_NAME";
    }
}
