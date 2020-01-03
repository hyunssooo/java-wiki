package dev.smjeon.wiki.article.application;

import dev.smjeon.wiki.article.domain.Article;
import dev.smjeon.wiki.article.domain.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

    private ArticleRepository articleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ArticleService(final ArticleRepository articleRepository, final ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    public ArticleResponse findById(final Long articleId) {
        Article foundArticle = articleRepository.findById(articleId).orElseThrow(() -> new NotFoundArticleException(articleId));
        return modelMapper.map(foundArticle, ArticleResponse.class);
    }
}
