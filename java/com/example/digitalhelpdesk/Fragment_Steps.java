package com.example.digitalhelpdesk;

import android.app.ActionBar;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Fragment_Steps extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListner =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT  ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        //audio focus loses for particular time so we need to pause audio file
                        mMediaPlayer.pause();
                        //Our audio file is just contain words of 2-3 seconds so we can start audio from beginning
                        mMediaPlayer.seekTo(0);
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        //we granted audio focus now play the audio file
                        //resume playback
                        mMediaPlayer.start();
                    }
                    else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        //audio focus loses so stop playback and
                        //release mediaplayer resources for other apps
                        releaseMediaPlayer();
                    }
                }
            };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public Fragment_Steps() {
        // Required empty public constructor
    }

    public static Fragment_Steps newInstance(int sectionNumber) {
        Fragment_Steps fragment = new Fragment_Steps();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.adapter_ma3, container, false);
        sectionNumber = getArguments() != null ? getArguments().getInt(ARG_SECTION_NUMBER) : 1;

        //Create and setup {@LINK AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        ArrayListObject position = MainActivity3.steps.get(sectionNumber-1);

        TextView textView1 = view.findViewById(R.id.text1);
        textView1.setText(position.getString());
        ImageView imageView2 = view.findViewById(R.id.image2);
        imageView2.setImageResource(position.getImgId());

        ImageView audio = view.findViewById(R.id.image1);
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //release all media file before playing another file
                //case :- it might be possible that user click's on multiple times so some of them not get cmplete so
                //on completion didn't call
                releaseMediaPlayer();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListner,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                    //Create and setup the {@link MediaPlayer} for audio resource
                    mMediaPlayer  = MediaPlayer.create(getActivity(), position.getMediaPlayerId());
                    //start the audio file
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return  view;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    public void releaseMediaPlayer() {
        //if media player is not null then it may be in running state
        if(mMediaPlayer != null){
            //It has some input file which is completed
            //we need to release that resource file
            mMediaPlayer.release();

            //if media player is released so we need to give it some value
            //so we give it initial value taken by it
            mMediaPlayer = null;

            //Abandon audio focus when playback complete
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListner);
        }
    }
}