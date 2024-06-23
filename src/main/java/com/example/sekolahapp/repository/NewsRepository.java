package com.example.sekolahapp.repository;

import com.example.sekolahapp.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
