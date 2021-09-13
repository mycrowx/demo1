package demo.user.model.request;

public class UserCreateUserRequest {

    private String username;
    private String password;

    /**
     * @param username
     * @param password
     */
    public UserCreateUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return (
            "UserCreateUserRequest [password=" +
            password +
            ", username=" +
            username +
            "]"
        );
    }
}
