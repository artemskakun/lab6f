package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

import java.util.Map;

public class ContainsCommand extends AbstractCommand {
    private final Repository repository;

    public ContainsCommand(Repository repository) {
        super("contains", "Check if there is element with such ID");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {
        int id = Integer.parseInt(request.getCommandStruct().getArgument());
        for (Map.Entry<Integer, StudyGroup> entry : repository.get().entrySet()) {
            if (entry.getValue().getId() == id) {
                return true;
            }
        }
        return false;
    }
}
