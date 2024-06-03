package Day-13_14;

import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static List<Job> jobSequencing(List<Job> jobs) {
      
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

      
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

       
        Job[] result = new Job[maxDeadline];
        boolean[] slot = new boolean[maxDeadline]; 

       
        Arrays.fill(slot, false);

       
        for (Job job : jobs) {
           
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = job; 
                    slot[j] = true;
                    break;
                }
            }
        }

     
        List<Job> jobSequence = new ArrayList<>();
        for (Job job : result) {
            if (job != null) {
                jobSequence.add(job);
            }
        }

        return jobSequence;
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        );

        List<Job> jobSequence = jobSequencing(jobs);
        System.out.println("Job Sequence for maximum profit:");
        for (Job job : jobSequence) {
            System.out.println("Job ID: " + job.id + ", Profit: " + job.profit);
        }
    }
}
