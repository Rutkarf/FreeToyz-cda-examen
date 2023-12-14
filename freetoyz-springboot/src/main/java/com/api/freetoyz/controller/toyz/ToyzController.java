package com.api.freetoyz.controller.toyz;

import com.api.freetoyz.controller.dto.toyz.ToyzGetDTO;
import com.api.freetoyz.exception.ToyzNotFoundException;
import com.api.freetoyz.services.toyz.ToyzService;
import com.api.freetoyz.services.model.ToyzServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
@CrossOrigin
@RestController // donnees json ou xml
@RequestMapping("freetoyz/toys")
public class ToyzController {

    @Autowired
    ToyzService toyzService;

    @PostMapping        //insert
    @PreAuthorize("hasAuthority('ADMIN')")
    public boolean add( @RequestParam("name") String name,
                        @RequestParam("categories") String categories,
                        @RequestParam("description") String description,
                        @RequestParam("cotation") String cotation,
                        @RequestParam("quantite") String quantite,
                        @RequestParam("picture")  MultipartFile picture
                                       )
    {
        if(!picture.isEmpty()) {
            if (toyzService.uploadPicture(picture)) {
                return toyzService.add(new ToyzServiceModel(name, categories, description, cotation, quantite, picture));
            }
            ;
        }
    return false;
    }

    @GetMapping             //getAll
    public ArrayList<ToyzGetDTO> findAll(ArrayList<ToyzGetDTO> ToyzGetDTO){

       ArrayList<ToyzServiceModel> ToyzDTO = new ArrayList<>();

       ArrayList<ToyzServiceModel>  toyzServiceModels = toyzService.findAll();

       toyzServiceModels.forEach((item)->ToyzDTO.add(new ToyzServiceModel(item.getId().get(), item.getName(), item.getCategories(), item.getDescription(), item.getCotation(), item.getQuantite(), item.getPicture())) );

       return ToyzGetDTO;
    }

    @GetMapping("/{id}")  //findById
    public ResponseEntity<ToyzGetDTO> findById(@PathVariable Long id){
        try{
            ToyzServiceModel toyzServiceModel = toyzService.findById(id);
            return new ResponseEntity<>(new ToyzGetDTO ( toyzServiceModel.getId().get(), toyzServiceModel.getName(), toyzServiceModel.getCategories(), toyzServiceModel.getDescription(), toyzServiceModel.getCotation(), toyzServiceModel.getQuantite(), toyzServiceModel.getPicture()), HttpStatus.OK) ;

        }catch(ToyzNotFoundException ex){

            System.out.println(ex.getReason());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getReason() );

        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestParam String name){
        System.out.println(id + " " + name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
          boolean isDelete =true;
        if(isDelete ) {
            return new ResponseEntity<>("le toyz id : " + id + " a été supprimé", HttpStatus.OK);
        }else{
            //  throw new NotFoundException(id);
            return new ResponseEntity<>("le toyz id : " + id + " n'a pas été trouvé", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public String deleteAll(){
        return toyzService.deleteAll();
    }

}