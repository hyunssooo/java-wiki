package dev.smjeon.wiki.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "name")
@Embeddable
public class UserName {
    @Column(nullable = false, length = 25)
    private String name;

    public UserName(String name) {
        this.name = name;
    }
}
