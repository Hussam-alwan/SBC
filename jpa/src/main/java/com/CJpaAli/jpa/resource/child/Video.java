package com.CJpaAli.jpa.resource.child;

import com.CJpaAli.jpa.resource.model.Resource;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@PrimaryKeyJoinColumn(name = "VIDEO_ID")//work with joined strategy
//@DiscriminatorValue("V")

public class Video extends Resource {
    private int length ;
}
