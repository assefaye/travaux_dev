package sn.groupeisi.gestionsecurite.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.groupeisi.gestionsecurite.dtos.AppCv;
import sn.groupeisi.gestionsecurite.entities.AppCvEntity;
import sn.groupeisi.gestionsecurite.exception.EntityNotFoundException;
import sn.groupeisi.gestionsecurite.exception.RequestException;
import sn.groupeisi.gestionsecurite.mapping.AppCvMapper;
import sn.groupeisi.gestionsecurite.repositories.AppCvRepository;
import sn.groupeisi.gestionsecurite.services.IAppCvService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AppCvServiceImpl implements IAppCvService {
    private AppCvRepository appCvRepository;
    private AppCvMapper appCvMapper;
    private MessageSource messageSource;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppCv loadCvByEmail(String email) {
        return appCvMapper.toAppCv(appCvRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("cv.notfound", new Object[]{email},
                        Locale.getDefault()))));
    }
        @Override

        public AppCv findById(int id) {
            return appCvMapper.toAppCv(appCvRepository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                            Locale.getDefault()))));
        }
    @Override

        public void delete(int id) {
            try {
                appCvRepository.deleteById(id);
            } catch (Exception e) {
                throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                        Locale.getDefault()),
                        HttpStatus.CONFLICT);
            }
        }
    @Override

    public AppCv update(int id, AppCv appCv) {
            return appCvRepository.findById(id)
                    .map(entity -> {
                        appCv.setId(id);
                        return appCvMapper.toAppCv(
                                appCvRepository.save(appCvMapper.fromAppCv(appCv)));
                    }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                            Locale.getDefault())));
        }
    @Override
    public AppCv save(AppCv appCv) {
            appCvRepository.findByEmail(appCv.getEmail())
                    .ifPresent(entity -> {
                        throw new RequestException(messageSource.getMessage("user.exists", new Object[]{appCv.getEmail()},
                                Locale.getDefault()), HttpStatus.CONFLICT);
                    });
            String password = appCv.getPassword();
            appCv.setPassword(passwordEncoder.encode(password));
            AppCvEntity re = appCvMapper.fromAppCv(appCv);
            re = appCvRepository.save(re);
            return  appCvMapper.toAppCv(re);
        }

    @Override
    public void delete(AppCv appCv) {

    }

    @Override
    public void update(AppCv appCv) {

    }

    @Override
        public List<AppCv> findAll() {
            return StreamSupport.stream(appCvRepository.findAll().spliterator(), false)
                    .map(appCvMapper::toAppCv)
                    .collect(Collectors.toList());
        }


}
