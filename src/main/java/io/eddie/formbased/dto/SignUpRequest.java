package io.eddie.formbased.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequest {

    private String username; // 4글자
    private String password; // 8글자
    private String email; // @

}
