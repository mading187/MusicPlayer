package com.mading.service;

import com.mading.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> commentOfSongListId(int parseInt);
}
