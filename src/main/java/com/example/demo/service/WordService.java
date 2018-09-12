package com.example.demo.service;

import com.example.demo.Utils.Response;

public interface WordService {
    Response getWodes(long userId);

    Response leaveWord(long userId,String title,String content);
}
