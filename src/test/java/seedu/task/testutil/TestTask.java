package seedu.task.testutil;

import seedu.task.model.tag.UniqueTagList;
import seedu.task.model.task.CompletionStatus;
import seedu.task.model.task.EndTime;
import seedu.task.model.task.Name;
import seedu.task.model.task.ReadOnlyTask;
import seedu.task.model.task.StartTime;

/**
 * A mutable person object. For testing only.
 */
public class TestTask implements ReadOnlyTask {

    private Name name;
    private CompletionStatus address;
    private EndTime email;
    private StartTime phone;
    private UniqueTagList tags;

    public TestTask() {
        tags = new UniqueTagList();
    }

    /**
     * Creates a copy of {@code personToCopy}.
     */
    public TestTask(TestTask taskToCopy) {
        this.name = taskToCopy.getName();
        this.phone = taskToCopy.getStartTime();
        this.email = taskToCopy.getEndTime();
        this.address = taskToCopy.getCompletionStatus();
        this.tags = taskToCopy.getTags();
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(CompletionStatus address) {
        this.address = address;
    }

    public void setEmail(EndTime email) {
        this.email = email;
    }

    public void setPhone(StartTime phone) {
        this.phone = phone;
    }

    public void setTags(UniqueTagList tags) {
        this.tags = tags;
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public StartTime getStartTime() {
        return phone;
    }

    @Override
    public EndTime getEndTime() {
        return email;
    }

    @Override
    public CompletionStatus getCompletionStatus() {
        return address;
    }

    @Override
    public UniqueTagList getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return getAsText();
    }

    public String getAddCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("add " + this.getName().fullName + " ");
        sb.append("c/" + this.getCompletionStatus().toString() + " ");
        sb.append("s/" + this.getStartTime().value + " ");
        sb.append("e/" + this.getEndTime().value + " ");
        this.getTags().asObservableList().stream().forEach(s -> sb.append("#" + s.tagName + " "));
        return sb.toString();
    }
}