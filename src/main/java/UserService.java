public class UserService {
    UserRepository userRepository;
    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User findUserById(int id){
        return this.userRepository.findById(id);
    }
}
