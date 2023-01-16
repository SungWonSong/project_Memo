package com.example.project1.controller;

import com.example.project1.dto.MemoRequestDto;
import com.example.project1.entity.Memo;
import com.example.project1.repository.MemoRepository;
import com.example.project1.service.MemoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
    private final MemoRepository memoRepository;

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
    @GetMapping("/api/memos/{id}")
    public Optional<Memo> getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        //return memoService.update(id,requestDto);
       return memoService.update(id,requestDto);
    }
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto ){
        return memoService.deleteMemo(id,requestDto);
    }
}



