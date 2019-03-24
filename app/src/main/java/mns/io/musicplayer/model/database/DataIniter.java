package mns.io.musicplayer.model.database;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaActionSound;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
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
            initLoacally(context);
        }
    }

    private void initLoacally(Context context) {
        Log.d("datas", "again locally");
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION,
        };

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null);


        while(cursor.moveToNext()){
            this.add(new Music(cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(5))));

        }
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
