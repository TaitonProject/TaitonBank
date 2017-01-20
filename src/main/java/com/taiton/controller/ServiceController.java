package com.taiton.controller;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.CategoryEntity;
import com.taiton.entity.OrganizationEntity;
import com.taiton.entity.ServiceEntity;
import com.taiton.entity.forJson.Service;
import com.taiton.service.AccountService;
import com.taiton.service.CategoryService;
import com.taiton.service.OrganizationService;
import com.taiton.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Taiton on 1/16/2017.
 */
@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/registration")
    public String getServiceRegistrationPage(){
        return "service/registration";
    }

    @PostMapping("/addService")
    public @ResponseBody ResponseEntity<Void> addService(@RequestBody Service service){

        // создание аккаунта
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountBalance(0);
        accountEntity.setAccountNumber(service.getAccount());

        // создание сервиса
        ServiceEntity serviceEntity = new ServiceEntity();
        //CategoryEntity cat = categoryService.findByCategoryName(service.getCategoryIdCategory().getCategoryName());
        serviceEntity.setCategoryIdCategory(service.getCategoryIdCategory());
        serviceEntity.setOrganizationId(organizationService.find(service.getOrganizationId()).getId());
        //serviceEntity.setAccountByAccountId(accountEntity);


        if(organizationService.find(serviceEntity.getOrganizationId()) != null &&
                accountService.findByAccountNumber(service.getAccount()) == null) {
            accountService.save(accountEntity);
            serviceEntity.setAccountId(accountService.findByAccountNumber(service.getAccount()).getId());
            serviceService.save(serviceEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteService/{id}")
    public @ResponseBody ResponseEntity<Void> deleteService(@PathVariable("id") int id) {
        // каскадное удаление сервиса (потом аккаунта, потом организациии)
        if (serviceService.find(id) != null) {
            accountService.delete(serviceService.find(id).getAccountId());
            organizationService.delete(serviceService.find(id).getOrganizationId());
            serviceService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/serviceList.json")
    public @ResponseBody
    List<ServiceEntity> fetchListService(){
        return serviceService.findAll();
    }

    @GetMapping("/accountList.json")
    public @ResponseBody
    List<AccountEntity> fetchListAccount(){
        return accountService.findAllOrganization();
    }

    @GetMapping("/organizationList.json")
    public @ResponseBody
    List<OrganizationEntity> fetchListOrganization(){
        return organizationService.findAll();
    }

    @GetMapping("/categoryList.json")
    public @ResponseBody
    List<CategoryEntity> fetchListCategory(){
        return categoryService.findAll();
    }

}
