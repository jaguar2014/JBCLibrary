package com.ashu.demo.repository;

import com.ashu.demo.model.BorrowedBookArchive;
import org.springframework.data.repository.CrudRepository;

public interface ArchiveRepo extends CrudRepository<BorrowedBookArchive,Long> {
}
