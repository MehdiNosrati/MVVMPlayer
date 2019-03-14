package mns.io.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import mns.io.musicplayer.model.Music;
import mns.io.musicplayer.model.musicViewModel.MusicViewModel;
import mns.io.musicplayer.model.repository.DataRepository;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MusicViewModel musicViewModel = new MusicViewModel(getApplication(), getApplicationContext());

        observeViewModel(musicViewModel);

    }

    private void observeViewModel(final MusicViewModel musicViewModel) {
        musicViewModel.getMusicsLiveData().observe(this, new Observer<List<Music>>() {
            private String TAG = "changed datas";

            @Override
            public void onChanged(List<Music> music) {
                Log.i(TAG, "onChanged: data changed");
            }
        });
    }
}
