package mydemo.forezp.com.mydemo.vedio;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import mydemo.forezp.com.mydemo.R;

/**
 * Created by b508a on 2016/1/20.
 */
public class VedioPlayActivity extends Activity implements TextureView.SurfaceTextureListener, MediaPlayer.OnCompletionListener,View.OnClickListener {


    @Bind(R.id.preview_video)
    TextureView previewVideo;
    @Bind(R.id.previre_play)
    ImageView previrePlay;
    @Bind(R.id.preview_video_parent)
    RelativeLayout previewVideoParent;
    @Bind(R.id.play)
    TextView play;

    private  MediaPlayer  mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_play);
        ButterKnife.bind(this);
        play.setOnClickListener(this);
        previrePlay.setOnClickListener(this);



    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        previrePlay.setVisibility(View.VISIBLE);
        play.setText("播放");
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width,
                                          int height) {
        prepare(new Surface(surfaceTexture));

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width,
                                            int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.play:
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    play.setText("暂停");
                    previrePlay.setVisibility(View.GONE);
                }else
                {
                    mediaPlayer.pause();
                    play.setText("播放");
                    previrePlay.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.preview_video:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    previrePlay.setVisibility(View.VISIBLE);
                    play.setText("播放");
                }
                break;
            case  R.id.previre_play:
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    play.setText("暂停");
                    previrePlay.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }

    String vedioPath="http://artapp-dev-bucket.oss-cn-beijing.aliyuncs.com/exercise_requirements/E9035DB1-711D-412A-97CC-0896505F910D4.mp4";
    private void prepare(Surface surface) {
        try {

            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            // 设置需要播放的视频
            mediaPlayer.setDataSource(vedioPath);
            // 把视频画面输出到Surface
            mediaPlayer.setSurface(surface);
            //把视频画面输出到SurfaceView
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
            mediaPlayer.setLooping(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
