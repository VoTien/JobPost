package com.vtrieutien.JobApp.service;

import com.vtrieutien.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtrieutien.JobApp.model.JobPost;

import java.util.List;

@Service
public class JobService {
    private JobRepo repo;

    public JobRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(JobRepo repo) {
        this.repo = repo;
    }
    public List<JobPost> returnAllJobPosts() {
        return repo.returnAllJobPosts();
    }
    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);

    }
}
