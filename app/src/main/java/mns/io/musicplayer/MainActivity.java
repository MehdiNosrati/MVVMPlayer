package mns.io.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import mns.io.musicplayer.model.Music;
import mns.io.musicplayer.model.musicViewModel.MusicViewModel;
import mns.io.musicplayer.model.repository.DataRepository;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.PermissionRequest;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0x4);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x3);
        }

        final MusicViewModel musicViewModel = new MusicViewModel(getApplication(), getApplicationContext());

        observeViewModel(musicViewModel);

    }

    private void observeViewModel(final MusicViewModel musicViewModel) {
        musicViewModel.getMusicsLiveData().observe(this, new Observer<List<Music>>() {
            private String TAG = "changed datas";

            @Override
            public void onChanged(List<Music> music) {
                Log.i(TAG, "onChanged: data changed" + music.size());
                for (Music m : music
                ) {
                    if (m.isPlaying()) {
                        MusicPlayer.play(m);
                        m.setPlaying(false);
                    }
                }

            }
        });
    }
}
