package fr.crozemarie.ipme.exerciceSpring.pojos;

import javax.persistence.*;

@Entity
public class Equipe implements IdentifiablePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;


    public Equipe() {
    }
    public Equipe(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
