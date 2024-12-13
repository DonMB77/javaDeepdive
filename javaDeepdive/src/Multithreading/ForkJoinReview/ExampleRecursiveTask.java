package Multithreading.ForkJoinReview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ExampleRecursiveTask extends RecursiveTask<Integer> {

    // the only big difference in comparison to ExampleRecursiveAction is that we need to join the elements of computation

    private int workloadAmmount = 0;

    public ExampleRecursiveTask (int workload) {
        this.workloadAmmount = workload;
    }

    @Override
    protected Integer compute () {
        if (this.workloadAmmount < 15) {
            System.out.println("Since the size of the workload is adequate, I am working myself in thread "
                    + Thread.currentThread().getName() + " with workload: " + this.workloadAmmount);
            return workloadAmmount * 2;
        } else {
            System.out.println("Size of workload is too big. Therefor splitting workload in thread "
                    + Thread.currentThread().getName() + " with workload: " + this.workloadAmmount);
            // splitting the subtasks into a List
            List<ExampleRecursiveTask> splitSubtasksList = new ArrayList<>(createSplitSubtasks());

            // two different example of forking the task
            for (ExampleRecursiveTask subtask : splitSubtasksList) {
                subtask.fork();
            }

            //ForkJoinTask.invokeAll(createSplitSubtasks());

            int resultOfComputation = 0;
            for (ExampleRecursiveTask subtask : splitSubtasksList) {
                resultOfComputation += subtask.join();
            }
            return resultOfComputation;
        }
    }

    // this is how to create subtasks:
    private List<ExampleRecursiveTask> createSplitSubtasks() {
        List<ExampleRecursiveTask> splitSubtasksList = new ArrayList<>();

        ExampleRecursiveTask splitSubtask1 = new ExampleRecursiveTask(this.workloadAmmount / 2);
        ExampleRecursiveTask splitSubtask2 = new ExampleRecursiveTask(this.workloadAmmount / 2);

        splitSubtasksList.add(splitSubtask1);
        splitSubtasksList.add(splitSubtask2);

        return splitSubtasksList;
    }
}
