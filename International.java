public class International extends EStoreCart{
    private boolean express;

    public International(String timeStamp, int size, boolean express){
        super(timeStamp, size);
        this.express = express;
    }
    public boolean isExpress(){
        return express;
    }
    public void setExpress(boolean express){
        this.express = express;
    }
    @Override
    public double calculateShipping() {
        if(express){
            return 120.5;
        }else
            return 60.5;
    }
    public double getTotal(){
        if(super.getTotal() == -1){
            return -1;
        }
        else{
            double total = super.getTotal() + calculateShipping();
            double tax = 0.05 * total;
            total += tax;
            return total;
        }
    }

}
