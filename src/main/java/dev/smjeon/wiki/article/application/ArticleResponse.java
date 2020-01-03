package dev.smjeon.wiki.article.application;

import dev.smjeon.wiki.Content;

import java.time.LocalDateTime;

public class ArticleResponse {
    private Long id;
    private LocalDateTime updatedTime;
    private Content content;
}
