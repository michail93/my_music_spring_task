package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MusicGroupDTO {
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String country;

    @NotBlank
    private String genre;

    private List<Integer> executorIds = new ArrayList<>();

    private List<Integer> albumIds = new ArrayList<>();
}
