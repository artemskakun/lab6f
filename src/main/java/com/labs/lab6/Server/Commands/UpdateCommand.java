package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

import java.util.Map;

/**
 * Update element of repository by ID
 */
public class UpdateCommand extends AbstractCommand {
    private final Repository repository;

    public UpdateCommand(Repository repository) {
        super("update id {element}", "Update value of Repository's element by ID");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {
        int id = Integer.parseInt(request.getCommandStruct().getArgument());
        StudyGroup studyGroup = (StudyGroup) request.getCommandArg();
        for (Map.Entry<Integer, StudyGroup> entry : repository.get().entrySet()) {
            if (entry.getValue().getId() == id) {
                studyGroup.setKey(entry.getValue().getKey());
                studyGroup.setId(entry.getValue().getId());
                repository.get().put(entry.getKey(), studyGroup);
                return true;
            }
        }
        return false;
    }
}