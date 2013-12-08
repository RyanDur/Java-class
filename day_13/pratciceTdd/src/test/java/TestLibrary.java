import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestLibrary {
    private Library library;
    private final LibraryUser mockLibraryUser = mock(LibraryUser.class);
    private final IdGenerator mockIdGenerator = mock(IdGenerator.class);

    @Before
    public void setup() {
        library = new LibraryImpl("Library name");
    }

    @Test
    public void shouldGetTheIdOfAnExistingUser() {
        int libraryUserId = 13;
        String libraryUserName = "Sheldon";
        when(mockLibraryUser.getId()).thenReturn(libraryUserId);
        when(mockLibraryUser.getName()).thenReturn(libraryUserName);
        when(mockIdGenerator.getInstance()).thenReturn(mockIdGenerator);

        library.setIdGenerator(mockIdGenerator);
        library.addUser(mockLibraryUser);

        int actual = library.getId(libraryUserName);

        assertThat(libraryUserId, is(equalTo(actual)));
    }

    @Test
    public void shouldAddIdToUserIfTheyDontHaveOne() {
        int invalidlibraryUserId = 0;
        int libraryUserId = 13;
        String libraryUserName = "Sheldon";

        when(mockLibraryUser.getId()).thenReturn(invalidlibraryUserId);
        when(mockLibraryUser.getName()).thenReturn(libraryUserName);

        when(mockIdGenerator.getInstance()).thenReturn(mockIdGenerator);
        when(mockIdGenerator.generateId()).thenReturn(libraryUserId);

        library.setIdGenerator(mockIdGenerator);
        library.addUser(mockLibraryUser);

        int actual = library.getId("Sheldon");

        assertThat(libraryUserId, is(equalTo(actual)));
    }
}
