package com.ashu.demo.controller;


import com.ashu.demo.model.Book;
import com.ashu.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;



    @GetMapping("/")
    public String showIndex(){

        return "index";
    }

    @GetMapping("/list")
    public String showList(Model model){
        Iterable<Book> books =bookRepository.findAll();
        model.addAttribute("books",books);

        return "listbooks";
    }

    @GetMapping("/addbook")
    public String addBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);

        return "addbook";

    }

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, BindingResult result, Model model){

        if(result.hasErrors()){
            return "addbook";
        }
        bookRepository.save(book);

        return "bookaddedconfirmation";
    }

    //list of borrowed, send to list with filtered borrowed result set

    @GetMapping("/borrow")
    public String borrowBook(Model model){
        Iterable<Book> avilableBooks = bookRepository.findByisAvilableTrue();
        if(avilableBooks==null){
            return "allBooksAreloaned";
        }
        model.addAttribute("avilableBooks",avilableBooks);

        return "borrowbook";
    }
    //borrow a book with specific Id..name update db with that info
    @RequestMapping(value="/borrow",method = RequestMethod.POST)
    public String borrowBook(@RequestParam("id") Long id, Model model)
      {
          Book bookFound = bookRepository.findOne(id);
          if(bookFound==null){
              return "The book is alaready loaned";
          }
          bookFound.setAvilable(false);
          bookRepository.save(bookFound);

          return "borrowedconfirm";




      }
    //show list of borrowed books
    @GetMapping("/return")
    public String returnBook(Model model){
     Iterable<Book> borrowedbooks = bookRepository.findByisAvilableFalse();
     model.addAttribute("borrowedbooks",borrowedbooks);

     return "returnbook";
    }

    //allow user to return a book , set the avilable flat to true.. update logic
    @RequestMapping(value = "/return/{id}",method = RequestMethod.POST)
    public String returnBook(@RequestParam("id") long id, Model model)
      {
          Book returnedBook=bookRepository.findOne(id);
          returnedBook.setAvilable(true);
          bookRepository.save(returnedBook);

          return "returnedconfirm";



      }


}
