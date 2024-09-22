package com.halmira.rest;

import com.halmira.model.Company;
import com.halmira.model.Review;
import com.halmira.service.CompanyService;
import com.halmira.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Company>> getCompaniesByLocation(@RequestParam String location) {
        return ResponseEntity.ok(companyService.getCompaniesByLocation(location));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String name) {
        return ResponseEntity.ok(companyService.getCompanyByName(name));
    }
}