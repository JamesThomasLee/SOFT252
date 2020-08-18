package systemClasses;

import java.io.Serializable;

public class medicine implements Serializable {
    protected String medicineName;
    protected int stockLevel;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getMaximumDosage() {
        return maximumDosage;
    }

    public void setMaximumDosage(String maximumDosage) {
        this.maximumDosage = maximumDosage;
    }

    protected String maximumDosage;


}
