public class Toy {
    private int id;
    private String name;
    private int frequency;
    private int count;

    public Toy(int id, String name, int frequency, int count) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.count = count;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCount() {
        return count;
    }

    /**
     * Уменьшение количества наличия игрушек.
     */
    public void decrementCount(){
        this.count--;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
