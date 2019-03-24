package mns.io.musicplayer;

import android.content.Context;
import android.net.Uri;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import mns.io.musicplayer.model.Music;

public class MusicPlayer {
    static ExoPlayer exoPlayer;
    static RenderersFactory renderersFactory;
    static TrackSelector trackSelector;
    static Context ctx;
    public static void init(Context context) {
        renderersFactory = new DefaultRenderersFactory(context, null, DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF);
        trackSelector = new DefaultTrackSelector();
        exoPlayer = ExoPlayerFactory.newSimpleInstance(
                renderersFactory,
                trackSelector
        );
        ctx = context;
    }

    public static void play(Music m) {
        String userAgent = Util.getUserAgent(ctx, "MPlayer");
        MediaSource mediaSource = new ExtractorMediaSource(
                Uri.parse(m.getPath()),
                new DefaultDataSourceFactory(ctx, userAgent),
                new DefaultExtractorsFactory(),
                null,
                null
        );
        exoPlayer.prepare(mediaSource);
        exoPlayer.setPlayWhenReady(true);


    }
    public static void stop(){
        exoPlayer.stop();
    }
}