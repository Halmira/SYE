package com.halmira.service;


import com.halmira.model.Company;
import com.halmira.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company getCompanyById(Long companyId)
    {
        return companyRepository.findById(companyId).orElse(null);
    }


    public Company getCompanyByName(String name)
    {
        return companyRepository.findByName(name);
    }

    public List<Company> getCompaniesByLocation(String location)
    {
        return companyRepository.findAll()
                .stream().filter(company -> company.getLocations().contains(location)).toList();
    }


}
