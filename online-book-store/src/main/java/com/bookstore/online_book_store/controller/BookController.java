package com.bookstore.online_book_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bookstore.online_book_store.model.Book;
import com.bookstore.online_book_store.model.repo.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookservice;

    // 1️⃣ LOGIN PAGE
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // 2️⃣ SIGNUP PAGE (SHOW)
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // 3️⃣ SIGNUP FORM SUBMIT (IMPORTANT)
    @PostMapping("/signup")
    public String handleSignup(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        // TEMP: just verify data is coming
        System.out.println("Signup Data:");
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);

        // After signup → go to login
        return "redirect:/";
        
    }
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String email,
            @RequestParam String password) {

        System.out.println("LOGIN HIT");
        System.out.println(email);
        System.out.println(password);

        // TEMP: always allow login
        return "redirect:/home";
    }

    // 4️⃣ HOME PAGE
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    // 5️⃣ BOOK LIST
    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", bookservice.getAllBooks());
        return "book-list";
    }

    // 6️⃣ ADD BOOK
    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute Book book) {
        bookservice.saveBook(book);
        return "redirect:/books";
    }

    // 7️⃣ EDIT BOOK
    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book",
                bookservice.getBookById(id).orElseThrow());
        return "edit-book";
    }

    // 8️⃣ DELETE BOOK
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookservice.deleteBook(id);
        return "redirect:/books";
    }
}