public abstract class EStoreCart {
    private String timeStamp;
    private Item [] items;
    private int nbItems;

    public EStoreCart(String timeStamp, int size) throws IllegalArgumentException{
        if(size <=0 ){
            throw new IllegalArgumentException("Error: size is zero or less.");
        }else {
            this.timeStamp = timeStamp;
            items = new Item[size];
            nbItems = 0;
        }
    }
    public boolean add(Item item){
        if(item != null && nbItems < items.length){
            items[nbItems++] = item;
            return true;
        }
        return false;
    }
    public boolean remove(Item item){
        if(item != null && nbItems != 0){
            boolean right = false;
            for(int i  =0; i<nbItems ; i++){
                if(items[i].equals(item)){
                    items[i] = items[nbItems-1];
                    nbItems--;
                    right = true;
                }
            }
            return right;
        }
        return false;
    }
    public abstract double calculateShipping();
    public double getTotal(){
        if(nbItems != 0){
            double total = 0;
            for(int i =0; i<nbItems; i++){
                total += items[i].getPrice();
            }
            return total;
        }
        else return -1;
    }
    public boolean equals(EStoreCart eStoreCart){
        boolean right = false;
        if(this.nbItems != eStoreCart.nbItems){
            return false;
        }else if(this.nbItems == eStoreCart.nbItems){
            for(int i =0; i<nbItems; i++){
                if(!(this.items[i].equals(eStoreCart.items[i]))){
                    return false;
                }
            }
        }else if(this.timeStamp.equalsIgnoreCase(eStoreCart.timeStamp)){
            return true;
        }
        return false;
    }
}
