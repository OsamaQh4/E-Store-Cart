public class Domestic extends EStoreCart{
    private boolean freeShipping;

    public Domestic(String timeStamp, int size, boolean freeShipping){
        super(timeStamp, size);
        this.freeShipping = freeShipping;
    }
    public boolean isFreeShipping(){
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    @Override
    public double calculateShipping() {
        if(freeShipping){
            return 0;
        }else{
            return 15.5;
        }
    }

    @Override
    public double getTotal() {
        if(super.getTotal() == -1){
            return -1;
        }else{
            double tax = super.getTotal() * 0.05;
            double total = super.getTotal() + calculateShipping() + tax;
            return total;
        }
    }
}
