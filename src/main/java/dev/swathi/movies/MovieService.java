package dev.swathi.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
     private MovieRespository movieRespository;
    public List<Movie> AllMovies(){
       return movieRespository.findAll();
    }
    public Optional<Movie> singleMovie(ObjectId id){
        return movieRespository.findById(id);
    }
    public Optional<Movie> getSingleMovieBydbId(String  imdbId){
        return movieRespository.findMovieByImdbId(imdbId);
    }
}
