package casa.gestionespese.controller;

import casa.gestionespese.dto.request.ProdottoDtoRequest;
import casa.gestionespese.dto.request.RigaScontrinoDtoRequest;
import casa.gestionespese.dto.request.ScontrinoDtoRequest;
import casa.gestionespese.dto.response.ProdottoDtoResponse;
import casa.gestionespese.dto.response.RigaScontrinoDtoResponse;
import casa.gestionespese.dto.response.ScontrinoDtoResponse;
import casa.gestionespese.dto.response.ScontrinoEmessoDtoRespose;
import casa.gestionespese.facade.UtenteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/controllerUtente")
public class ControllerUtente {
    @Autowired
    UtenteFacade utenteFacade;

    @GetMapping("/addProdotto")
    public ResponseEntity<String>aggiungiProdotto(@RequestBody ProdottoDtoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(utenteFacade.aggiungiProdotto(request));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProdottoDtoResponse>> findAllProdotti(){
        return ResponseEntity.status(HttpStatus.OK).body(utenteFacade.findAllNotDeleted());
    }

    @PostMapping("/deleteByID")
    public ResponseEntity<String> deleteProductById(@RequestParam long id){
        return ResponseEntity.status(HttpStatus.OK).body(utenteFacade.deleteProdById(id));
    }

    @GetMapping("/aggiungiRiga")
    public ResponseEntity<RigaScontrinoDtoResponse> addRiga(@RequestBody RigaScontrinoDtoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(utenteFacade.addRiga(request));

    }@GetMapping("/creaScontrino")
    public ResponseEntity<ScontrinoDtoResponse> creaScontrino(@RequestBody ScontrinoDtoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(utenteFacade.addScontrino(request));
    }

    @GetMapping("/emettiScontrino")
    public ResponseEntity<ScontrinoEmessoDtoRespose> emettiScontrino(@RequestParam long idScontrino){
        return ResponseEntity.status(HttpStatus.OK).body(utenteFacade.emettiSconntrino(idScontrino));
    }

}
