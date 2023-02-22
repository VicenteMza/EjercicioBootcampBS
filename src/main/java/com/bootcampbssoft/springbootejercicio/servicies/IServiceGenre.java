package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Genre;

import java.util.List;

public interface IServiceGenre {
    public Genre createGenre(Genre genre);
    public List<Genre> genreList();
    public Genre updateGenreById(int id, Genre genre);
}
