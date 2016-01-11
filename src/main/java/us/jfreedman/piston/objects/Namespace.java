package us.jfreedman.piston.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 1/11/2016.
 */
public class Namespace {

    private final List<Project> projectList;

    public Namespace() {
        this(new ArrayList<>());
    }

    public Namespace(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public List<Project> add(Project project) {
        projectList.add(project);
        return projectList;
    }

    public Project get(int index) {
        return projectList.get(index);
    }
}
