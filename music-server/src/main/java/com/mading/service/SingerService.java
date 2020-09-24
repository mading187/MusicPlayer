package com.mading.service;

import com.mading.pojo.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> allSinger();

    List<Singer> singerOfSex(int sex);
}
