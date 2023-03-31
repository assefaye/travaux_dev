package sn.groupeisi.gestionsecurite.services;

import sn.groupeisi.gestionsecurite.dtos.AppCv;


public interface IAppCvService extends IBaseService<AppCv> {
    AppCv loadCvByEmail(String email);
    public AppCv findById(int id);
    public void delete(int id);
    public AppCv update(int id, AppCv appCv);
    //public AppCv put(int id, AppCv appCv);
}
