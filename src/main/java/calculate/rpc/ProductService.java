package calculate.rpc;

public class ProductService implements IProductService {
    @Override
    public Detail queryById() {
        Detail detail = new Detail();
        detail.setId("123");
        detail.setName("123");
        System.out.println("123");
        return detail;
    }
}
