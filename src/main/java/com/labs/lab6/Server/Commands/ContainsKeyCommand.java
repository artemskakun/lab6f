package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Request;

public class ContainsKeyCommand extends AbstractCommand {
    private final Repository repository;

    public ContainsKeyCommand(Repository repository) {
        super("contains_key", "Check if there is element with such key");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {
        int key = Integer.parseInt(request.getCommandStruct().getArgument());
        return repository.get().containsKey(key);
    }
}
