// ToyService.java
package com.api.freetoyz.services.toyz;

import com.api.freetoyz.repository.toyz.ToyzRepository;
import com.api.freetoyz.repository.toyz.ToyzRepositoryModel;
import com.api.freetoyz.services.model.ToyzServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class ToyzService {

@Autowired
ToyzRepository toyzRepository;
public boolean add(ToyzServiceModel toyzServiceModel){
    // Créer une nouvelle date
    Date currentDate = new Date();

    // Convertir la date en long
    long timestamp = currentDate.getTime();

    // Créer un objet SimpleDateFormat pour formater la date
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    // Convertir le timestamp en format de chaîne de caractères
    String dateString = sdf.format(currentDate);

String newpicture = toyzServiceModel.getName()+dateString;



    ToyzRepositoryModel toyzRepositoryModel = new ToyzRepositoryModel( toyzServiceModel.getName(), toyzServiceModel.getCategories(),  toyzServiceModel.getDescription(), toyzServiceModel.getCotation(), toyzServiceModel.getQuantite(),newpicture);
    ToyzRepositoryModel toyzRepositoryModelReturn = toyzRepository.save( toyzRepositoryModel);

    return toyzRepositoryModelReturn != null ;
}

public ArrayList<ToyzServiceModel> findAll() {
//    List<ToyzRepositoryModel> repositoryModels = toyzRepository.findAll();
//    List<ToyzServiceModel> toyzServiceModels1 = repositoryModels.stream().map((value) -> MapStructMapper.INSTANCE.toyzsRepositoryToToyzsService(value)).toList();

    ArrayList<ToyzServiceModel> toyzServiceModels = new ArrayList<>();
    ArrayList<ToyzRepositoryModel> toyzRepositoryModels = toyzRepository.findAll();

    toyzRepositoryModels.forEach( (item)->toyzServiceModels.add(new ToyzServiceModel(item.getName(),
                                                                                     item.getCategories(),
                                                                                     item.getDescription(),
                                                                                     item.getCotation(),
                                                                                     item.getQuantite(),
                                                                                     null)));

    return toyzServiceModels;
}



public boolean update (ToyzServiceModel toyzServiceModel) {

    if(!toyzRepository.findById(toyzServiceModel.getId() ).isEmpty()  )
    {
        return false;

    } else {
        // Créer une nouvelle date
        Date currentDate = new Date();

        // Convertir la date en long
        long timestamp = currentDate.getTime();

        // Créer un objet SimpleDateFormat pour formater la date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Convertir le timestamp en format de chaîne de caractères
        String dateString = sdf.format(currentDate);

        String newpicture = toyzServiceModel.getName()+dateString;
        ToyzRepositoryModel toyzRepositoryModel = new ToyzRepositoryModel(toyzServiceModel.getId(),toyzServiceModel.getName(),toyzServiceModel.getCategories(),toyzServiceModel.getDescription(),toyzServiceModel.getCotation(), toyzServiceModel.getQuantite(), newpicture);

        ToyzRepositoryModel toyzRepositoryModelReturned = toyzRepository.save( toyzRepositoryModel);

        return toyzRepositoryModelReturned != null;

    }
}

public void delete(int id) { toyzRepository.deleteById(id); }

    public String deleteAll() {
    toyzRepository.deleteAll();
    return "La bdd a été effacée.";
    }

    public String uploadImage( MultipartFile file){
        try {
            // Spécifiez le chemin où vous souhaitez enregistrer l'image téléchargée.
            String uploadDirectory = "chemin/vers/votre/dossier";

            // Obtenez le nom du fichier téléchargé.
            String fileName = file.getOriginalFilename();

            // Créez un objet File pour enregistrer l'image dans le dossier spécifié.
            File targetFile = new File(uploadDirectory, fileName);

            // Vérifiez si le dossier cible existe. Sinon, créez-le.
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }

            // Enregistrez l'image dans le dossier cible.
            file.transferTo(targetFile);
            return "L'image a été téléchargée avec succès.";

        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors du téléchargement de l'image.";
        }
    }
    public boolean uploadPicture(MultipartFile file) {
        System.out.println(file);
        try {
            String uploadDirectory = "/public/upload"; // dossier de chargement
            String filename = file.getOriginalFilename(); // nom fichier chargé
            Path path = Paths.get(".", uploadDirectory).toAbsolutePath(); // absolute path
            File targetFile = new File(path.toString(), filename);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public ToyzServiceModel findById(int id) {
    var ty = toyzRepository.findById(id).get();
        return new ToyzServiceModel(ty.getId(), ty.getName(),ty.getCategories(),ty.getDescription(),ty.getCotation(),ty.getQuantite(), ty.getPicture());
    }

    public ToyzServiceModel findByLast() {
    var ty = toyzRepository.findAll().get(0);
        return new ToyzServiceModel(ty.getId(), ty.getName(),ty.getCategories(),ty.getDescription(),ty.getCotation(),ty.getQuantite(), ty.getPicture());
    }


    public List<ToyzServiceModel> findByCategory(String category) {
        return toyzRepository.findByCategories(category);
    }






}
