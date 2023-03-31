package sn.groupeisi.gestionsecurite.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppCv extends Base{
    private String nom;
    private String prenom;
    private int age;
    private String adresse;

    private String email;
    private String telephone;
    private String specialite;
    private String niveauEtude;
    private int experienceProfessionnelle;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    //List<AppRoles> roles = new ArrayList<AppRoles>();
}
