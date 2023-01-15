package com.example.project1.service;

import com.example.project1.dto.MemoRequestDto;
import com.example.project1.entity.Memo;
import com.example.project1.repository.MemoRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Optional<Memo> getMemo(Long id) {
        return memoRepository.findById(id);
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if (requestDto.getPasswords().equals(memo.getPasswords())) {
            memo.update(requestDto);
            return memo.getId();
        }
        else{
            System.out.println("비밀번호가 일치하지 않습니다");
        }

        return id;
    }
        @Transactional
        public Long deleteMemo (Long id){
            memoRepository.deleteById(id);
            return id;
        }
    }

