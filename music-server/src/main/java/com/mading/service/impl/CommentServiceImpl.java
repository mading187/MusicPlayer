package com.mading.service.impl;

import com.mading.dao.CommentMapper;
import com.mading.pojo.Comment;
import com.mading.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> commentOfSongListId(int songListId) {
        return commentMapper.commentOfSongListId(songListId);
    }
}
