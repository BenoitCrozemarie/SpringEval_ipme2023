package fr.crozemarie.ipme.exerciceSpring.pojos;

import javax.persistence.*;

@Entity
@Table(name = "Matchs")
public class Match implements IdentifiablePojo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    protected Equipe equipeA;
    @ManyToOne
    protected Equipe equipeB;
    @OneToOne(cascade = CascadeType.ALL)
    protected Score score;
    public Match(Equipe equipeA, Equipe equipeB, Score score) {
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.score = score;
    }

    public Match(Equipe equipeA, Equipe equipeB) {
        this.equipeA = equipeA;
        this.equipeB = equipeB;
    }
    public Match() {

    }

    public Equipe getEquipeA() {
        return equipeA;
    }

    public void setEquipeA(Equipe equipeA) {
        this.equipeA = equipeA;
    }

    public Equipe getEquipeB() {
        return equipeB;
    }

    public void setEquipeB(Equipe equipeB) {
        this.equipeB = equipeB;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }



    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", equipeA=" + equipeA +
                ", equipeB=" + equipeB +
                ", score=" + score +
                '}';
    }
}
