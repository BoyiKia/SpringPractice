package com.example.demo.service;

import com.example.demo.Utils.CommonTools;
import com.example.demo.Utils.Response;
import com.example.demo.domain.People;
import com.example.demo.domain.Word;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WordRepository wordRepository;

    @Override
    public Response getWodes(long userId) {

        List<Word> words = wordRepository.findByUserId(userId);
        if(words.isEmpty()){
            return new Response("1","没有留言");
        }else{

             return new Response("0",words);
        }


    }

    @Override
    public Response leaveWord(long userId, String title, String content) {
        People one = userRepository.getOne(userId);
        if(one==null){
            return new Response("1","用户不存在");
        }
        if(CommonTools.isEmpty(title))
            return new Response("1","标题不能为空");
        if(CommonTools.isEmpty(content))
            return new Response("1","内容不能为空");

        Word word=new Word();
        word.setUserId(userId);
        word.setTitle(title);
        word.setContent(content);

        wordRepository.save(word);

        return  new Response("0",word);
    }
}
