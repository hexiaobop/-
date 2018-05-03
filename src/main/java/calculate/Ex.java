package calculate;

public class Ex {

    public static void main(String[] args) {
    }


}


class e1 extends  Exception{
    @Override
    public String getMessage() {
        System.out.println("e1");
        return super.getMessage();
    }
}

class e2 extends  RuntimeException{
    @Override
    public String getMessage() {
        System.out.println("e2");
        return super.getMessage();
    }
}