package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Genre;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositoryGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiceGenresImpl implements IServiceGenre {
    @Autowired
    private IRepositoryGenre iGenreRepository;
    @Override
    public Genre createGenre(Genre genre) {
        genre.setName(genre.getName().toUpperCase().trim());

        if (this.iGenreRepository.findByName(genre.getName()).isPresent()){
            return null;
        }
        return this.iGenreRepository.save(genre);
    }

    @Override
    public List<Genre> genreList() {

        return this.iGenreRepository.findAll();
    }

    @Override
    public Genre updateGenreById(int id, Genre genre) {
        Genre gen = null;
        genre.setName(genre.getName().toUpperCase().trim());

        if(nameExists(genre.getName()).isPresent()){
            throw new RuntimeException("Nombre :"+genre.getName()+" Genre existente");
        }

        try{
            //Si el ID no existe error: NoSuchElementException, devuelve un null
            Optional<Genre> idExiste = this.iGenreRepository.findById(id);

            gen = idExiste.get();

            gen.setName(genre.getName().toUpperCase().trim());

            gen = this.iGenreRepository.save(gen);

        }catch (NoSuchElementException e){
            System.out.println("Id: "+ id +", no exite\n" +e);
        }
        return gen;
    }

    private Optional<Genre> nameExists(String name){

        return this.iGenreRepository.findByName(name);
    }
}
