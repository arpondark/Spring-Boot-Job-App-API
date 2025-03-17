package com.arponJobApp.Arpon.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job findById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job job);
}
