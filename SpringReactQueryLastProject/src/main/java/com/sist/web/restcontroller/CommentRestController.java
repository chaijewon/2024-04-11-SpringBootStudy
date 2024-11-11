package com.sist.web.restcontroller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
@RestController
@CrossOrigin(origins = "*")
public class CommentRestController {
   @Autowired
   private CommentDAO cDao;
   
   public Map commonsListData(int fno)
   {
	     Map map=new HashMap();
	     List<CommentEntity> list=cDao.commentListData(fno);
	  	 for(CommentEntity rb:list)
			 {
				   String day=rb.getRegdate();
				   day=day.substring(0,day.indexOf(" "));
				   rb.setRegdate(day);
			 }
	  	 int count=cDao.commentCount(fno);
	  	 map.put("list", list);
	  	 map.put("count", count);
	  	 
	  	 return map;
   }
   
   @GetMapping("/comment/list/{fno}")
   public ResponseEntity<Map> comment_list(@PathVariable("fno") int fno)
   {
	     Map map=new HashMap();
	     try
	     {
	    	 map=commonsListData(fno);
	     }catch(Exception ex)
	     {
	    	 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	     return new ResponseEntity<>(map,HttpStatus.OK);
   }
}
