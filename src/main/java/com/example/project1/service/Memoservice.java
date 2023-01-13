package com.example.project1.service;

import com.example.project1.dto.MemoRequestDto;
import com.example.project1.entity.Memo;
import com.example.project1.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Memoservice {
    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto)
        memoRepository.save(memo);
        return memo;
    }
    @Transactional
    public List<Memo> getMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }
    @Transactional
    public update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
       );
        memo.update(requestDto);
        return memo.getId();
    }
    @Transactional
    public Long deleteMemo(Long id){
        memoRepository.deleteById(id);
        return id;
    }
}
