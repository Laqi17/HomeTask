package hw13.goit.http;

import hw13.goit.user.*;

import java.io.IOException;
import java.util.List;


public class HttpDemo {
    private static final String GET_POSTS = "https://jsonplaceholder.typicode.com/posts";
    private static final String GET_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String GET_COMMENTS = "https://jsonplaceholder.typicode.com/comments";

    public static void main(String[] args) throws IOException, InterruptedException {
        User userRoman = new User(101, "Roman", "qwwerty", "roman@gmail.com",
                new Address("street", "Home", "Kyiv", "1564SD",
                        new Geo(15.456456, 5516.546)), "46", "www.sdas.com",
                new Company("Company", "Proactive didactic contingency", "synergize scalable supply-chains"));

        System.out.println("----------------------Task 1.1-----------------------------");
        final User user = HttpUtil.sendPost(GET_POSTS, userRoman);
        System.out.println(user);


        System.out.println("----------------------Task 1.2-----------------------------");
        System.out.println(HttpUtil.put(GET_USERS, 1, userRoman).toString());


        System.out.println("----------------------Task 1.3-----------------------------");
        HttpUtil.removeById(GET_USERS, 3);


        System.out.println("----------------------Task 1.4-----------------------------");
        HttpUtil.sendGet(GET_USERS);


        System.out.println("----------------------Task 1.5-----------------------------");
        System.out.println(HttpUtil.sendGetByID(GET_USERS, 1));


        System.out.println("----------------------Task 1.6-----------------------------");
        HttpUtil.sendGetByUsername(GET_USERS, "Antonette");


        System.out.println("----------------------Task 2-----------------------------");
        HttpUtil.getCommentsByUserID(GET_USERS,GET_COMMENTS, 5);


        System.out.println("----------------------Task 3-----------------------------");
        List<Task> tasks = HttpUtil.getTodos(GET_USERS, 1);
        System.out.println(tasks);
    }
}
