package fr.crozemarie.ipme.exerciceSpring.pojos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groupe implements IdentifiablePojo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(length = 4)
    private List<Equipe> equipes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Match> matchs;

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }


    public Groupe() {

    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", equipes=" + equipes +
                ", matchs=" + matchs +
                '}';
    }
}
