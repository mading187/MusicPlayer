package com.mading.service;

import com.mading.pojo.ListSong;
import com.mading.pojo.Song;
import java.util.List;

public interface ListSongService {
     List<Song> allListSong();

    List<ListSong> listSongOfSongId(int parseInt);
}
