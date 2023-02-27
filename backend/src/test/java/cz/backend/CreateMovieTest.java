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

import com.fasterxml.jackson.databind.ObjectMapper;

import cz.MovieDTO;

@SpringBootTest
@AutoConfigureMockMvc // Slouží pro nakonfigurování beana MockMVC, která slouží pro testování
                      // controllerů(end pointů). Umožní nám provolávat rozhraní pomocí adres a
                      // následně nám umožňuje dělat excpecty nad výsledkem.
class CreateMovieTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createMovieSuccess() throws Exception {

        /*
         * Test má 3 části:
         * a) Přípravná
         * b) Exekuce - spuštění testu
         * c) Expect - vyhodnocení
         */

        // a) Přípravná
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setImage("myImage.jpg");
        movieDTO.setTitle("myMovieName");
        movieDTO.setAge("15+");
        movieDTO.setTags("myTags");
        movieDTO.setDescription("myDescription");
        movieDTO.setPrice(BigDecimal.valueOf(10));

        /*
         * Třída objectMapper mi slouží pro převod, nebo manipulaci s entitami, Stringem
         * a dokáže jejich vzájemný převod
         * Převod naplněného movie do stringu:
         */
        String testData = objectMapper.writeValueAsString(movieDTO);

        /*
         * b) Exekuce - Provedení:
         * Zavoláním metody post na endpointu /allMovies, .content(testovací data),
         */
        mockMvc.perform(MockMvcRequestBuilders.post("/allMovies")
                .content(testData)
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON))

                // c) Expect - vyhodnocení:

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.image", Is.is(movieDTO.getImage())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Is.is(movieDTO.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age", Is.is(movieDTO.getAge())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Is.is(movieDTO.getTags())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Is.is(movieDTO.getDescription())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Is.is(10)));
    }

    @Test
    void createMovieFailedInvalidTitle() throws Exception {

        // a) Přípravná:
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setImage(null);
        movieDTO.setTitle(null);
        movieDTO.setAge("15+");
        movieDTO.setTags("myTags");
        movieDTO.setDescription("myDescription");
        movieDTO.setPrice(BigDecimal.valueOf(10));
        String testData = objectMapper.writeValueAsString(movieDTO);

        // b) Exekuce:
        mockMvc.perform(MockMvcRequestBuilders.post("/allMovies").content(testData).contentType(MediaType.APPLICATION_JSON))

        // c) Except:

        .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}
