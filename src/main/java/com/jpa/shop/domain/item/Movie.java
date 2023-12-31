package com.jpa.shop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("M")
public class Movie extends Item {

    private String director;
    private String actor;

}
