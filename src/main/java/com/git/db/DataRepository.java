package com.git.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.git.model.RepoData;
@Repository
public interface DataRepository extends JpaRepository<RepoData, Long> {

}
