package Model;
public class Toy { // Игрушка
    private int id; // id игрушки
    private String name;    // Название игрушки
    private int count;  // Количество
    private int drop;   // Частота выпадения игрушки - вес от 0% до 100%

    public Toy(int id, String name, int count, int drop) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.drop = drop;
    }

    public Toy(String name, int count, int drop) {
        this.name = name;
        this.count = count;
        this.drop = drop;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDrop() {
        return drop;
    }

    public void setDrop(int drop) {
        this.drop = drop;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", drop=" + drop +
                '%';
    }
}
