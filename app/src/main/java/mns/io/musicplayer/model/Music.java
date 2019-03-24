package mns.io.musicplayer.model;

import android.app.Application;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "musics")
public class Music extends BaseObservable {
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

    @Bindable
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



    @Ignore
    private boolean isPlaying = false;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    @Bindable
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
