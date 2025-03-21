package com.arponJobApp.Arpon.review.impl;

import com.arponJobApp.Arpon.Company.Company;
import com.arponJobApp.Arpon.Company.CompanyService;
import com.arponJobApp.Arpon.review.Review;
import com.arponJobApp.Arpon.review.ReviewRepository;
import com.arponJobApp.Arpon.review.ReviewService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }
}
