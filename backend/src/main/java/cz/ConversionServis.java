package cz;

public class ConversionServis {

    // Přemapování movie na movieDTO
    public static MovieDTO toMovieDTO (Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setImage(movie.getImage());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setAge(movie.getAge());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setTags(movie.getTags());
        movieDTO.setPrice(movie.getPrice());
        return movieDTO;
    }
    
    // Přemapování z movieDTO na entitu movieEntity:
    public static Movie toMovie (MovieDTO movieDTO) {
        Movie movieEntity = new Movie();
        movieEntity.setId(movieDTO.getId());
        movieEntity.setImage(movieDTO.getImage());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setAge(movieDTO.getAge());
        movieEntity.setDescription(movieDTO.getDescription());
        movieEntity.setTags(movieDTO.getTags());
        movieEntity.setPrice(movieDTO.getPrice());
        return movieEntity;
    }

}
