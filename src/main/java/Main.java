import models.UserModel;
import service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        List<UserModel> userModels = userService.getAllUser();
        for (UserModel userModel : userModels) {
            System.out.println("Name: " + userModel.getFullname());
        }   
    }
}
