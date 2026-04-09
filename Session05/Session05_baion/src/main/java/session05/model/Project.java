package session05.model;

import java.time.LocalDate;

public class Project {
    private String id;
    private String name;
    private String description;
    private String manager;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalMembers;

    public Project(String id, String name, String description, String manager,
                   LocalDate startDate, LocalDate endDate, int totalMembers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manager = manager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalMembers = totalMembers;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getManager() { return manager; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public int getTotalMembers() { return totalMembers; }
}