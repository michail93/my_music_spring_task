package music_task;

import static org.assertj.core.api.Assertions.assertThat;

import app.App;
import app.controller.AlbumController;
import app.controller.CompositionController;
import app.controller.ExecutorController;
import app.controller.MusicGroupController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SmokeTest {

    @Autowired
    private CompositionController compositionController;
    @Autowired
    private AlbumController albumController;
    @Autowired
    private ExecutorController executorController;
    @Autowired
    private MusicGroupController musicGroupController;

    @Test
    public void contextLoads() throws Exception{
            assertThat(compositionController).isNotNull();
            assertThat(albumController).isNotNull();
            assertThat(executorController).isNotNull();
            assertThat(musicGroupController).isNotNull();
    }
}
