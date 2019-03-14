package mns.io.musicplayer.model.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import mns.io.musicplayer.model.Music;

@Dao
public interface DAO {
    @Insert
    public void insert(Music... music);

    @Delete
    public void delete(Music music);

    @Query("SELECT * FROM musics")
    public List<Music> getMusics();

    @Query("SELECT * FROM musics WHERE name LIKE :search")
    public List<Music> searchFor(String search);
}
