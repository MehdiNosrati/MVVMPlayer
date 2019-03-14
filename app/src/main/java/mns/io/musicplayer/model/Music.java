package mns.io.musicplayer.model;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "musics")
public class Music {
    public Music(String name, @NonNull String path, int duration) {
        this.name = name;
        this.path = path;
        this.duration = duration;
    }

    private String name;
    @PrimaryKey
    @NonNull
    private String path;

    private int duration;

    public String getName() {
        return name;
    }

    public void setName(String music) {
        this.name = music;
    }

    @NonNull
    public String getPath() {
        return path;
    }

    public void setPath(@NonNull String path) {
        this.path = path;
    }





    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
