package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.CommentEntity;
@Repository
public interface CommentDAO extends JpaRepository<CommentEntity, Integer>{
    @Query(value="SELECT * FROM reactcomment "
    		    +"WHERE fno=:fno ORDER BY no DESC",nativeQuery = true)
    public List<CommentEntity> commentListData(@Param("fno") int fno);
    
    @Query(value = "SELECT COUNT(*) FROM reactcomment WHERE fno=:fno",nativeQuery = true)
    public int commentCount(@Param("fno") int fno);
}
