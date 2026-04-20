public class person {
    private String name;
    private String address;

    public person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nNama      :" + this.name +
                "\nAlamat    :" + this.address;
    }
}
