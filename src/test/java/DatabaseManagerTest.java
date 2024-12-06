import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseManagerTest {

    private static DatabaseManager databaseManager;

    @BeforeAll
    static void beforeAll() {
        databaseManager = new DatabaseManager();
        databaseManager.openConnection();
    }

    @BeforeEach
    void beforeEach() {
        databaseManager.clearPendingCommits();
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        databaseManager.closeConnection();
    }

    @Test
    void testRunQuery() {
        assertTrue(databaseManager.runQuery("SELECT * FROM svt"));
    }
}