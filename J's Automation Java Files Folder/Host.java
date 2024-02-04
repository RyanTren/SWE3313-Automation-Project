import java.util.*;
public class Host {
    private Map<Integer, String> tableStatus;  // Table number to status mapping

    public Host() {
        tableStatus = new HashMap<>();
        // Initialize table status (e.g., open, occupied, dirty)
    }

    public void viewTableStatus() {
        // Display table status
    }

    public void assignServerToTable(int tableNumber, String serverName) {
        // Assign a server to a specific table
    }
}

