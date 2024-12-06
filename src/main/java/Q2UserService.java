interface Q2UserService {
    boolean usernameExists(String username);
    boolean saveUser(String username, String password);
}