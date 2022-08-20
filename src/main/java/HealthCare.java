import service.Auth;
import service.MainMenu;
import utils.HealthIssueUtils;
import utils.UsersUtils;

public class HealthCare {
    public static void main(String[] args) {
        UsersUtils usersUtils = new UsersUtils();
        HealthIssueUtils healthIssueUtils = new HealthIssueUtils();
        healthIssueUtils.load();

        Auth auth = new Auth(usersUtils);
        auth.printAuthMenu();

        MainMenu mainmenu = new MainMenu(healthIssueUtils, auth, usersUtils);
        mainmenu.printMenu();

    }
}
