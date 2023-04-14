package cz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

// Anotace nemají za běhu žádný účinek!
// Návrhový architektonický vzor u kterého musíme používat Controler, Servis a Repository beany.
// Odděleně a komunikovat spolu = Vícevrstvá architektura  

@Service    // V MovieController mi vyskakovala chyba, že to není žádná beana
            // Informuje rámec Spring Dependecy Injection, že jí lze použít na Dependency Injection
            // @Autowired informuje DI, že by mělo být pole vyplněno pomocí DI.
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Page<Movie> findAll (Integer pageNumber, Integer pageSize, String sortBy) {
        return movieRepository.findAll(PageRequest.of(pageNumber, pageSize, Direction.ASC, sortBy));
    }

    public Movie findById(Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Film %s nebyl nalezen.", id)));

    }

    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Integer id, Movie movie) {
        // Zkontroluje, jestli daný objekt už není v repository:
        findById(id);
        movie.setId(id);

        return movieRepository.save(movie);
    }
    
}
