package music_task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import app.App;
import app.dto.AlbumDTO;
import app.dto.CompositionDTO;
import app.dto.ExecutorDTO;
import app.dto.MusicGroupDTO;
import app.entity.Executor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
@AutoConfigureMockMvc
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void controllerResponse() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/" + "get/Hello", String.class))
                .startsWith("Hello");
    }

    @Test
    public void albumControllerResponse () throws Exception {
        MvcResult result = mockMvc.perform(get("http://localhost:" + port +"/album/1")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        String json = result.getResponse().getContentAsString();

        AlbumDTO adto = objectMapper.readValue(json, AlbumDTO.class);

        Assert.assertTrue(adto !=null && adto.getCompositionIds() != null && adto.getReleazeDate() != null
                && adto.getTitle() != null &&  adto.getId() != null && adto.getMusicGroupId()!=null);

    }

    @Test
    public void compositionControllerResponse() throws Exception {
        MvcResult result = mockMvc.perform(get("http://localhost:" + port + "/composition/3")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        String json = result.getResponse().getContentAsString();

        CompositionDTO cdto = objectMapper.readValue(json, CompositionDTO.class);
        Assert.assertTrue(cdto != null && cdto.getDuration() != null && cdto.getName() != null
                && cdto.getId() != null && cdto.getCompositionAlbum() != null);
    }

    @Test
    public void executorControllerResponse() throws Exception {
        MvcResult result = mockMvc.perform(get("http://localhost:" + port + "/executor/3").
                contentType(MediaType.APPLICATION_JSON)).andReturn();

        String json = result.getResponse().getContentAsString();
        ExecutorDTO edto = objectMapper.readValue(json, ExecutorDTO.class);

        Assert.assertTrue(edto != null && edto.getMusicGroupId() != null && edto.getName() !=null
                && edto.getPatronymic() != null && edto.getRole() != null && edto.getSurname() != null
                && edto.getId() != null);
    }

    @Test
    public void musicGroupController() throws Exception {
        MvcResult result = mockMvc.perform(get("http://localhost:" + port + "/musicgroup/1")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        String json = result.getResponse().getContentAsString();

        MusicGroupDTO mgtdo = objectMapper.readValue(json, MusicGroupDTO.class);

        Assert.assertTrue(mgtdo!=null && mgtdo.getAlbumIds()!=null && mgtdo.getExecutorIds() != null
                && mgtdo.getCountry() != null  && mgtdo.getGenre()!= null && mgtdo.getName() != null
                && mgtdo.getId() != null);
    }


}
