package com.vtrieutien.JobApp;

import com.vtrieutien.JobApp.model.JobPost;
import com.vtrieutien.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    private JobService jobService;
    @GetMapping({"/", "home"})
    public String home(){
        return "home";
    }
    @GetMapping("addjob")
    public String addjob(){
        return "addjob";
    }

    @RequestMapping("handleForm")
    public String handleForm(JobPost jobPost){
        jobService.addJobPost(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewalljobs(Model model){
        List<JobPost> jobList = jobService.returnAllJobPosts();
        model.addAttribute("jobPosts", jobList);
        return "viewalljobs";
    }

    public JobService getJobService() {
        return jobService;
    }

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }
}
