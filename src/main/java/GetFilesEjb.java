import javax.ejb.Stateless;

@Stateless
public class GetFilesEjb implements GetFilesEjbLocal {
    @Override
    public String getHello() {
        return "Hello, World!";
    }
}
