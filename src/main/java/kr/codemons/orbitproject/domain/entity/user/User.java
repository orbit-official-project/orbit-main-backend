package kr.codemons.orbitproject.domain.entity.user;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToOne
    @JoinColumn(name = "AVATAR_ID")
    private Avatar avatar;
}
