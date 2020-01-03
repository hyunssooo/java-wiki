package dev.smjeon.wiki.article.presentation;

import dev.smjeon.wiki.article.application.ArticleResponse;
import dev.smjeon.wiki.article.application.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/{articleId}")
    public ResponseEntity<ArticleResponse> readArticle(@PathVariable Long articleId) {
        ArticleResponse articleResponse = articleService.findById(articleId);

        return ResponseEntity.ok().body(articleResponse);
    }
}
