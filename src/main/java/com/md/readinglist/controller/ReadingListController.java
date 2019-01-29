package com.md.readinglist.controller;

import java.util.List;

import com.md.readinglist.model.Book;
import com.md.readinglist.repository.ReadingListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class ReadingListController{
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value="/{reader}", method=RequestMethod.GET)
    public String readersBook(@PathVariable("reader")String reader,Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        
        if(readingList != null){
            model.addAttribute("books",readingList);
        }

        return "readingList";
    }

    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addtoReadingList(@PathVariable("reader")String reader,Book book) {
        book.setReader(reader);

        readingListRepository.save(book);

        return "redirect:/{reader}";
    }
    
    
}