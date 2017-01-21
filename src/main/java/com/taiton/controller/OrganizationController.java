package com.taiton.controller;

import com.taiton.entity.OrganizationEntity;
import com.taiton.service.OrganizationService;
import com.taiton.service.ServiceService;
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

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/registration")
    public String getOrganizationRegistrationPage(){
        return "organization/registration";
    }


    // ???????????????????????????????????????
    @PostMapping("/addOrganization")
    public @ResponseBody ResponseEntity<String> addOrganization(@RequestBody OrganizationEntity organization){
        try {
            OrganizationEntity org = organizationService.findByName(organization.getName());
            if (org == null) {
                organizationService.save(organization);
                return new ResponseEntity<>(" Организацию добавлена.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(" Данная организация уже существует.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>(" Некорретные данные.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteOrganization/{id}")
    public @ResponseBody ResponseEntity<String> deleteOrganization(@PathVariable("id") int id) {
        try {
            OrganizationEntity organization = organizationService.find(id);

            if (organization == null) {
                return new ResponseEntity<>(" Данной организации не существует.", HttpStatus.BAD_REQUEST);
            } else {
                organizationService.delete(id);
                return new ResponseEntity<>(" Организацию успешно удалена (счета и сервисы остались)", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(" Некорректные данные", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/organizationList.json")
    public @ResponseBody
    List<OrganizationEntity> fetchListOrganization(){
        return organizationService.findAll();
    }

}
