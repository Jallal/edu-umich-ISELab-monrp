package edu.umich.ISELab.core.grooming;

import edu.umich.ISELab.core.backlog.Project;
import edu.umich.ISELab.core.backlog.WorkItem;
import edu.umich.ISELab.core.grooming.condition.Condition;
import edu.umich.ISELab.core.grooming.condition.DefineCondition;
import edu.umich.ISELab.core.grooming.condition.ExistCondition;
import edu.umich.ISELab.core.grooming.defineActor.DefineActors;
import edu.umich.ISELab.core.projectResources.Person;
import edu.umich.ISELab.core.util.ProjectObjectUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.Boolean.TRUE;

public class AssignTask extends NrpBase {

    protected static final Logger LOGGER = Logger.getLogger(AssignTask.class);

    protected WorkItem activeItem;
    protected Person activePerson;
    private  Map<WorkItem, Person> projectActors;


    public AssignTask() {
        super();
    }

    public AssignTask(AssignTask assignTask) {
        super(assignTask);
    }

    public AssignTask(WorkItem item , Person person) {
        super(item,person);
        this.activePerson=person;
        this.activeItem=item;
    }

    @Override
    public void loadActors(Project project) {

        this.projectActors = ProjectObjectUtils.findPair(project);
    }

    @Override
    public List<Condition> getPreConditions(WorkItem item, Person person) {

        List<Condition> conditions = new ArrayList<>();
        conditions.add(new ExistCondition(item, person));
        conditions.add(new DefineCondition(item, person));

        return conditions;
    }

    @Override
    public List<Condition> getPostConditions(WorkItem item, Person person) {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new ExistCondition(item, person));
        conditions.add(new DefineCondition(item, person));
        //conditions.add(new thiagodnf.doupr.core.grooming.condition.HasVisibilityCondition(attr, Visibility.PRIVATE));

        return conditions;
    }



    @Override
    public void execute(Project project) {

        this.loadActors(project);
        Set< Map.Entry<WorkItem, Person>> st = this.projectActors.entrySet();
        for (Map.Entry<WorkItem, Person> me:st){
               this.assignedTasks(me.getKey(),me.getValue());
        }

    }

    @Override
    public DefineActors getDefineActors() {
        return null;
    }


    public void assignedTasks(WorkItem item , Person person){
        this.activeItem.setPerson(person);
        this.activePerson.setItem(item);
        this.activeItem.setAssigned(TRUE);
        this.activePerson.setAssigned(TRUE);
    }


    @Override
    public String getName() {
        return "Encapsulate Field";
    }

    @Override
    public NrpBase copy() {
        return this.copy();
    }

    @Override
    public Person getPerson() {
        return this.activePerson;
    }

    @Override
    public WorkItem getWorkItem() {
        return this.activeItem;
    }

}