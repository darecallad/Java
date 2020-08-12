package Project.ListTypeDataStructures;

public class Node<Tier1, Tier2, Tier3> {
    //Members with level access
    protected Tier1 category1;
    protected Tier2 category2;
    protected Tier3 category3;

    protected Node<Tier1,Tier2,Tier3>left = null;
    protected Node<Tier1,Tier2,Tier3>right = null;
    protected Node<Tier1,Tier2,Tier3>down = null;


    /**
     * Constructor to initialize the category member variables by using the arguments
     * @param t1 value for category1
     * @param t2 value for category2
     * @param t3 value for category3
     */

    public Node(Tier1 t1,Tier2 t2,Tier3 t3){
        // this.category1=t1;
        // this.category2=t2;
        //  this.category3=t3;
        category1=t1;
        category2=t2;
        category3=t3;
    }

    // cate1 // cate2 // cate3
    public Tier1 getCategory1(){ //1
        return category1;
    }


    public void setCategory1(Tier1 category1){//1
        this.category1 = category1;
    }


    public Tier2 getCategory2(){//2
        return category2;
    }


    public void setCategory2(Tier2 category2){//2
        this.category2 = category2;
    }


    public Tier3 getCategory3(){//3
        return category3;
    }


    public void setCategory3(Tier3 category3){//3
        this.category3 = category3;
    }

    //testing
    //
    //public String toString(){
    //   return "["+category1+","+category2+","+category3+"]";
    //} ...........
}