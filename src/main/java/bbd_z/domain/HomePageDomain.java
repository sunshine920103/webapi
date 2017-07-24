package bbd_z.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rex on 17-7-9.
 */
public class HomePageDomain {

    private int task_complete = 0;
    private int task_uncomplete = 0;

    private List<DisplayDomain> displayDomains = new ArrayList<>();

    @Override
    public String toString() {
        return "HomePageDomain{" +
                "task_complete=" + task_complete +
                ", task_uncomplete=" + task_uncomplete +
                ", displayDomains=" + displayDomains +
                '}';
    }

    public int getTask_complete() {
        return task_complete;
    }

    public void setTask_complete(int task_complete) {
        this.task_complete = task_complete;
    }

    public int getTask_uncomplete() {
        return task_uncomplete;
    }

    public void setTask_uncomplete(int task_uncomplete) {
        this.task_uncomplete = task_uncomplete;
    }

    public List<DisplayDomain> getDisplayDomains() {
        return displayDomains;
    }

    public void setDisplayDomains(List<DisplayDomain> displayDomains) {
        this.displayDomains = displayDomains;
    }
}
