package Multithreading.ForkJoinReview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ExampleRecursiveAction extends RecursiveAction {

    private int workloadAmmount = 0;

    public ExampleRecursiveAction(int workloadAmmount) {
        this.workloadAmmount = workloadAmmount;
    }

    @Override
    protected void compute () {
        if (this.workloadAmmount < 15) {
            System.out.println("Since the size of the workload is adequate, I am working myself in thread "
                    + Thread.currentThread().getName() + " with workload: " + this.workloadAmmount);
        } else {
            System.out.println("Size of workload is too big. Therefor splitting workload in thread "
                    + Thread.currentThread().getName() + " with workload: " + this.workloadAmmount);
            // splitting the subtasks into a List
            List<ExampleRecursiveAction> splitSubtasksList = new ArrayList<>(createSplitSubtasks());

            // two different example of forking the task
            for (RecursiveAction subtask : splitSubtasksList) {
                subtask.fork();
            }

            //ForkJoinTask.invokeAll(createSplitSubtasks());
        }
    }

    // this is how to create subtasks:
    private List<ExampleRecursiveAction> createSplitSubtasks() {
        List<ExampleRecursiveAction> splitSubtasksList = new ArrayList<>();

        ExampleRecursiveAction splitSubtask1 = new ExampleRecursiveAction(this.workloadAmmount / 2);
        ExampleRecursiveAction splitSubtask2 = new ExampleRecursiveAction(this.workloadAmmount / 2);

        splitSubtasksList.add(splitSubtask1);
        splitSubtasksList.add(splitSubtask2);

        return splitSubtasksList;
    }
}
