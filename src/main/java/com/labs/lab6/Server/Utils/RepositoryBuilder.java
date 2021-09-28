package com.labs.lab6.Server.Utils;

import com.google.gson.Gson;
import com.labs.lab6.Client.Utils.ConsoleManager;
import com.labs.lab6.Server.App.Main;
import com.labs.lab6.common.Data.StudyGroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class for building repository from JSON file
 */
public class RepositoryBuilder {

    private long getMaxId(Repository repository) {
        long maxId = 0;
        for (int i = 0; i < repository.size(); ++i) {
            StudyGroup studyGroup = repository.get().get(i);
            if (studyGroup == null)
                continue;

            long curId = studyGroup.getId();
            if (curId > maxId) {
                maxId = curId;
            }
        }
        return maxId;
    }

    /**
     * Build empty Repository
     *
     * @return Repository
     */
    public Repository buildEmptyRepository() {
        return new Repository(new HashMap<>());
    }

    /**
     * Build repository from JSON file by environment var
     *
     * @return Repository from JSON. For problems with reading JSON returns empty Repository
     */
    public Repository buildFromJSON() {
        Gson gson = new Gson();
        try (Scanner scanner = new Scanner(
                new FileInputStream(Main.getFileName()))) {

            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
            }
            String strJSON = builder.toString();
            Repository repository = gson.fromJson(strJSON, Repository.class);
            StudyGroup.setCounter(getMaxId(repository));
            return repository;

        } catch (IOException e) {
            ConsoleManager.replyUser("JSON file reading failed. " + e.getMessage());
        } catch (RuntimeException e) {
            ConsoleManager.replyUser("Environment variable does not exist");
        }

        return new Repository(new HashMap<>());
    }
}
