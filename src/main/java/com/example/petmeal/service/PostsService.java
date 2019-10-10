package com.example.petmeal.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.petmeal.domain.PostsRepository;
import com.example.petmeal.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}