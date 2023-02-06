package fr.crozemarie.ipme.exerciceSpring.pojos;

import javax.persistence.*;

@Entity
public class Pronostic  implements IdentifiablePojo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Match match;
    @ManyToOne
    private User user;
    @ManyToOne
    private Equipe equipePari;

    public Equipe getEquipePari() {
        return equipePari;
    }

    public void setEquipePari(Equipe equipePari) {
        this.equipePari = equipePari;
    }

    public Pronostic() {

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
