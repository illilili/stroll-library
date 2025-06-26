package strolllibrary.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import strolllibrary.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/books")
@Transactional
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(
        value = "/booksgrantbestsellerbadge",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Book grantBestsellerBadge(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GrantBestsellerBadgeCommand grantBestsellerBadgeCommand
    ) throws Exception {
        System.out.println("##### /book/grantBestsellerBadge  called #####");
        Book book = new Book();
        book.grantBestsellerBadge(grantBestsellerBadgeCommand);
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(
        value = "/books/{id}/deletebook",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Book deleteBook(
        @PathVariable(value = "id") String id,
        @RequestBody DeleteBookCommand deleteBookCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /book/deleteBook  called #####");
        Optional<Book> optionalBook = bookRepository.findById(id);

        optionalBook.orElseThrow(() -> new Exception("No Entity Found"));
        Book book = optionalBook.get();
        book.deleteBook(deleteBookCommand);

        bookRepository.delete(book);
        return book;
    }
}
//>>> Clean Arch / Inbound Adaptor
