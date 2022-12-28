package bulbash77.milkintake.objects;

public class User {
    private int id;
    private String name;
    private String passw;
    private UserRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPassw(String password) {
        return passw;
    }
    //роль в базе int 0-admin, 1-OPERATOR, 2-LABORANT
    public UserRole getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassw(String passw) {
        this.passw = passw;
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

    public User(int id, String name, String passw, UserRole role) {
        this.id = id;
        this.name = name;
        this.passw = passw;
        this.role = role;
    }
}
