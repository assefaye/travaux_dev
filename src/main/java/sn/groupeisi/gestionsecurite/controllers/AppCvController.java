package sn.groupeisi.gestionsecurite.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.gestionsecurite.dtos.AppCv;
import sn.groupeisi.gestionsecurite.services.IAppCvService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "cv")
@AllArgsConstructor

public class AppCvController {
    private IAppCvService iAppCvService;

    @PostMapping(path = "/save")
    public AppCv save(@Valid @RequestBody AppCv appCv){
        return iAppCvService.save(appCv);
    }

    @GetMapping
    public List<AppCv> findAll() {
        return iAppCvService.findAll();
    }

    @GetMapping(path = "/{id}")
    public AppCv getAppCv(@PathVariable("id") int id) {
        return iAppCvService.findById(id);
    }

    @PutMapping(path = "/{id}")
    public AppCv updateAppCv(@PathVariable("id") int id, @Valid @RequestBody AppCv appCv) {
        return iAppCvService.update(id, appCv);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAppCv(@PathVariable("id") int id) {
        iAppCvService.delete(id);
    }Mapping

}
