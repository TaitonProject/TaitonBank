package com.taiton.controller;

import com.taiton.entity.OrganizationEntity;
import com.taiton.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Taiton on 1/16/2017.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/registration")
    public String getOrganizationRegistrationPage(){
        return "organization/registration";
    }

/*    @PostMapping("/addOrganization")
    public @ResponseBody ResponseEntity<Void> addOrganization(@RequestBody Organization organization){
        if(organizationService.findByName(organization.getName()) == null) {
            OrganizationEntity organizationEntity = new OrganizationEntity();
            organizationEntity.setName(organization.getName());
            organizationService.save(organizationEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }*/

    @PostMapping("/addOrganization")
    public @ResponseBody ResponseEntity<Void> addOrganization(@RequestBody OrganizationEntity organization){
        if(organizationService.findByName(organization.getName()) == null) {
            organizationService.save(organization);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteOrganization/{id}")
    public @ResponseBody ResponseEntity<Void> deleteOrganization(@PathVariable("id") int id) {
        if (organizationService.find(id) != null) {
            organizationService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/organizationList.json")
    public @ResponseBody List<OrganizationEntity> fetchListOrganization(){
        return organizationService.findAll();
    }

}
