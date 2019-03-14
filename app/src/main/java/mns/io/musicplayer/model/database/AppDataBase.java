package mns.io.musicplayer.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import mns.io.musicplayer.model.Music;

@Database(entities = {Music.class}, version = 1)

public abstract class AppDataBase extends RoomDatabase {

    public abstract DAO getMusicDao();
}

