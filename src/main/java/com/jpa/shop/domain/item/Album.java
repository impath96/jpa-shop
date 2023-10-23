package com.jpa.shop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artiest;
    private String etc;

}
