
package com.jeeva.drumpad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.jeeva.drumpad.adapter.RecyclerDrumPad;
import com.jeeva.drumpad.databinding.ActivityDrumpadBinding;
import com.jeeva.drumpad.listener.ClickListener;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

public class Drumpad extends AppCompatActivity implements ClickListener {

    ActivityDrumpadBinding drumPadBinding;
    RecyclerDrumPad recyclerDrumPad;
    List<DrumPadData> drumPadData ;
    SimpleExoPlayer player;
    MediaItem mediaItem;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drumPadBinding = ActivityDrumpadBinding.inflate(getLayoutInflater());
        setColorCodes();
        setContentView(drumPadBinding.getRoot());
        recyclerDrumPad = new RecyclerDrumPad(drumPadData,this);
        drumPadBinding.drumPad.setAdapter(recyclerDrumPad);
        drumPadBinding.drumPad.setLayoutManager( new GridLayoutManager(this, 3));
        drumPadBinding.drumPad.setHasFixedSize(true);
        player = new SimpleExoPlayer.Builder(this).build();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setColorCodes() {
        drumPadData = Arrays.asList(
                new DrumPadData(getDrawable(R.drawable.hiphop),"hip hop"),
                 new DrumPadData(getDrawable(R.drawable.pop),"pop"),
                 new DrumPadData(getDrawable(R.drawable.funk),"funk"),
                 new DrumPadData(getDrawable(R.drawable.disco),"disco"),
                 new DrumPadData(getDrawable(R.drawable.trap),"trap"),
                 new DrumPadData(getDrawable(R.drawable.techno),"techno"),
                 new DrumPadData(getDrawable(R.drawable.dub),"dub"),
                 new DrumPadData(getDrawable(R.drawable.reggae),"reggae"),
                 new DrumPadData(getDrawable(R.drawable.jazz),"jazz")
        );
    }

    @Override
    public void btnOnClick(int position) {
        switch (drumPadData.get(position).getTitle()){
            case "hip hop":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.hiphop);
                break;
            case "pop":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.pop);
                break;
            case "funk":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.funk);
                break;
            case "disco":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.disco);
                break;
            case "trap":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.trap);
                break;
            case "techno":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.techno);
                break;
            case "dub":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.dub);
                break;
            case "reggae":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.reggae);
                break;
            case "jazz":
                uri = RawResourceDataSource.buildRawResourceUri(R.raw.jazz);
                break;
        }
        mediaItem = MediaItem.fromUri(uri);
        player.setMediaItem(mediaItem);
        player.setPlayWhenReady(true);
        player.seekTo(0, 0);
        player.prepare();
    }
}