package контр;

public class Laptop {
    String name;
    int ram;
    int sdd;
    String oc;
    String color;

    public Laptop(String name, int ram, int sdd, String oc, String color) {
        this.name = name;
        this.ram = ram;
        this.sdd = sdd;
        this.oc = oc;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' + 
                ", ram=" + ram +
                ", sdd=" + sdd +
                ", oc='" + oc +'\'' + 
                ", color='" + color + '\'' +
                '}';
     }
   
}
