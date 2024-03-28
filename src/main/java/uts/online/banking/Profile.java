package uts.online.banking;

/**
 * The type Profile.
 */
public class Profile {
    private String username;
    private String password;

    /**
     * Instantiates a new Profile.
     *
     * @param theUsername the the username
     * @param thePassword the the password
     */
    public Profile(String theUsername, String thePassword) {
        username = theUsername;
        password = thePassword;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
