import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestLibrary {
    private Library library;
    private final LibraryUser mockLibraryUser = mock(LibraryUser.class);
    private final LibraryUser mockLibraryUser1 = mock(LibraryUser.class);
    private final IdGenerator mockIdGenerator = mock(IdGenerator.class);
    private final Book mockBook = mock(Book.class);

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

    @Test
    public void shouldBeAbleToCheckoutABook() {
        String title = "Pride and Prejudice";
        when(mockBook.isTaken()).thenReturn(false);
        when(mockBook.getTitle()).thenReturn(title);

        library.addBook(mockBook);

        assertThat(mockBook, is(equalTo(library.takeBook(title))));
    }

    @Test
    public void shouldBeAbleToReturnABook() {
        String title = "Pride and Prejudice";
        when(mockBook.isTaken()).thenReturn(true);
        when(mockBook.getTitle()).thenReturn(title);

        library.addBook(mockBook);

        assertThat(null, is(equalTo(library.takeBook(title))));

        when(mockBook.isTaken()).thenReturn(false);
        when(mockBook.getTitle()).thenReturn(title);

        assertThat(mockBook, is(equalTo(library.takeBook(title))));
    }

    @Test
    public void shouldKnowHowManyBooksALibraryHas() {
        assertThat(0, is(equalTo(library.getBookCount())));
        library.addBook(mockBook);
        assertThat(1, is(equalTo(library.getBookCount())));
    }

    @Test
    public void shouldKnowHowManyUsersALibraryHas() {
        assertThat(0, is(equalTo(library.getReaderCount())));
        library.addUser(mockLibraryUser);
        assertThat(1, is(equalTo(library.getReaderCount())));

    }

    @Test
    public void shouldKnowHowManyBooksHaveBeenBorrowed() {
        when(mockBook.isTaken()).thenReturn(false);
        library.addBook(mockBook);
        assertThat(0, is(equalTo(library.getBookBorrowedCount())));

        when(mockBook.isTaken()).thenReturn(true);
        assertThat(1, is(equalTo(library.getBookBorrowedCount())));
    }

    @Test
    public void shouldGetTheUsersWhoHaveBorrowedBooks() {
        LibraryUser[] expected = {mockLibraryUser};
        when(mockLibraryUser.isBorrowingBooks()).thenReturn(true);
        when(mockLibraryUser1.isBorrowingBooks()).thenReturn(false);
        when(mockLibraryUser.getName()).thenReturn("Julio");
        when(mockLibraryUser1.getName()).thenReturn("Juan");
        library.addUser(mockLibraryUser);
        library.addUser(mockLibraryUser1);

        assertThat(expected, is(equalTo(library.getUsersBorrowingBooks())));
    }

    @Test
    public void shouldGetTheUsers() {
        LibraryUser[] expected = {mockLibraryUser};
        when(mockLibraryUser.getName()).thenReturn("Julio");
        library.addUser(mockLibraryUser);
        assertThat(expected, is(equalTo(library.getUsers())));

        LibraryUser[] expected1 = {mockLibraryUser, mockLibraryUser1};
        when(mockLibraryUser1.getName()).thenReturn("Juan");
        library.addUser(mockLibraryUser1);
        assertThat(expected1, is(equalTo(library.getUsers())));
    }

    @Test
    public void shouldGiveAListOfUsersWhoHaveMoreBooksThanAllowedIfThereIsAChangeInNumberOfBooksAllowed() {
        when(mockLibraryUser.getName()).thenReturn("Julio");
        when(mockLibraryUser1.getName()).thenReturn("Juan");

        library.addUser(mockLibraryUser);
        library.addUser(mockLibraryUser1);

        String[] arr = {"foo","bar","bah"};
        when(mockLibraryUser.getBorrowedBookTitles()).thenReturn(arr);
        when(mockLibraryUser1.getBorrowedBookTitles()).thenReturn(arr);

        when(mockLibraryUser.isBorrowingBooks()).thenReturn(true);
        when(mockLibraryUser1.isBorrowingBooks()).thenReturn(true);

        LibraryUser[] expected = {};
        assertThat(expected, is(equalTo(library.setMaxBooksPerUser(3))));

        LibraryUser[] expected1 = {mockLibraryUser, mockLibraryUser1};
        assertThat(expected1, is(equalTo(library.setMaxBooksPerUser(2))));

        String[] arr1 = {"foo","bar"};
        when(mockLibraryUser1.getBorrowedBookTitles()).thenReturn(arr1);

        LibraryUser[] expected2 = {mockLibraryUser};
        assertThat(expected2, is(equalTo(library.setMaxBooksPerUser(2))));
    }
}
