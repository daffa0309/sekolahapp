package com.example.sekolahapp.usecases;



import com.example.sekolahapp.model.News;
import com.example.sekolahapp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(Long id, News newsDetails) {
        News news = newsRepository.findById(id).orElse(null);
        news.setTitle(newsDetails.getTitle());
        news.setContent(newsDetails.getContent());
        news.setAuthor(newsDetails.getAuthor());
        news.setDate(newsDetails.getDate());
        return newsRepository.save(news);
    }

    public void deleteNews(Long id) {
        News news = newsRepository.findById(id).orElse(null);
        newsRepository.delete(news);
    }
}

