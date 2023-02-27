package cz;

import java.util.List;
import java.util.stream.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Vyřeší problém s CORS - Ochrana v prohlížeči (Backend musí povolit pomocí HTTP hlaviček čtení z response (jiného localhostu))
@RequestMapping("/allMovies")   // Můžeme si endpointy (allMovies) odstranit ze všech mapování.
@CrossOrigin
public class MovieController {
    
    // private final MovieRepository movieRepository;
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<MovieDTO> getAllMovies(
        @RequestParam(defaultValue = "0") Integer pageNumber, 
        @RequestParam(defaultValue = "8") Integer pageSize, 
        @RequestParam(defaultValue = "id") String sortBy) 

        {

        // Přemapování Movie na MovieDTO a vrací se collection:
        return movieService.findAll(pageNumber, pageSize, sortBy).stream().map(ConversionServis::toMovieDTO).collect(Collectors.toList());

        // Delší zápis bez referencování:
        // return movieService.findAll(pageNumber, pageSize).stream().map(movie -> {
        //     return ConversionServis.toMovieDTO(movie);
        // }).collect(Collectors.toList());
    }

    // PathVariable - definuje naše ID
    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Integer id) {
        Movie byId = movieService.findById(id);
        return ConversionServis.toMovieDTO(byId);
    }

    // @RequestBody - Aby Spring věděl, že má namapovat příchozí data na tento objekt.
    // @Valid - Hlídá anotace z MovieDTO, kde je definované omezení (constrains).
    @PostMapping()
    public MovieDTO creatMovie(@Valid @RequestBody MovieDTO movieDTO){

        Movie movie = ConversionServis.toMovie(movieDTO);
        Movie save = movieService.save(movie);

        return ConversionServis.toMovieDTO(save);
    }

    @PutMapping("/{id}")
    public MovieDTO updateMovie(@PathVariable Integer id, @RequestBody MovieDTO movieDTO){

        Movie movie = ConversionServis.toMovie(movieDTO);
        Movie save = movieService.update(id, movie);
        
        return ConversionServis.toMovieDTO(save);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteById(id);
    }

}
