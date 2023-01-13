package com.example.project1.controller;

import com.example.project1.dto.MemoRequestDto;
import com.example.project1.entity.Memo;
import com.example.project1.service.Memoservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Memocontroller {
    private final Memoservice memoService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping ("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoService.getMemos();
    }
    @PutMapping("/api/memos/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id,requestDto);
    }
    @DeleteMapping("/api/memos/{id}")
    public Memo deleteMemo(@PathVariable Long id){
        return memoService.delete(id);
    }
}



