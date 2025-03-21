package com.arponJobApp.Arpon.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arponJobApp.Arpon.Company.Company;
import com.arponJobApp.Arpon.Company.CompanyService;
import com.arponJobApp.Arpon.review.Review;
import com.arponJobApp.Arpon.review.ReviewRepository;
import com.arponJobApp.Arpon.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId() == reviewId).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
           Review review = reviewRepository.findById(reviewId).orElse(null);
           Company company = review.getCompany();
           company.getReviews().remove(review);
           companyService.updateCompany(company,companyId);
           reviewRepository.deleteById(reviewId);
            return true;

        } else {
            return false;
        }
    }

}
