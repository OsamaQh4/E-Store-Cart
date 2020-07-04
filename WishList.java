public class WishList {
    private String name;
    private Node head;

    public WishList(String name){
        this.name = name;
        head = null;
    }
    public boolean add(EStoreCart eStoreCart){
        Node current = head;
        while(current != null){
            if(current.data == eStoreCart){
                return false;
            }else {
                current = current.next;
            }
        }
        current = new Node(eStoreCart);
        return true;
    }
    public boolean remove(EStoreCart eStoreCart){
        if(head == null){
            return false;
        }else {
            Node i = head;
            for (; i.data != eStoreCart;)
            {
                i = i.next;
            }
            Node j = i;
            i = j.next;
            return true;
        }
    }
    public void sortOnShipping(){
         if(head == null){
             return;
         }else{
             Node i , j , swap = null;
             i = head;
             for(i = head; i.next != null; i = i.next){
                 for(j = i.next; j != null; j= j.next){
                     if(i.data instanceof Domestic){
                         if(((Domestic)j.data).isFreeShipping()){
                             swap.data = i.data;
                             i.data = j.data;
                             j.data = swap.data;
                         }
                     }
                 }
             }
         }
    }
    public void flipAllExpress(){
            Node current = head;
            flipAllExpress(current);
    }
    private void flipAllExpress(Node current){
        if(current == null){
            return;
        }else {
            if (current.data instanceof International) {
                ((International) current.data).setExpress(!(((International) current.data).isExpress()));
            }
            flipAllExpress(current.next);
        }
    }
}
