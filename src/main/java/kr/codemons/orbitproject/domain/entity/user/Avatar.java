package kr.codemons.orbitproject.domain.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Avatar {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profile_image_url;
}
