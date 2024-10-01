package com.akerumort.postservice.services;

import com.akerumort.postservice.entities.PostViewCount;
import com.akerumort.postservice.services.repo.PostViewCountRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostViewCountService {
    private final PostViewCountRepoService postViewCountRepoService;

    @Transactional
    public PostViewCount incrementViewCount(Long postId) {
        PostViewCount postViewCount = postViewCountRepoService.findViewCountById(postId);
        postViewCount.setViewCount(postViewCount.getViewCount() + 1);
        return postViewCountRepoService.saveViewCount(postViewCount);
    }

    @Transactional(readOnly = true)
    public int getViewCount(Long postId) {
        return postViewCountRepoService.findViewCountById(postId).getViewCount();
    }
}
