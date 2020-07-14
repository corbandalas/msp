
package accomplish.dto.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Courier {

    @SerializedName("supplier")
    @Expose
    private String supplier;
    @SerializedName("shipping_method")
    @Expose
    private String shippingMethod;
    @SerializedName("tracking_number")
    @Expose
    private String trackingNumber;
    @SerializedName("estimated_delivery")
    @Expose
    private String estimatedDelivery;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

}
