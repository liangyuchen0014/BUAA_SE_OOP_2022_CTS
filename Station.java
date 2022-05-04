import java.util.Objects;

public class Station {
    String namest;
    int km;

    public String getNamest() {
        return namest;
    }

    public void setNamest(String namest) {
        this.namest = namest;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Station(String namest, int km) {
        this.namest = namest;
        this.km = km;
    }

    @Override
    public String toString() {
        return namest + ':' +km ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return namest.equals(station.namest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namest);
    }
}
