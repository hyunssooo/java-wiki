package dev.smjeon.wiki.user.domain;

import dev.smjeon.wiki.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class User extends BaseEntity {
    @Embedded
    private UserName userName;

    @Enumerated
    private LoginType loginType;

    private String nickName;

    @Embedded
    private Email email;
}
