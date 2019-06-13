package mars_rover;

import java.util.List;

public interface CommunicationProtocol {
    List<Command> createCommands(String message, int displacement);
}
