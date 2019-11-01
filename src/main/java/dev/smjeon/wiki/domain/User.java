package dev.smjeon.wiki.domain;

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
