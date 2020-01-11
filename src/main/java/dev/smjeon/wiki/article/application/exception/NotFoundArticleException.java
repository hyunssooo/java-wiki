package dev.smjeon.wiki.article.application.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFoundArticleException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(NotFoundArticleException.class);

    public NotFoundArticleException(Long articleId) {
        logger.info("Not Found Article: {}", articleId);
    }
}
