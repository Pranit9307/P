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

public class JobScheduling {

    public static void scheduleJobs(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int totalProfit = 0;
        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline, job.deadline); j > 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled Jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i] != -1) {
                System.out.print("Job" + slots[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of jobs: ");
        int n = scanner.nextInt();

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Job " + (i + 1) + ":");
            System.out.print("Deadline: ");
            int deadline = scanner.nextInt();
            System.out.print("Profit: ");
            int profit = scanner.nextInt();

            jobs[i] = new Job(i + 1, deadline, profit);
        }

        scheduleJobs(jobs, n);
        scanner.close();
    }
}
