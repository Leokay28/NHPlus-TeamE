package datastorage;

import model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DAOimp<User> {

    public UserDAO(Connection conn) {
        super(conn);
    }

    @Override
    protected String getCreateStatementString(User user) {
        return String.format("INSERT INTO user (uid, username, password, role) VALUES " +
                        "(%d, '%s', '%s', '%s')", user.getUid(), user.getUsername(), user.getPassword(), user.getRole());
    }

    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM user WHERE uid = %d", key);
    }

    @Override
    protected User getInstanceFromResultSet(ResultSet result) throws SQLException {
        long uid = result.getLong("uid");
        String username = result.getString("username");
        String password = result.getString("password");
        String role = result.getString("role");
        return new User(uid, username, password, role);
    }

    @Override
    protected String getReadAllStatementString() {
        return "SELECT * FROM user";
    }

    @Override
    protected ArrayList<User> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<User> list = new ArrayList();
        User u;
        while (result.next()) {
            long uid = result.getLong("uid");
            String username = result.getString("username");
            String password = result.getString("password");
            String role = result.getString("role");
            u = new User(uid, username, password, role);
            list.add(u);
        }
        return list;
    }

    @Override
    protected String getUpdateStatementString(User user) {
        return String.format("UPDATE user SET uid = %d, username ='%s', password = '%s', role = '%s'", user.getUid(),
                user.getUsername(), user.getPassword(), user.getRole());
    }

    @Override
    protected String getDeleteStatementString(long key) {
        return String.format("Delete FROM user WHERE uid= %d", key);
    }
}