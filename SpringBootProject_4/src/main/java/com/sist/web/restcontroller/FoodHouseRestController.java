package com.sist.web.restcontroller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.dao.*;
@RestController
@CrossOrigin(origins = "*") // ip http://localhost:3000 
// port가 같은 경우에만 접근이 가능 
// => 3000 => 80 : 해제 
public class FoodHouseRestController {
   @Autowired
   private FoodHouseDAO fDao;
   // 자동 JSON변환 => Jackson => ObjectMapper 
   @GetMapping("food/main_react")
   public List<FoodHouseVO> foodMainTopData(){
	   List<FoodHouseVO> list=fDao.foodHitTop9();
	   return list;
   }
}
