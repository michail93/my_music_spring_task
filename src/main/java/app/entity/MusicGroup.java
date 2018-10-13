package app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "music_group")
public class MusicGroup{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String country;

    private String genre;

    @OneToMany(mappedBy = "musicGroup")
    private Collection<Executor> executors = new ArrayList<Executor>();

    @OneToMany(mappedBy = "albumMusicGroup")
    private Collection<Album> albumList = new ArrayList<Album>();

}
