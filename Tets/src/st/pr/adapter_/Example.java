package st.pr.adapter_;

public class Example {
    public static void main(String[] args) {
        Programmer chuckNorris = requirements -> Implementation.of(requirements).commit();

        Manager analyst = task -> chuckNorris.implement(task.requirements);

        Manager manager = analyst::request;

        manager.request(new Task(12, "JDBC driver should be updated"));
    }
}
