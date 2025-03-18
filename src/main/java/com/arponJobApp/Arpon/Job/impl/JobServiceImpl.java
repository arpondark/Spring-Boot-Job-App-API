package com.arponJobApp.Arpon.Job.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arponJobApp.Arpon.Job.Job;
import com.arponJobApp.Arpon.Job.JobRepository;
import com.arponJobApp.Arpon.Job.JobService;

@Service
public class JobServiceImpl implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        if (jobRepository.existsById(id)) {
            job.setId(id);
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}
