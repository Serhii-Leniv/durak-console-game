package components;

public enum Rank {
    ШІСТАКА(6),
    СІМКА(7),
    ВІСІМКА(8),
    ДЕВЯТКА(9),
    ДЕСЯТКА(10),
    ВАЛЕТ(11),
    ДАМА(12),
    КОРОЛЬ(13),
    ТУЗ(14);

    private final int value; // сила карти

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
