package sn.groupeisi.gestionsecurite.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.gestionsecurite.dtos.AppCv;
import sn.groupeisi.gestionsecurite.entities.AppCvEntity;
@Mapper
public interface AppCvMapper {
    AppCv toAppCv(AppCvEntity appUserEntity); //  Transformation d'un DAO vers un DTO
    AppCvEntity fromAppCv(AppCv appCv);  //  Transformation d'un DTO vers un DAO
}
