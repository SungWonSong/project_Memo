package com.example.project1.repository;

import com.example.project1.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo,Long>{
    List<Memo> findAllByOrderByCreatedAtDesc();

    @Override
    Optional<Memo> findById(Long Id);

}
