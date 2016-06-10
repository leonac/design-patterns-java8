package st.pr.adapter_;

public class Implementation {
    public static <T> Implementation of(T requirements) {
        System.out.println("Working on requirements");

        return new Implementation();
    }

    public Implementation commit() {
        System.out.println("Committed");

        return this;
    }

    public Implementation andThen(Runnable action) {
        action.run();

        return this;
    }
}
