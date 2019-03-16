package mns.io.musicplayer.model.database;

import android.content.Context;

import java.util.List;

import androidx.room.Room;
import mns.io.musicplayer.model.Music;
import mns.io.musicplayer.model.database.AppDataBase;
import mns.io.musicplayer.model.database.DAO;

public class DataIniter {
    private AppDataBase dataBase;
    private DAO dao;



    public DataIniter (Context context){
        this.dataBase = Room.databaseBuilder(context, AppDataBase.class, "musics")
                .allowMainThreadQueries()
                .build();
        this.dao = dataBase.getMusicDao();

        if (this.dataBase.getMusicDao().getMusics().size() < 100){
            initLoacally();
        }
    }

    private void initLoacally() {

    }

    public  void add(Music music){
        this.dao.insert(music);
    }
    public  List<Music> getMusicList(){
        return this.dao.getMusics();
    }
    public  List<Music> search(String search){
        return this.dao.searchFor(search);
    }

}
