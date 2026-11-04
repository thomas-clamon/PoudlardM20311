package com.example.sortilegem2test.controller;

import com.example.sortilegem2test.dto.SortilegeDto;
import com.example.sortilegem2test.enumation.TypeSort;
import com.example.sortilegem2test.services.SorcierService;
import com.example.sortilegem2test.services.SortilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Sortilege")
public class SortilegeController {

    @Autowired
    SorcierService service;

    @Autowired
    SortilegeService sortilegeService;

    @PostMapping("create")
    public ResponseEntity ajouter (@RequestBody SortilegeDto body){
        if (body.getNom().length() > 60)
            return new ResponseEntity("Nom trop long", HttpStatusCode.valueOf(400));

        // test du type
        try {
        TypeSort.valueOf(body.getType_sort());
        } catch (IllegalArgumentException exp){
           return new ResponseEntity("type incorrect", HttpStatusCode.valueOf(400));
        }

        if (!service.exist(body.getId_sorcier())){
           return new ResponseEntity("Sorcier existe pas", HttpStatusCode.valueOf(400));
        }

        sortilegeService.ajouter(sortilegeService.toEntity(body));

        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }
}
