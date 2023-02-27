package cz.backend;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import cz.Movie;
import cz.MovieRepository;

@SpringBootTest
@AutoConfigureMockMvc
class LoadMoviesTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void getMovieSuccess() throws Exception {

        Movie movieEntity = new Movie();
        movieEntity.setImage("myImage.jpg");
        movieEntity.setTitle("myMovieName");
        movieEntity.setAge("15+");
        movieEntity.setTags("myTags");
        movieEntity.setDescription("myDescription");
        movieEntity.setPrice(BigDecimal.valueOf(10));

        movieRepository.save(movieEntity);
        mockMvc.perform(MockMvcRequestBuilders.get("/allMovies/1")
        .contentType(MediaType.APPLICATION_JSON))

        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
        .andExpect(MockMvcResultMatchers.jsonPath("$.image", Is.is(movieEntity.getImage())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.title", Is.is(movieEntity.getTitle())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.age", Is.is(movieEntity.getAge())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Is.is(movieEntity.getTags())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.description", Is.is(movieEntity.getDescription())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price", Is.is(10.00)))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
