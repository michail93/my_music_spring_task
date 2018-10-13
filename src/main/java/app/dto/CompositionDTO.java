package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Getter
@Setter
public class CompositionDTO {

    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    private Long duration;

    @NotNull
    private Integer compositionAlbum;
}
