package com.example.sekolahapp.services;
import com.example.sekolahapp.model.News;
import com.example.sekolahapp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsById(Long id) {
        Optional<News> newsOptional = newsRepository.findById(id);
        return newsOptional.orElse(new News()); // Returns a new News object if not found
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(Long id, News updatedNews) {
        Optional<News> newsOptional = newsRepository.findById(id);
        if (newsOptional.isPresent()) {
            News existingNews = newsOptional.get();
            existingNews.setTitle(updatedNews.getTitle());
            existingNews.setContent(updatedNews.getContent());
            return newsRepository.save(existingNews);
        }

    public void deleteNews(Long id) {
        News news = newsRepository.findById(id);
        newsRepository.delete(news);
    }
}

