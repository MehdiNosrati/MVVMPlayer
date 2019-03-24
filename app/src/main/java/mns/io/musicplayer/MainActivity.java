package mns.io.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import mns.io.musicplayer.databinding.ActivityMainBinding;
import mns.io.musicplayer.model.Music;
import mns.io.musicplayer.model.musicViewModel.MusicListViewModel;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MusicListViewModel musicViewModel;


    public static MusicPlayer musicPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

       MusicPlayer.init(getApplicationContext());


        initLiveData();






        setupRecyclerAdapter();




     //   binding.setTmp(musicViewModel);

    }

    private void setupRecyclerAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.music_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MusicAdapter(musicViewModel.getMusicsLiveData().getValue(), getApplicationContext());
        recyclerView.setAdapter(mAdapter);
    }

    private void initLiveData() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0x4);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x3);
        }

        musicViewModel = new MusicListViewModel(getApplication(), getApplicationContext());
        observeViewModel(musicViewModel);

    }

    private void observeViewModel(final MusicListViewModel musicViewModel) {
        musicViewModel.getMusicsLiveData().observe(this, new Observer<List<Music>>() {
            private String TAG = "changed datas";


            @Override
            public void onChanged(List<Music> music) {



            }
        });
    }

}
