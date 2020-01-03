package dev.smjeon.wiki.article.domain;

import dev.smjeon.wiki.BaseEntity;
import dev.smjeon.wiki.Content;
import dev.smjeon.wiki.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Entity
public class Article extends BaseEntity {

    @Embedded
    private Content content;

    @ManyToOne
    private User lastModifiedUser;

    public Article(Content content, User lastModifiedUser) {
        this.content = content;
        this.lastModifiedUser = lastModifiedUser;
    }
}
