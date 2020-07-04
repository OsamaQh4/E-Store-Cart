public class Item {
    private int id;
    private String info;
    private double price;

    public Item(int id, String info, double price){
        this.id = id;
        this.info = info;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public boolean equals(Item item){
        return (this.id == item.id)? true : false ;
    }

}
