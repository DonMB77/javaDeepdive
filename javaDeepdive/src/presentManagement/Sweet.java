package presentManagement;

public abstract class Sweet {
    String name;
    float weight;
    float sugarWeight;

    public Sweet (String name, float weight, float sugarWeight) {
        this.name = name;
        this.weight = weight;
        this.sugarWeight = sugarWeight;
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", sugarWeight=" + sugarWeight +
                '}';
    }
}
