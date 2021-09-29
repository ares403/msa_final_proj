package vaccine;

public class VaccineCanceled extends AbstractEvent {

    private Long id;
    private String name;
    private Long vaccineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getProdId() {
        return vaccineId;
    }

    public void setProdId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }
}