package edu.umich.ISELab.core.backlog;


import edu.umich.ISELab.core.projectResources.Person;
import edu.umich.ISELab.core.util.Priority;
import edu.umich.ISELab.core.util.Skills;
import edu.umich.ISELab.core.util.WorkItemDefinition;

import java.util.List;

public abstract class WorkItem {

    private int weight;
    private String workItemID;
    private boolean isAssigned = false;
    private boolean isReadyForImplementation = false;
    private Priority priority;
    private WorkItemDefinition workItemDefinition;
    private Person person;
    private List<Skills> skillsRequired;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public WorkItemDefinition getWorkItemDefinition() {
        return workItemDefinition;
    }

    public void setWorkItemDefinition(WorkItemDefinition workItemDefinition) {
        this.workItemDefinition = workItemDefinition;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public boolean isReadyForImplementation() {
        return isReadyForImplementation;
    }

    public void setReadyForImplementation(boolean readyForImplementation) {
        isReadyForImplementation = readyForImplementation;
    }

    public String getWorkItemID() {
        return workItemID;
    }

    public void setWorkItemID(String workItemID) {
        this.workItemID = workItemID;
    }

    @Override
    public String toString() {

        return this.getWorkItemID() + " is assigned to " + this.person.getName()+"\n";
    }
}
