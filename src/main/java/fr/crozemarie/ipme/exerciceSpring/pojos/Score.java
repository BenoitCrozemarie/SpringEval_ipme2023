package fr.crozemarie.ipme.exerciceSpring.pojos;

import javax.persistence.*;
@Entity
public class Score implements IdentifiablePojo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int scoreFinalEquipeA = -1;
    private int scoreFinalEquipeB = -1;

    public Score() {
    }

    public int getScoreFinalEquipeA() {
        return scoreFinalEquipeA;
    }

    public int getScoreFinalEquipeB() {
        return scoreFinalEquipeB;
    }

    public void setScoreFinalEquipeA(int scoreFinalEquipeA) {
        this.scoreFinalEquipeA = scoreFinalEquipeA;
    }

    public void setScoreFinalEquipeB(int scoreFinalEquipeB) {
        this.scoreFinalEquipeB = scoreFinalEquipeB;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", scoreFinalEquipeA=" + scoreFinalEquipeA +
                ", scoreFinalEquipeB=" + scoreFinalEquipeB +
                '}';
    }
}
