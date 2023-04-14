package cz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity // Data budu ukládat a aby přetrvávala. Používána frameworkem Hibernate
@Data
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Způsob jakým se má generovat ID (postupně - identity)
    private Integer id;
    private String image;
    private String title;
    private String age;
    private String tags;
    private String description;
    private Number price;

    public Movie (){};      // Nefunguje správně AllArgsConstructor !!! Nemusel bych to tu mít.
}

