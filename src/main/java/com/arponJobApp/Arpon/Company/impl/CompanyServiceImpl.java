package com.arponJobApp.Arpon.Company.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.arponJobApp.Arpon.Company.Company;
import com.arponJobApp.Arpon.Company.CompanyRepository;
import com.arponJobApp.Arpon.Company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
    private CompanyRepository companyRepository;
    
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        if (companyRepository.existsById(id)) {
            company.setId(id); // Ensure the ID is set on the company object
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            companyRepository.deleteById(id);
            logger.info("Company with id {} deleted successfully", id);
            return true;
        } else {
            logger.warn("Company with id {} not found", id);
            return false;
        }
    }
}
