package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Request;

public class RemoveLowerKeyCommand extends AbstractCommand {

    private final Repository repository;

    public RemoveLowerKeyCommand(Repository repository) {
        super("remove_lower_key key", "Remove all elements which key lower than given");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {
        int key = Integer.parseInt(request.getCommandStruct().getArgument());
        return repository.get().entrySet().removeIf((entry) -> entry.getValue().getKey() < key);
    }
}
