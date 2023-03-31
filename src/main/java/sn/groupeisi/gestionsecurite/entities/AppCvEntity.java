package sn.groupeisi.gestionsecurite.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "appcv")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppCvEntity extends BaseEntity{
    @Column(name = "nom", length = 200)
    private String nom;
    @Column(name = "prenom", length = 200)
    private String prenom;
    @Column(name = "age", length = 200)
    private int age;
    @Column(name = "adresse", length = 200)
    private String adresse;
    @Column (name = "email", length = 200, unique = true)
    private String email;

    @Column(name = "telephone", length = 200)
    private String telephone;
    @Column(name = "specialite", length = 200)
    private String specialite;

    @Column(name = "niveauEtude", length = 200)
    private String niveauEtude;
    @Column(name = "experienceProfessionnelle", length = 200)
    private int experienceProfessionnelle;


}
