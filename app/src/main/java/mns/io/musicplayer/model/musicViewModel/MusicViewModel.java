package mns.io.musicplayer.model.musicViewModel;

import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import mns.io.musicplayer.MainActivity;
import mns.io.musicplayer.MusicPlayer;
import mns.io.musicplayer.model.Music;

public class MusicViewModel extends BaseObservable {
    private Music music;

    MusicPlayer musicPlayer;

    public MusicViewModel(Music m) {
        this.music = m;
    }
    public String getName(){
        return this.music.getName();
    }
    public String getDuration(){
        return this.music.getDuration()+"";
    }
    public void setMusic(Music m){
        this.music = m;
    }

    public void play(View view){
        MusicPlayer.stop();
        MusicPlayer.play(music);
    }
}
