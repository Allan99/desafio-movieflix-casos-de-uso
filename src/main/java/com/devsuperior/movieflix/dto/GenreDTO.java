package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;

public class GenreDTO {

    private Long id;
    private String name;
    
    public GenreDTO() {
    	
    }
    
    public GenreDTO(Genre g) {
    	id = g.getId();
    	name = g.getName();
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
