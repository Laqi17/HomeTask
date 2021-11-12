package hw9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private int age;

    private static final String PATH_TO_FILE_TXT = "src/resources/Task2/file.txt";
    private static final String PATH_TO_FILE_JSON = "src/resources/Task2/user.json";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void createListFromFile(File file, List<User> users) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                String[] str = bufferedReader.readLine().trim().split(" ");
                if (str.length > 1 && str[1].matches("[0-9]+")) {
                    User user = new User();
                    user.setName(str[0]);
                    user.setAge(Integer.parseInt(str[1]));
                    users.add(user);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        File file = new File(PATH_TO_FILE_TXT);
        List<User> users = new ArrayList<>();

        FileCrietor fileCrietor =  new FileCrietor();
        File jsonFile = new File(PATH_TO_FILE_JSON);

        fileCrietor.crieatFile(file, jsonFile);
        createListFromFile(file, users);

        users.forEach(System.out::println);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUser = gson.toJson(users);

        Writer writer = new  Writer();
        writer.writeToJsonFile(jsonUser, jsonFile);



    }

}
