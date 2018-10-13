package app.dto;

import app.entity.Role;
import app.entity.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ExecutorDTO {
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String patronymic;

    @NotNull
    private Sex sex;

    @NotNull
    private Role role;

    @NotNull
    private Integer musicGroupId;

}
