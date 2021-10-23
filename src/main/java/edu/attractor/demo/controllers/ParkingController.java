package edu.attractor.demo.controllers;

import edu.attractor.demo.entities.ActionParking;
import edu.attractor.demo.entities.Place;
import edu.attractor.demo.entities.State;
import edu.attractor.demo.services.ActionService;
import edu.attractor.demo.services.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping("/parking")
@AllArgsConstructor
@Data
public class ParkingController {
    private final PlaceService placeService;
    private final ActionService actionService;


    @GetMapping()
    public String parking(Model model) {
         List<Place> list = placeService.getAll();
         Integer free = 0;
        Integer busy = 0;
         for (Place place:list
              ) {
             if (place.getState()== State.BUSY) busy+=1;
            if(place.getState()== State.FREE) free+=1;
         }
         model.addAttribute("free", free);
         model.addAttribute("busy", busy);
         model.addAttribute("places", list);
         return "main/main";
     }

     @GetMapping("/parkingIn")
    public String getFormOfParking (){
        return null;
     }

     @PostMapping("/parkingIn")
    public String makeParking(@RequestParam MultipartFile multipartFile, @RequestParam Integer action, @RequestParam Integer numberOfCar,@RequestParam Long id){
        if(action==1){
            actionService.addActionIN(numberOfCar,multipartFile);
        }
        if (action==0){
            actionService.addActionOut(numberOfCar,multipartFile,id);
        }
        return"redirect:/parking";
     }

     @GetMapping("/displayParkingSpace/{id}")
     public String displayDetails(@PathVariable Long id,Model model){
         ActionParking action= actionService.getById(id);
         model.addAttribute("space",action);
         return "spacePage";
     }

}
