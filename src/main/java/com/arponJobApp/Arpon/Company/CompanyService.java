package com.arponJobApp.Arpon.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    Company getCompanyById(Long id);
    boolean deleteCompany(Long id);
}
