import db.DBClient;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DBClient conn = new DBClient();
        try (Connection cnx = conn.getConnection()) {
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}