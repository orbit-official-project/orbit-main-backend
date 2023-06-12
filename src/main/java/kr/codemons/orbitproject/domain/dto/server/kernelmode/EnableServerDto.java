package kr.codemons.orbitproject.domain.dto.server.kernelmode;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnableServerDto {

    @NotBlank
    private String name;

    @NotBlank
    private String secret;

    @NotBlank
    private String ip;

    private Integer port;
    private boolean ssl;

}
