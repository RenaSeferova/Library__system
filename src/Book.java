import java.util.Objects;

public class Book {
 public String title;
 public String author;
 public boolean isBorrowed ;


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;



    }
}
