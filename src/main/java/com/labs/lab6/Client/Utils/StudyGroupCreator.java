package com.labs.lab6.Client.Utils;

import com.labs.lab6.common.Data.*;
import com.labs.lab6.common.Exceptions.IncorrectCommandFormatException;
import com.labs.lab6.common.Exceptions.InvalidValueException;

import java.util.Arrays;

import static com.labs.lab6.Client.Utils.ConsoleManager.replyUser;

public class StudyGroupCreator {

    private CommandStruct response;
    private UserInfo userInfo;

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private long studentsCount; //Значение поля должно быть больше 0
    private Integer expelledStudents; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Semester semester; //Поле может быть null
    private final Person groupAdmin = new Person(); //Поле не может быть null


    private static class UserInfo {
        private final boolean consoleMod;

        UserInfo() {
            this.consoleMod = ConsoleManager.getCommandReader().getCommandReaderMod() == CommandReaderMode.CONSOLE;
        }

        public void sendMessage(String msg) {
            if (consoleMod) System.out.println(msg);
        }

        public void nameInfo() {
            if (consoleMod) System.out.print("| Name: ");
        }

        public void coordinatesInfo() {
            if (consoleMod) System.out.print("| Coordinates {x y}: ");
        }

        public void studentsCountInfo() {
            if (consoleMod) System.out.print("| Students count: ");
        }

        public void expelledStudentsInfo() {
            if (consoleMod) System.out.print("| Expelled students count: ");
        }

        public void formOfEducationInfo() {
            if (consoleMod)
                System.out.printf("| Form of education {one of %s}: ", Arrays.toString(FormOfEducation.values()));
        }

        public void semesterInfo() {
            if (consoleMod)
                System.out.printf("| Semester {one of %s}: ", Arrays.toString(Semester.values()));
        }

        public void groupAdminInfo() {
            if (consoleMod) System.out.print("| Group admin ->\n");
        }

        public void adminNameInfo() {
            if (consoleMod) System.out.print("| | Name: ");
        }

        public void adminPassportInfo() {
            if (consoleMod) System.out.print("| | Passport ID: ");
        }

        public void adminEyeColorInfo() {
            if (consoleMod)
                System.out.printf("| | Eye color {one of %s}: ", Arrays.toString(Color.values()));
        }

        public void adminHairColorInfo() {
            if (consoleMod)
                System.out.printf("| | Hair color {one of %s}: ", Arrays.toString(Color.values()));
        }

        public void adminCountryInfo() {
            if (consoleMod)
                System.out.printf("| | Country {one of %s}: ", Arrays.toString(Country.values()));
        }
    }


    private void setName() {
        userInfo.nameInfo();
        response = ConsoleManager.getCommandStruct();

        assert response != null;
        if (!response.isHasCommand()) throw new IncorrectCommandFormatException("Field 'Name' must not be empty");
        if (response.isHasArgument()) throw new IncorrectCommandFormatException("Field 'Name' must be one word");

        this.name = response.getCommand();
    }

    private void setCoordinates() {
        userInfo.coordinatesInfo();
        response = ConsoleManager.getCommandStruct();

        assert response != null;
        if (!response.isHasCommand())
            throw new IncorrectCommandFormatException("Field 'Coordinates' must consist of two numbers");
        if (!response.isHasArgument())
            throw new IncorrectCommandFormatException("Field 'Coordinates' must consist of two numbers");

        double coordinateX = Double.parseDouble(response.getCommand()); // can throw NumberFormatException
        double coordinateY = Double.parseDouble(response.getArgument()); // can throw NumberFormatException
        if (coordinateX <= -722) throw new InvalidValueException("Field 'CoordinateY' must be greater than 722");
        if (coordinateY > 37) throw new InvalidValueException("Field 'CoordinateY' must be less than 38");

        this.coordinates = new Coordinates(coordinateX, coordinateY);
    }

    private void setStudentsCount() {
        userInfo.studentsCountInfo();
        response = ConsoleManager.getCommandStruct();

        assert response != null;
        if (!response.isHasCommand())
            throw new IncorrectCommandFormatException("Field 'StudentsCount' must not be empty");
        if (response.isHasArgument())
            throw new IncorrectCommandFormatException("Field 'StudentsCount' must be one word");

        int healthValue = Integer.parseInt(response.getCommand()); // can throw NumberFormatException
        if (healthValue <= 0) throw new InvalidValueException("Field 'StudentsCount' must be greater than 0");

        this.studentsCount = healthValue;
    }

    private void setExpelledStudents() {
        userInfo.expelledStudentsInfo();
        response = ConsoleManager.getCommandStruct();

        assert response != null;
        if (!response.isHasCommand())
            throw new IncorrectCommandFormatException("Field 'ExpelledStudents' must not be empty");
        if (response.isHasArgument())
            throw new IncorrectCommandFormatException("Field 'ExpelledStudents' must be one word");

        int expelledStudentsValue = Integer.parseInt(response.getCommand()); // can throw NumberFormatException
        if (expelledStudentsValue <= 0) throw new InvalidValueException("Field 'StudentsCount' must be greater than 0");

        this.expelledStudents = expelledStudentsValue;
    }

    private void setFormOfEducation() {
        userInfo.formOfEducationInfo();
        response = ConsoleManager.getCommandStruct();

        assert response != null;
        if (!response.isHasCommand())
            throw new IncorrectCommandFormatException("Field 'FormOfEducation' must not be empty");
        if (response.isHasArgument())
            throw new IncorrectCommandFormatException("Field 'FormOfEducation' must be one word");

        this.formOfEducation = FormOfEducation.valueOf(response.getCommand().toUpperCase()); // can throw IllegalArgumentException
    }

    private void setSemester() {
        userInfo.semesterInfo();
        response = ConsoleManager.getCommandStruct();

        assert response != null;
        if (!response.isHasCommand()) {
            this.semester = null;
            return;
        }
        if (response.isHasArgument())
            throw new IncorrectCommandFormatException("Field 'Semester' must be one word");

        this.semester = Semester.valueOf(response.getCommand().toUpperCase()); // can throw IllegalArgumentException
    }

    private void setAdminName() {
        userInfo.adminNameInfo();
        response = ConsoleManager.getCommandStruct();
        assert response != null;
        if (!response.isHasCommand()) {
            throw new IncorrectCommandFormatException("Field 'Name' must not be empty");
        }
        if (response.isHasArgument()) {
            throw new IncorrectCommandFormatException("Field 'Name' must be one word");
        }
        groupAdmin.setName(response.getCommand());
    }

    private void setAdminPassportID() {
        userInfo.adminPassportInfo();
        response = ConsoleManager.getCommandStruct();
        assert response != null;
        if (!response.isHasCommand()) {
            groupAdmin.setPassportID(null);
            return;
        }
        if (response.isHasArgument()) {
            throw new IncorrectCommandFormatException("Field 'PassportID' must be one word");
        }
        if (response.getCommand().length() > 30) {
            throw new InvalidValueException("Field 'PassportID' must be <= 30 characters");
        }
        groupAdmin.setPassportID(response.getCommand());
    }

    private void setAdminEyeColor() {
        userInfo.adminEyeColorInfo();
        response = ConsoleManager.getCommandStruct();
        assert response != null;
        if (!response.isHasCommand()) {
            throw new IncorrectCommandFormatException("Field 'EyeColor' must not be empty");
        }
        if (response.isHasArgument()) {
            throw new IncorrectCommandFormatException("Field 'EyeColor' must be one word");
        }
        groupAdmin.setEyeColor(Color.valueOf(response.getCommand().toUpperCase()));
    }

    private void setAdminHairColor() {
        userInfo.adminHairColorInfo();
        response = ConsoleManager.getCommandStruct();
        assert response != null;
        if (!response.isHasCommand()) {
            groupAdmin.setHairColor(null);
            return;
        }
        if (response.isHasArgument()) {
            throw new IncorrectCommandFormatException("Field 'HairColor' must be one word");
        }
        groupAdmin.setHairColor(Color.valueOf(response.getCommand().toUpperCase()));
    }

    private void setAdminCountry() {
        userInfo.adminCountryInfo();
        response = ConsoleManager.getCommandStruct();
        assert response != null;
        if (!response.isHasCommand()) {
            groupAdmin.setNationality(null);
            return;
        }
        if (response.isHasArgument()) {
            throw new IncorrectCommandFormatException("Field 'Country' must be one word");
        }
        groupAdmin.setNationality(Country.valueOf(response.getCommand().toUpperCase()));
    }


    private void setGroupAdmin() {
        userInfo.groupAdminInfo();
    }

    /**
     * Create a new instance of StudyGroup
     *
     * @return new StudyGroup
     */
    public StudyGroup create() {
        userInfo = new UserInfo();
        boolean correctInput;

        if (ConsoleManager.getCommandReader().getCommandReaderMod() == CommandReaderMode.CONSOLE) {
            correctInput = false;
            do {
                try {
                    setName();
                    correctInput = true;
                } catch (IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setCoordinates();
                    correctInput = true;
                } catch (IncorrectCommandFormatException | InvalidValueException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (NumberFormatException e) {
                    userInfo.sendMessage("Incorrect number format");
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setStudentsCount();
                    correctInput = true;
                } catch (IncorrectCommandFormatException | InvalidValueException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (NumberFormatException e) {
                    userInfo.sendMessage("Incorrect number format");
                }

            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setExpelledStudents();
                    correctInput = true;
                } catch (IncorrectCommandFormatException | InvalidValueException e) {
                    userInfo.sendMessage(e.getMessage());
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setFormOfEducation();
                    correctInput = true;
                } catch (IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (IllegalArgumentException e) {
                    userInfo.sendMessage("There is no such FormOfEducation");
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setSemester();
                    correctInput = true;
                } catch (IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (IllegalArgumentException e) {
                    userInfo.sendMessage("There is no such Semester");
                }
            } while (!correctInput);

            userInfo.groupAdminInfo();

            correctInput = false;
            do {
                try {
                    setAdminName();
                    correctInput = true;
                } catch (InvalidValueException | IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (NumberFormatException e) {
                    userInfo.sendMessage("Incorrect number format");
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setAdminPassportID();
                    correctInput = true;
                } catch (InvalidValueException | IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (NumberFormatException e) {
                    userInfo.sendMessage("Incorrect number format");
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setAdminEyeColor();
                    correctInput = true;
                } catch (InvalidValueException | IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (NumberFormatException e) {
                    userInfo.sendMessage("Incorrect number format");
                } catch (IllegalArgumentException e) {
                    userInfo.sendMessage("There is no such EyeColor");
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setAdminHairColor();
                    correctInput = true;
                } catch (InvalidValueException | IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (NumberFormatException e) {
                    userInfo.sendMessage("Incorrect number format");
                } catch (IllegalArgumentException e) {
                    userInfo.sendMessage("There is no such HairColor");
                }
            } while (!correctInput);

            correctInput = false;
            do {
                try {
                    setAdminCountry();
                    correctInput = true;
                } catch (InvalidValueException | IncorrectCommandFormatException e) {
                    userInfo.sendMessage(e.getMessage());
                } catch (NumberFormatException e) {
                    userInfo.sendMessage("Incorrect number format");
                } catch (IllegalArgumentException e) {
                    userInfo.sendMessage("There is no such Country");
                }
            } while (!correctInput);

            return new StudyGroup(name, coordinates, studentsCount, expelledStudents, formOfEducation, semester, groupAdmin);
        }

        try {
            setName();
            setCoordinates();
            setStudentsCount();
            setExpelledStudents();
            setFormOfEducation();
            setSemester();
            setAdminName();
            setAdminPassportID();
            setAdminEyeColor();
            setAdminHairColor();
            setAdminCountry();

            return new StudyGroup(name, coordinates, studentsCount, expelledStudents, formOfEducation, semester, groupAdmin);
        } catch (Exception e) {
            ConsoleManager.getCommandReader().setConsoleMod();
            replyUser("SCRIPT STOPPED: Command failed. Check correctness of the data");
            return null;
        }
    }


}
