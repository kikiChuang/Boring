package com.susion.boring.music.model;

import android.text.TextUtils;

import com.susion.boring.db.model.SimpleSong;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 17/1/20.
 * model for request accept wang yi music API
 */
public class Song implements Serializable, PlayQueueSong{
    public String id;
    public String name;
    public List<Singer> artists;
    public Album album;
    public String audio;
    public String djProgramId;
    public String page;

    public String mp3Url;

    public boolean hasDown;
    public boolean favorite;
    public boolean fromPlayList;
    public boolean isPlaying;

    public SimpleSong translateToSimpleSong(){
        SimpleSong simpleSong = new SimpleSong();

        if (!TextUtils.isEmpty(audio)) {
            simpleSong.setPath(audio);
        } else {
            simpleSong.setPath(mp3Url);
        }

        simpleSong.setDisplayName(name);
        simpleSong.setId(id);
        simpleSong.setArtist(artists.get(0).name);
        simpleSong.setFavorite(favorite);
        simpleSong.setHasDown(hasDown);
        simpleSong.setPicPath(album.picUrl);
        return simpleSong;
    }


    public String getArtist(){
        String artist = "";
        if (artists != null && !artists.isEmpty()) {
            for (int i=0; i<artists.size(); i++) {
                if (i == 0) {
                    artist = artists.get(i).name;
                } else {
                    artist += "、"+artists.get(i).name;
                }
            }
        }

        return artist;
    }
}
