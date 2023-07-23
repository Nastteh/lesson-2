import Controllers.Controller;
import Model.FileOperation;
import Model.FileOperationImpl;
import Model.ToyOperation;
import Model.ToyOperationImpl;
import View.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl();
        ToyOperation toyOperation = new ToyOperationImpl(fileOperation);
        Controller controller = new Controller(toyOperation);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}