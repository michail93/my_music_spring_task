package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy ="compositionAlbum")
    private List<Composition> compositionList = new ArrayList<Composition>();

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name="musicGroup_fk")
    private MusicGroup albumMusicGroup;

}
