package mns.io.musicplayer.model.musicViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import mns.io.musicplayer.model.Music;
import mns.io.musicplayer.model.repository.DataRepository;

public class MusicViewModel extends AndroidViewModel {
    private LiveData<List<Music>> modelLiveData = null;

    public MusicViewModel(@NonNull Application application, Context context) {
        super(application);
        DataRepository repository = new DataRepository(context);
        modelLiveData = repository.getMusic();
        Log.d("MUSICVIEWMODELLOGGER", "datas here!");

    }


    public LiveData<List<Music>> getMusicsLiveData(){
        return modelLiveData;
    }


}
