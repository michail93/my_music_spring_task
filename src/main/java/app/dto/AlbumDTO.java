package app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlbumDTO {
    private Integer id;

    @NotBlank
    private String title;

    private List<Integer> compositionIds = new ArrayList<>();

    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date releazeDate;


    private Integer musicGroupId;
}
