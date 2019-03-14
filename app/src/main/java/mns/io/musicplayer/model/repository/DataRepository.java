package mns.io.musicplayer.model.repository;

import android.content.Context;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import mns.io.musicplayer.model.Music;
import mns.io.musicplayer.model.database.DataIniter;

public class DataRepository {

    private static DataIniter initer;
    public DataRepository(Context context) {
        initer = new DataIniter(context);
    }
    public LiveData<List<Music>> getMusic(){
        final MutableLiveData<List<Music>> data = new MutableLiveData<>();
        data.setValue(initer.getMusicList());
        return data;
    }
    public static void add(Music music){
        initer.add(music);
    }


}
