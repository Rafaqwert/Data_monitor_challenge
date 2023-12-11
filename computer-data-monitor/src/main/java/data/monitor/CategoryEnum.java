package data.monitor;

public enum CategoryEnum {

    CPU_USAGE (1, "%"),
    RAM_USAGE (2, "%"),
    DISK_USAGE (3, "%"),
    DISK_STORAGE (4, "Gb");

    private int CategoryId;
    private String measureUnit;

    CategoryEnum(int categoryId, String measureUnit) {
        CategoryId = categoryId;
        this.measureUnit = measureUnit;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }
}
