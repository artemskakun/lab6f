package com.labs.lab6.Server.Commands;

import com.google.gson.Gson;
import com.labs.lab6.Server.App.Main;
import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Request;

import java.io.*;


/**
 * Save repository to JSON file (File name is in environment variable)
 */
public class SaveCommand extends AbstractCommand {

    private final Repository repository;
    private String lastData;

    public SaveCommand(Repository repository) {
        super("save", "save repository to JSON");
        this.repository = repository;
        this.lastData = "";
    }

    public String getLastData() {
        return lastData;
    }

    @Override
    public boolean execute(Request request) {  // response equals null by default

        Gson gson = new Gson();
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new BufferedOutputStream(
                        new FileOutputStream(Main.getFileName(), true)))) {

            PrintWriter printWriter = new PrintWriter(Main.getFileName());
            printWriter.close();
//            File jsonFile = new File(Main.getFileName());
//            System.out.println(Main.getFileName());
//            jsonFile.createNewFile();
            outputStreamWriter.write(gson.toJson(repository));

        } catch (IOException e) {
            lastData = "JSON file writing failed";
            return false;
        }

        return true;
    }
}