package Model;
import static Model.Constants.SEPARATOR;

public class ToyConverter {
    public String convert(Toy toy) {
        return String.format("%s;%s;%s;%s", toy.getId(), toy.getName(), toy.getCount(),
                toy.getDrop());
    }

    public Toy convert(String line) {
        String[] lines = line.split(SEPARATOR);
        return new Toy(Integer.valueOf(lines[0]), lines[1], Integer.valueOf(lines[2]),
                Integer.valueOf(lines[3]));
    }
}