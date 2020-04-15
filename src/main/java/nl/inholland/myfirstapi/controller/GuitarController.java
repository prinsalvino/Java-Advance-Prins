package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@Controller
@RequestMapping(value = "guitars")
public class GuitarController {

    @Autowired
    private GuitarService guitarService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guitar>> getAllGuitars(){
        return ResponseEntity.status(200).body(guitarService.getGuitars());
    }
}
