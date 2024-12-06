class UserManager {
    private final Q2UserService userService;

    public UserManager(Q2UserService userService) {
        this.userService = userService;
    }

    public boolean registerUser(String username, String password) {
        if (userService.usernameExists(username)) return false;
        return userService.saveUser(username, password);
    }
}

