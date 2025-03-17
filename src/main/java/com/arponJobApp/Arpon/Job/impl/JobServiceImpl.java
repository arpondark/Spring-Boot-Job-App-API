package com.arponJobApp.Arpon.Job.impl;

import java.util.ArrayList;
import java.util.List; 

import org.springframework.stereotype.Service;

import com.arponJobApp.Arpon.Job.Job; 
import com.arponJobApp.Arpon.Job.JobService; 

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    public boolean deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    public boolean updateJobById(Long id, Job job) {
        for (Job j : jobs) {
            if (j.getId().equals(id)) {
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                j.setLocation(job.getLocation());
                return true;
            }
        }
        return false;
    }

}
