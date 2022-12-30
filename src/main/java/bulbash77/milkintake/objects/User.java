package bulbash77.milkintake.objects;

public class User {
    private int id;
    private String login;
    private String password;
    private UserRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    //роль в базе int 0-admin, 1-OPERATOR, 2-LABORANT
    public UserRole getRole() {
        return role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private UserRole returnUserRoleById(int id){
        UserRole userRole= UserRole.OPERATOR;
        switch (id) {
            case  (0):
                userRole= UserRole.ADMIN;;
                break;
            case (1):
                userRole= UserRole.OPERATOR;;
                break;
            case (2):
                userRole= UserRole.LABORANT;
                break;
//            default:
//                userRole= UserRole.OPERATOR;;
//                break;
        }
        return userRole;
    }

    public void setRole(int roleId){
        this.role = returnUserRoleById(roleId);
    }

    public boolean checkName(){
        //требования к имени только латинские буквы и цифры без знаков и пробела,
        // неболее 8 символов
        return true;
    }
    public boolean checkPassword(){
        //требования к паролю все символы кроме пробела,
        // не более 8 символов
        return true;
    }

    public User() {}

    public User(int id, String login, String password, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        return getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getRole().hashCode();
        return result;
    }
}
