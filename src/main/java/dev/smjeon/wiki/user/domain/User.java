package dev.smjeon.wiki.user.domain;

import dev.smjeon.wiki.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class User extends BaseEntity {
    @Embedded
    private UserName userName;
}
