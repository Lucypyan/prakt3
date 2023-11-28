package com.example.demo.Controlers;

import com.example.demo.Service.BookService;
import com.example.demo.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/create")
    public String createBookForm(Book book) {
        return "book-create";
    }

    @PostMapping("/create")
    public String createBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        if (book == null) {
            return "book-not-found";
        }
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/update")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
    // В BookController.java

    @GetMapping("/search")
    public String searchBooks(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Book> searchResults = bookService.searchBooks(search); // Ваш сервис должен обрабатывать поиск
        model.addAttribute("searchResults", searchResults);
        return "book-search-results";
    }


}
