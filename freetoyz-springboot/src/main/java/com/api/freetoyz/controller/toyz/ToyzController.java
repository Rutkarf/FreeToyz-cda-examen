package com.api.freetoyz.controller.toyz;

import com.api.freetoyz.controller.dto.toyz.ToyzFileDTO;
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
import java.util.List;

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
    public ArrayList<ToyzGetDTO> findAll(){

       ArrayList<ToyzGetDTO> toyzDTO = new ArrayList<>();

       ArrayList<ToyzServiceModel>  toyzServiceModels = toyzService.findAll();

       toyzServiceModels.forEach((item)->toyzDTO.add(new ToyzGetDTO(item.getId(), item.getName(), item.getCategories(), item.getDescription(), item.getCotation(), item.getQuantite(), item.getPicturePath())) );

       return toyzDTO;
    }

    @GetMapping("/{id}")  //findById
    public ResponseEntity<ToyzGetDTO> findById(@PathVariable int id){
        try{
            ToyzServiceModel toyzServiceModel = toyzService.findById(id);
            return new ResponseEntity<>(new ToyzGetDTO ( toyzServiceModel.getId(), toyzServiceModel.getName(), toyzServiceModel.getCategories(), toyzServiceModel.getDescription(), toyzServiceModel.getCotation(), toyzServiceModel.getQuantite(), toyzServiceModel.getPicturePath()), HttpStatus.OK) ;

        }catch(ToyzNotFoundException ex){

            System.out.println(ex.getReason());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getReason() );

        }
    }

    @GetMapping("/last")  //findById
    public ResponseEntity<ToyzFileDTO> findByIdLast(){
        try{
            ToyzServiceModel toyzServiceModel = toyzService.findByLast();
            return new ResponseEntity<>(new ToyzFileDTO( toyzServiceModel.getId(), toyzServiceModel.getName(), toyzServiceModel.getCategories(), toyzServiceModel.getDescription(), toyzServiceModel.getCotation(), toyzServiceModel.getQuantite(), toyzServiceModel.getPicture()), HttpStatus.OK) ;

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




    @PostMapping("/submit")
    public ResponseEntity<?> submitToy(@RequestBody ToyzService toyzservice) {
        // Traitement de la soumission du jouet ici
        // Assure-toi de bien retourner une ResponseEntity appropriée
        return ResponseEntity.ok("Toy soumis avec succès !");
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

        @GetMapping("/category/{category}")
        public List<ToyzGetDTO> getToyByCategorie(@PathVariable String category) {
            List<ToyzServiceModel> toyzServiceModels = toyzService.findByCategory(category);

            List<ToyzGetDTO> toyzDTOList = new ArrayList<>();
            toyzServiceModels.forEach((item) -> {
                toyzDTOList.add(new ToyzGetDTO(
                        item.getId(),
                        item.getName(),
                        item.getCategories(),
                        item.getDescription(),
                        item.getCotation(),
                        item.getQuantite(),
                        item.getPicturePath()
                ));
            });

            return toyzDTOList;
        }
    }

