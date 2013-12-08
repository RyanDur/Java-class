import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestLibraryUser {
    private final Library mockLibrary = mock(Library.class);
    private final Book mockBook = mock(Book.class);
    private LibraryUser lu;

    @Before
    public void setup() {
        lu = new LibraryUser("name");
    }

    @Test
    public void shouldRegisterTheUserForALibrary() {
        String libraryName = "Library name";
        when(mockLibrary.getName()).thenReturn(libraryName);
        lu.registerLibrary(mockLibrary);
        assertThat(libraryName, is(equalTo(lu.getLibrary().getName())));
    }

    @Test
    public void shouldHaveAnIDAfterRegisteringForALibrary() {
        int libraryUserID = 13;
        when(mockLibrary.generateUserId()).thenReturn(libraryUserID);
        lu.registerLibrary(mockLibrary);
        assertThat(libraryUserID, is(equalTo(lu.getId())));
    }

    @Test
    public void shouldBeAbleToBorrowABook() {
        String title = "faf";
        String[] expected = {title};
        when(mockLibrary.takeBook(anyString())).thenReturn(mockBook);
        when(mockBook.getTitle()).thenReturn(title);

	lu.registerLibrary(mockLibrary);
        lu.borrowBook(title);
        assertThat(expected, is(equalTo(lu.getBorrowedBookTitles())));
    }
}
