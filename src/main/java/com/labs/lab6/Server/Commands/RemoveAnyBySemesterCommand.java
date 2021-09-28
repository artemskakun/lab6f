package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.Semester;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

import java.util.Map;

public class RemoveAnyBySemesterCommand extends AbstractCommand {

    private final Repository repository;

    public RemoveAnyBySemesterCommand(Repository repository) {
        super("remove_any_by_semester [Semester]", "Remove one element which semester is equals to the given");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {
        Semester semester = (Semester) request.getCommandArg();
        for (Map.Entry<Integer, StudyGroup> entry : repository.get().entrySet()) {
            if (entry.getValue().getSemesterEnum().equals(semester)) {
                repository.get().remove(entry.getKey());
                return true;
            }
        }
        return false;
    }
}
