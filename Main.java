
import entities.DataRepositoryImpl;
import interfaces.Connection;
import misc.ConnectionImpl;
import misc.EngineImpl;
import interfaces.Controller;
import interfaces.DataRepository;
import interfaces.Engine;
import misc.ControllerImpl;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        DataRepository repository = new DataRepositoryImpl();
        Connection  connection = new ConnectionImpl();
        Controller controller = new ControllerImpl(connection,repository);

        Engine engine = new EngineImpl(controller);

        engine.run();


    }
}
