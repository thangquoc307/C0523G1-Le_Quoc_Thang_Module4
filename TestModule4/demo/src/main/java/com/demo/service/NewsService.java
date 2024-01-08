package com.demo.service;

import com.demo.model.NewsEntity;
import com.demo.model.NewsTypeEntity;
import com.demo.repository.INewsRepository;
import com.demo.repository.INewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private INewsRepository newsRepository;
    @Autowired
    private INewsType newsType;

    public List<NewsTypeEntity> getAllType(){
        return newsType.findAll();
    }
    public List<NewsEntity> getNews(String key){
        return newsRepository.findNewsEntitiesByTitleContaining(key);
    }
    public void deleteNews(int id){
        newsRepository.deleteById(id);
    }
    public void create(NewsEntity newsEntity){
        newsRepository.save(newsEntity);
    }
//    public Page<NewsEntity> showAll(Pageable pageable){
//        return newsRepository.findAll(pageable);
//    }

}
