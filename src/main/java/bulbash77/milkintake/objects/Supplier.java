package bulbash77.milkintake.objects;

public class Supplier {
    private int id;
    private String name;
    private String unn;

    public Supplier(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnn() {
        return unn;
    }

    public void setUnn(String unn) {
        this.unn = unn;
    }
}
